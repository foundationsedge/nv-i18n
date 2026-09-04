Overview
--------

We have forked the repository, so have inherited some tasks in progress or not started.

Some [Issues](https://github.com/foundationsedge/nv-i18n/issues) will be listed on the issues page as they come up.

Roadmap
-------

The [immediate roadmap](https://github.com/foundationsedge/nv-i18n/issues/19) was detailed but to replicate and
expand that here:

- [X] fork project into GitHub
- [X] update to work and publish baseline project `1.30`
- [X] bring in outstanding PRs that look valid
- [X] publish version including outstanding PR and our private project depends on `1.32`
- [x] delete redundant branches
- [X] update `CountryCode` to latest ISO standard
  - [ ] compare to the ISO publication
- [X] update `CurrencyCode` to latest ISO standard
  - [ ] compare to the ISO publication
- [ ] update `LanguageAlpha3Code` to latest ISO standard
  - [ ] compare to the ISO publication
- [x] update `LanguageCode` to latest ISO standard
  - [ ] compare to the ISO publication
- [ ] update `LocaleCode` to JDK8 List of 1 and 2 part Locales.
  - [ ] update `LocaleCode` to JDK25 List of 1 and 2 part Locales?
  - [ ] consider 3 part locales?
- [X] update `ScriptCode` to latest ISO standard (to merge)
  - [ ] compare to the ISO publication
- [ ] convert all asserts to use the `assertJ` assertions
- [ ] remove redundant tests
- [ ] refactor tests to have meaningful names
- [x] give meaningful captions to Javadoc tables (to get things working we just dropped in "placeholder")
- [ ] clean up outstanding mutants identified from Pitest
- [ ] consider adding SpotBugs
- [ ] consider adding ArchUnit (very unlikely)
- [ ] consider wiring up PiTest to build pipeline
- [x] gain passing badge at [OSSF Badge](https://www.bestpractices.dev)
  - [ ] work towards silver badge
- [ ] publish any breaking changes with a major version bump (v2.x.x)
  - [ ] no public methods return `null`
  - [ ] potentially project and package names (unlikely)
