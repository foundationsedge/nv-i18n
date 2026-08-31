nv-i18n
=======

![GitHub commits since latest release](https://img.shields.io/github/commits-since/foundationsedge/nv-i18n/latest)
![GitHub contributors](https://img.shields.io/github/contributors/foundationsedge/nv-i18n)
![Maven Central Last Update](https://img.shields.io/maven-central/last-update/uk.co.foundationsedge/nv-i18n)
[![OpenSSF Best Practices](https://www.bestpractices.dev/projects/14193/badge)](https://www.bestpractices.dev/projects/14193)
[![OpenSSF Scorecard](https://api.scorecard.dev/projects/github.com/foundationsedge/nv-i18n/badge)](https://scorecard.dev/viewer/?uri=github.com/foundationsedge/nv-i18n)
![OSS Lifecycle](https://img.shields.io/osslifecycle?file_url=https%3A%2F%2Fraw.githubusercontent.com%2Ffoundationsedge%2Fnv-i18n%2Fmaster%2FOSSMETADATA)
![GitHub License](https://img.shields.io/github/license/foundationsedge/nv-i18n)
[![jdk badge](https://img.shields.io/badge/jdk-8-green.svg)](https://adoptium.net/en-GB/temurin/releases)
[![MvnRepository](https://badges.mvnrepository.com/badge/uk.co.foundationsedge/nv-i18n/badge.svg)](https://mvnrepository.com/artifact/uk.co.foundationsedge/nv-i18n/)
[![Quality gate status](https://sonarcloud.io/api/project_badges/measure?project=foundationsedge_nv-i18n&metric=alert_status)](https://sonarcloud.io/summary/new_code?id=foundationsedge_nv-i18n)

<!--![Libraries.io dependency status for GitHub repo](https://img.shields.io/librariesio/github/foundationsedge/nv-i18n)-->
<!--![Libraries.io dependency status for latest release](https://img.shields.io/librariesio/release/maven/uk.co.foundationsedge%3Anv-i18n)-->
<!--![Dependent repos (via libraries.io)](https://img.shields.io/librariesio/dependent-repos/maven/uk.co.foundationsedge%3Anv-i18n)-->
<!--![GitHub code size in bytes](https://img.shields.io/github/languages/code-size/foundationsedge/nv-i18n)-->

Overview
--------

nv-i18n solves the problem of handling international codes in Java applications: it
provides ready-made, type-safe enums for country, language, script and currency codes
so you do not have to build or maintain these lists yourself.

To install it, add the Maven or Gradle dependency shown below. To use it, reference
the enums directly (e.g. `CountryCode.JP.getName()`); no setup or configuration is
required. The library is read-only reference data and processes no untrusted input,
so secure use simply means keeping the dependency up to date.

Package to support internationalization, containing ISO 3166-1 country code enum,
ISO 639-1 language code enum, ISO 15924 script code enum, etc.

| Class                | Description                                                  | Last Updated                     |
|:---------------------|:-------------------------------------------------------------|----------------------------------|
| `CountryCode`        | ISO 3166-1 country code.                                     | 2026-06-24 (Wikipedia as source) |
| `LanguageCode`       | ISO 639-1 language code.                                     | 2026-08-07 (Wikipedia as source) |
| `LanguageAlpha3Code` | ISO 639-2 language code.                                     | unknown                          |
| `LocaleCode`         | Available locales whose format match either 'xx' or 'xx-XX'. | unknown                          |
| `ScriptCode`         | ISO 15924 script code.                                       | 2026-07-24 (Wikipedia as source) |
| `CurrencyCode`       | ISO 4217 currency code.                                      | 2026-07-17 (Wikipedia as source) |


License
-------

  Apache License, Version 2.0


Maven
-----

```xml
<dependency>
    <groupId>uk.co.foundationsedge</groupId>
    <artifactId>nv-i18n</artifactId>
    <version>version-number</version>
</dependency>
```

For latest version look at [sonatype](https://central.sonatype.com/artifact/uk.co.foundationsedge/nv-i18n)


Gradle
------

```gradle
dependencies {
    compile 'uk.co.foundationsedge:nv-i18n:version-number'
}
```


OSGi
----

    Bundle-SymbolicName: uk.co.foundationsedge
    Export-Package: uk.co.foundationsedge;version="version-number"


Source Code
-----------

  <code>https://github.com/foundationsedge/nv-i18n.git</code>


Example
-------

```java
class Example {
  public static void main(String[] args) {
    // List all the country codes.
    for (CountryCode code : CountryCode.values()) {
      System.out.format("[%s] %s\n", code, code.getName());
    }

    // List all the language codes.
    for (LanguageCode code : LanguageCode.values()) {
      System.out.format("[%s] %s\n", code, code.getName());
    }

    // List all the locale codes.
    for (LocaleCode code : LocaleCode.values()) {
      String language = code.getLanguage().getName();
      String country = code.getCountry() != null
        ? code.getCountry().getName()
        : null;

      System.out.format("[%s] %s, %s\n", code, language, country);
    }

    // List all the script codes.
    for (ScriptCode code : ScriptCode.values()) {
      System.out.format("[%s] %03d %s\n", code, code.getNumeric(), code.getName());
    }

    // List all the currency codes.
    for (CurrencyCode code : CurrencyCode.values()) {
      System.out.format("[%s] %03d %s\n", code, code.getNumeric(), code.getName());
    }
  }
}
```


See Also
--------

* [nv-i18n @ GitHub](https://github.com/TakahikoKawasaki/nv-i18n)
* Country Code [ISO 3166-1](http://en.wikipedia.org/wiki/ISO_3166-1)
* Country Code [ISO 3166-1 alpha-2](http://en.wikipedia.org/wiki/ISO_3166-1_alpha-2)
* Country Code [ISO 3166-1 alpha-3](http://en.wikipedia.org/wiki/ISO_3166-1_alpha-3)
* Country Code [ISO 3166-1 numeric](http://en.wikipedia.org/wiki/ISO_3166-1_numeric)
* Language Code [ISO 639-1](http://en.wikipedia.org/wiki/ISO_639-1)
* Language Alpha3 Code [ISO 639-2](http://en.wikipedia.org/wiki/ISO_639-2)
* Script Code [ISO 15924](http://en.wikipedia.org/wiki/ISO_15924)
* Currency Code [ISO 4217](http://en.wikipedia.org/wiki/ISO_4217)


TODO
----

* To add missing entries to CountryCode.
* To add international telephone dial number.


Note
----

This nv-i18n supersedes https://github.com/TakahikoKawasaki/nv-i18n/
This nv-i18n supersedes https://github.com/TakahikoKawasaki/CountryCode


Original Author
------

Takahiko Kawasaki, [Authlete, Inc.](https://www.authlete.com/)

Contributors
------

<a href="https://github.com/foundationsedge/nv-i18n/graphs/contributors">
  <img src="https://contrib.rocks/image?repo=foundationsedge/nv-i18n" />
</a>

Made with [contrib.rocks](https://contrib.rocks).
