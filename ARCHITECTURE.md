# Architecture

The architecture of the project is very simple.

We have classes representing Standards.
These sometimes call each other, but they are plain enums with some useful helper methods.

We _did_ fork this project though so we may need to review their relationship, and potentially make
breaking changes if we want to introduce more builder/helper style classes.

## Viewable on SonarCloud

[Architecture Diagram](https://sonarcloud.io/project/current_architecture?id=foundationsedge_nv-i18n)

## Null

Currently, some methods are returning `null` from public methods. We are considering if that should change.
All the enums have an `undefined` value, which would be a safer return value from these methods.
We are used to roughly following the [Java for Small Teams](https://ncrcoe.gitbooks.io/java-for-small-teams/)
Guidance, which includes a section to
[avoid null](https://ncrcoe.gitbooks.io/java-for-small-teams/content/style/600_avoid_null.html)

## Package

The current package for classes is `com.neovisionaries.*` bases on the project we forked from.
Changing this would be a breaking change so we may consider it in future, but it is not on our most immediate
[Roadmap](https://github.com/foundationsedge/nv-i18n/blob/master/ROADMAP.md)
