# nv-i18n Sample Project

A minimal, standalone Maven project showing how to use the
[nv-i18n](https://github.com/foundationsedge/nv-i18n) standards library as a dependency.

This project is **not** part of the `nv-i18n-parent` reactor build: it has its own `groupId`, `artifactId` and version,
and is never deployed to Maven Central. It depends on the *released* `uk.co.foundationsedge:nv-i18n`
artifact from Maven Central.

## Layout

| File                                                            | Purpose                                                                                                   |
|:----------------------------------------------------------------|:----------------------------------------------------------------------------------------------------------|
| `pom.xml`                                                       | Declares the dependency on the released `nv-i18n` artifact. Bump `nv-i18n.version` to track new releases. |
| `src/main/java/uk/co/foundationsedge/samples/i18n/Example.java` | A small `main` class exercising the library's enums.                                                      |

## Build and run

```sh
mvn package
mvn exec:java
```

## Using the library in your own project

Add the dependency to your `pom.xml`:

```xml

<dependency>
  <groupId>uk.co.foundationsedge</groupId>
  <artifactId>nv-i18n</artifactId>
  <version>1.34.1</version>
</dependency>
```

…then reference the enums directly, e.g. `CountryCode.JP.getName()`. No setup or configuration is required.
