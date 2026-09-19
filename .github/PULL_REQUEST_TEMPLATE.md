**Description**
What does this PR change, and why? Link any related issue(s).

**Checklist**
- [ ] Changes are squashed down into 1 commit
- [ ] Tests cover the change and introduce no new PiTest mutants (`mvn org.pitest:pitest-maven:mutationCoverage`)
- [ ] SpotBugs/FindSecBugs pass locally (`mvn spotbugs:check`) — this also runs automatically as part of `mvn package`
- [ ] If this is a breaking change, it's waiting for a major version bump rather than being included in a minor/patch release
- [ ] If this changes an ISO standard mapping, it links to the official source used
- [ ] The [CLA](https://cla-assistant.io/foundationsedge/nv-i18n) has been signed
