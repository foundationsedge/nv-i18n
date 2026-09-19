#!/bin/bash -eu
# Copyright 2021 Google Inc.
#
# Licensed under the Apache License, Version 2.0 (the "License");
# you may not use this file except in compliance with the License.
# You may obtain a copy of the License at
#
#      http://www.apache.org/licenses/LICENSE-2.0
#
# Unless required by applicable law or agreed to in writing, software
# distributed under the License is distributed on an "AS IS" BASIS,
# WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
# See the License for the specific language governing permissions and
# limitations under the License.
#
################################################################################

# Step 1: build the project itself, so fuzz targets can reference its classes,
# and gather every test-scope dependency (e.g. assertj) that fuzz targets may
# want to use, without running the project's own test suite.
mvn -B -q -DskipTests package
mkdir -p "$OUT"/libs
mvn -B -q dependency:copy-dependencies -DincludeScope=test -DoutputDirectory="$OUT"/libs
# Copy the project's own compiled classes directly into $OUT so they are on
# the fuzz target's runtime classpath (see RUNTIME_CLASSPATH below), not just
# its compile-time one.
cp -r target/classes/. "$OUT"/

BUILD_CLASSPATH="target/classes:$OUT/libs/*:$JAZZER_API_PATH"

# All class and jar files lie in the same directory as the fuzzer at runtime.
# jazzer_driver's --cp does not understand the "dir/*" JVM classpath wildcard
# (unlike a plain `java -cp`), so each jar under libs/ must be listed out
# individually rather than relying on a glob.
RUNTIME_CLASSPATH=\$this_dir
for lib in "$OUT"/libs/*.jar; do
  RUNTIME_CLASSPATH="$RUNTIME_CLASSPATH:\$this_dir/libs/$(basename "$lib")"
done

# Step 2: build one fuzz target per *Fuzzer.java / *FuzzerNative.java file
# (a class with a static fuzzerTestOneInput method, no package declaration),
# per the standard OSS-Fuzz JVM convention.
# https://google.github.io/oss-fuzz/getting-started/new-project-guide/jvm-lang/
for fuzzer in $(find $SRC -name '*Fuzzer.java' -or -name '*FuzzerNative.java'); do
  fuzzer_basename=$(basename -s .java $fuzzer)
  javac -cp $BUILD_CLASSPATH -d $OUT $fuzzer

  driver=jazzer_driver

  cp .clusterfuzzlite/default.options $OUT/"$fuzzer_basename".options
  # Create execution wrapper.
  echo "#!/bin/sh
# LLVMFuzzerTestOneInput for fuzzer detection.
this_dir=\$(dirname \"\$0\")
LD_LIBRARY_PATH=\"$JVM_LD_LIBRARY_PATH\":\$this_dir/native \
ASAN_OPTIONS=\$ASAN_OPTIONS:symbolize=1:external_symbolizer_path=\$this_dir/llvm-symbolizer:detect_leaks=0 \
\$this_dir/$driver --agent_path=\$this_dir/jazzer_agent_deploy.jar \
--cp=\"$RUNTIME_CLASSPATH\" \
--target_class=$fuzzer_basename \
--jvm_args=\"-Xmx2048m\" \
\$@ -use_value_profile=1" > $OUT/$fuzzer_basename
  chmod +x $OUT/$fuzzer_basename
done
