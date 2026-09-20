# Dependencies

We take the approach of trying to minimise the amount of dependencies required.

Currently, you can see them on the [Dependency Graph](https://github.com/foundationsedge/nv-i18n/network/dependencies)

We have Dependabot set to check for updates and raise PRs on our Maven (`pom.xml`) and
GitHub Actions dependencies.

A couple of things fall outside Dependabot's ecosystems and are instead kept current by
scheduled workflows that run the relevant tool's own update command and open a pull request:

* [`.pre-commit-config.yaml`](https://github.com/foundationsedge/nv-i18n/blob/master/.pre-commit-config.yaml)
  hook revisions, via
  [`pre-commit-autoupdate.yml`](https://github.com/foundationsedge/nv-i18n/blob/master/.github/workflows/pre-commit-autoupdate.yml).
* The Maven Wrapper (`.mvn/wrapper/maven-wrapper.properties`, `mvnw`, `mvnw.cmd`), via
  [`maven-wrapper-autoupdate.yml`](https://github.com/foundationsedge/nv-i18n/blob/master/.github/workflows/maven-wrapper-autoupdate.yml).

## Shipping code

No dependencies

## Test

* [AssertJ](https://github.com/assertj/assertj)
* [JUnit](https://github.com/junit-team/junit-framework)

## Plugins

We have plugins for PiTest, and ones required to build and publish the library.

These can be seen in [pom.xml](https://github.com/foundationsedge/nv-i18n/pom.xml) and change too frequently to list here.

## GitHub Actions

Our GitHub Actions are public and can be seen under `https://github.com/foundationsedge/nv-i18n/.github`.
We have updated these to use hashes rather than version numbers.

## JDK

The lowest JDK this project supports is JDK 8.
The tests require JDK 17.
We use the latest LTS, JDK 25, to build and publish artefacts.
