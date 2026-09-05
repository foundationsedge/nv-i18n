/*
 * Copyright (C) 2013-2014 Neo Visionaries Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.neovisionaries.i18n;


import java.util.List;
import java.util.Locale;
import org.junit.jupiter.api.Test;

import static com.neovisionaries.i18n.ScriptCode.getByCode;
import static com.neovisionaries.i18n.ScriptCode.getByCodeIgnoreCase;
import static com.neovisionaries.i18n.ScriptCode.getByLocale;
import static org.assertj.core.api.Assertions.assertThat;

class ScriptCodeTest {

  @Test
  void getByCodeWithExactCaseReturnsMatchingScriptCode() {
    assertThat(getByCode("Jpan")).isSameAs(ScriptCode.Jpan);
  }

  @Test
  void getByCodeWithMismatchedCaseReturnsNull() {
    assertThat(getByCode("JPan")).isNull();
    assertThat(getByCode("JpAn")).isNull();
    assertThat(getByCode("JpaN")).isNull();
    assertThat(getByCode("jpan")).isNull();
    assertThat(getByCode("jPan")).isNull();
    assertThat(getByCode("jpAn")).isNull();
    assertThat(getByCode("jpaN")).isNull();
  }

  @Test
  void getByCodeWithCaseSensitiveTrueAndExactCaseReturnsMatchingScriptCode() {
    assertThat(getByCode("Jpan", true)).isSameAs(ScriptCode.Jpan);
  }

  @Test
  void getByCodeWithCaseSensitiveTrueAndMismatchedCaseReturnsNull() {
    assertThat(getByCode("JPan", true)).isNull();
    assertThat(getByCode("JpAn", true)).isNull();
    assertThat(getByCode("JpaN", true)).isNull();
    assertThat(getByCode("jpan", true)).isNull();
    assertThat(getByCode("jPan", true)).isNull();
    assertThat(getByCode("jpAn", true)).isNull();
    assertThat(getByCode("jpaN", true)).isNull();
  }

  @Test
  void getByCodeWithNullOrInvalidStringReturnsNull() {
    assertThat(getByCode(null)).isNull();
    assertThat(getByCode("")).isNull();
    assertThat(getByCode("?")).isNull();
    assertThat(getByCode("??")).isNull();
    assertThat(getByCode("???")).isNull();
    assertThat(getByCode("????")).isNull();
    assertThat(getByCode("?????")).isNull();
  }

  @Test
  void getByCodeWithCaseSensitiveTrueAndNullOrInvalidStringReturnsNull() {
    assertThat(getByCode(null, true)).isNull();
    assertThat(getByCode("", true)).isNull();
    assertThat(getByCode("?", true)).isNull();
    assertThat(getByCode("??", true)).isNull();
    assertThat(getByCode("???", true)).isNull();
    assertThat(getByCode("????", true)).isNull();
    assertThat(getByCode("?????", true)).isNull();
  }

  @Test
  void getByCodeWithNumericCodeZeroReturnsNull() {
    assertThat(getByCode(0)).isNull();
  }

  @Test
  void getByCodeWithValidNumericCodeReturnsMatchingScriptCode() {
    assertThat(getByCode(413)).isSameAs(ScriptCode.Jpan);
  }

  @Test
  void findByNameWithRegexReturnsMatchingScriptCodes() {
    List<ScriptCode> list = ScriptCode.findByName("Egyptian.*");

    assertThat(list)
        .hasSize(3)
        .containsExactlyInAnyOrder(ScriptCode.Egyd, ScriptCode.Egyh, ScriptCode.Egyp);
  }

  @Test
  void getByCodeWithCaseSensitiveFalseIgnoresCase() {
    assertThat(getByCode("Jpan", false)).isSameAs(ScriptCode.Jpan);
    assertThat(getByCode("JPan", false)).isSameAs(ScriptCode.Jpan);
    assertThat(getByCode("JpAn", false)).isSameAs(ScriptCode.Jpan);
    assertThat(getByCode("JpaN", false)).isSameAs(ScriptCode.Jpan);
    assertThat(getByCode("jpan", false)).isSameAs(ScriptCode.Jpan);
    assertThat(getByCode("jPan", false)).isSameAs(ScriptCode.Jpan);
    assertThat(getByCode("jpAn", false)).isSameAs(ScriptCode.Jpan);
    assertThat(getByCode("jpaN", false)).isSameAs(ScriptCode.Jpan);
  }

  @Test
  void getByCodeIgnoreCaseIgnoresCase() {
    assertThat(getByCodeIgnoreCase("Jpan")).isSameAs(ScriptCode.Jpan);
    assertThat(getByCodeIgnoreCase("JPan")).isSameAs(ScriptCode.Jpan);
    assertThat(getByCodeIgnoreCase("JpAn")).isSameAs(ScriptCode.Jpan);
    assertThat(getByCodeIgnoreCase("JpaN")).isSameAs(ScriptCode.Jpan);
    assertThat(getByCodeIgnoreCase("jpan")).isSameAs(ScriptCode.Jpan);
    assertThat(getByCodeIgnoreCase("jPan")).isSameAs(ScriptCode.Jpan);
    assertThat(getByCodeIgnoreCase("jpAn")).isSameAs(ScriptCode.Jpan);
    assertThat(getByCodeIgnoreCase("jpaN")).isSameAs(ScriptCode.Jpan);
  }

  @Test
  void getByCodeHandlesUndefinedScriptCode() {
    assertThat(getByCode("Undefined")).isSameAs(ScriptCode.Undefined);
    assertThat(getByCode("UNDEFINED")).isNull();
    assertThat(getByCodeIgnoreCase("UNDEFINED")).isSameAs(ScriptCode.Undefined);
  }

  @Test
  void getByLocaleReturnsMatchingScriptCode() {
    assertThat(getByLocale(new Locale.Builder().build())).isSameAs(ScriptCode.Undefined);
    assertThat(getByLocale(new Locale.Builder().setScript(ScriptCode.Jpan.name()).build())).isSameAs(ScriptCode.Jpan);
  }

  @Test
  void toLocaleReturnsMatchingLocale() {
    assertThat(ScriptCode.Undefined.toLocale()).isEqualTo(new Locale.Builder().build());
    assertThat(ScriptCode.Jpan.toLocale()).isEqualTo(new Locale.Builder().setScript(ScriptCode.Jpan.name()).build());
  }

  @Test
  void getNameReturnsMatchingName() {
    assertThat(ScriptCode.Latn.getName()).isEqualTo("Latin");
  }

  @Test
  void getNumericReturnsMatchingNumericValue() {
    assertThat(ScriptCode.Latn.getNumeric()).isEqualTo(215);
  }

  @Test
  void getNumericReturnsMatchingNumericValueCyrillic() {
    assertThat(ScriptCode.Cyrl.getNumeric()).isEqualTo(220);
  }
}
