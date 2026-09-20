# nv-i18n Project Governance

[Instructions](https://github.com/cncf/project-template/blob/main/GOVERNANCE-maintainer.md)

The nv-i18n project is dedicated to providing a library of classes to allow access to up-to-date Standards
related to internationalisation in Java.

This governance explains how the project is run.

- [Values](#values)
- [Maintainers](#maintainers)
- [Becoming a Maintainer](#becoming-a-maintainer)
- [Meetings](#meetings)
- [Security Response Team](#security-response-team)
- [Voting](#voting)
- [Modifications](#modifying-this-charter)

Note: This template refers to 2/3 support for changes as a baseline.
So this just gives an outline on the kind of thing we will/won't do.

As there are currently 2 Maintainers we are going by the rule of
don't do something if the other objects, defaulting to the status quo.
We have set GitHub to require a review of all MRs, so one of us can't
push through a change without the other approving it. Unless they also
turn off that rule.

## Values

The nv-i18n and its leadership embrace the following values:

* Openness: Communication and decision-making happens in the open and is discoverable for future
 reference. As much as possible, all discussions and work take place in public
 forums and open repositories.

* Fairness: All stakeholders have the opportunity to provide feedback and submit
 contributions, which will be considered on their merits.

* Community over Product or Company: Sustaining and growing our community takes
 priority over shipping code or sponsors' organisational goals. Each
 contributor participates in the project as an individual.

* Vendor Neutrality: The project direction and decisions are not controlled by
 any single organisation. Maintainer selection, roadmap prioritisation, and
 release decisions are made based on project merit, not employer affiliation.

* Inclusivity: We innovate through different perspectives and skill sets, which
 can only be accomplished in a welcoming and respectful environment.

* Participation: Responsibilities within the project are earned through
 participation, and there is a clear path up the contributor ladder into leadership
 positions.

## Maintainers

nv-i18n Maintainers have write access to the project GitHub repository.
They can merge patches from others. Maintainers collectively manage the project's
resources and contributors.

This privilege is granted with some expectation of responsibility: maintainers
are people who care about the nv-i18n project and want to help it grow and
improve. A maintainer is not just someone who can make changes, but someone who
has demonstrated their ability to:
* collaborate with the team
* get the most knowledgeable people to review code and docs
* contribute high-quality code
* follow through to fix issues.

A maintainer is a contributor to the project's success and a citizen helping
the project succeed.

The collective team of all Maintainers is known as the Maintainer Council, which
is the governing body for the project.

### Becoming a Maintainer

To become a Maintainer you need to demonstrate the following:

* commitment to the project:
  * participate in discussions, contributions, code and documentation reviews for 6 months or more,
    * perform reviews for 5 non-trivial pull requests,
    * contribute 5 non-trivial pull requests and have them merged,
* ability to write quality code and/or documentation,
* ability to collaborate with the team,
* understanding of how the team works (policies, processes for testing and code review, etc),
* understanding of the project's code base and coding and documentation style.

A new Maintainer must be proposed by an existing maintainer by sending a message to the
[developer mailing list](https://nv-i18n.discourse.group/). A simple majority vote of existing Maintainers
approves the application. Maintainer nominations will be evaluated without prejudice
to employer or demographics and should consider the organisational diversity of the
maintainer group.

Maintainers who are selected will be granted the necessary GitHub rights,
and invited to the [private maintainer mailing list](https://nv-i18n-maintainers.discourse.group/)

### Removing a Maintainer

Maintainers may resign at any time if they feel that they will not be able to
continue fulfilling their project duties.

Maintainers may also be removed after being inactive, failure to fulfill their
Maintainer responsibilities, violating the Code of Conduct, or other reasons.
Inactivity is defined as a period of very low or no activity in the project
for 12 months or more, with no definite schedule to return
to full Maintainer activity.

A Maintainer may be removed at any time by a 2/3 vote of the remaining maintainers.

### Emeritus Maintainers

Depending on the reason for removal or resignation, a Maintainer may be converted
to Emeritus status. Emeritus Maintainers are recognised for their past contributions
and may still be consulted on project matters, but do not have voting rights or
merge access.

An Emeritus Maintainer may be reinstated to active Maintainer status by a simple
majority vote of existing Maintainers, provided they meet the current Maintainer
requirements and can commit to ongoing participation.

## Meetings

Time zones permitting, Maintainers participate in the
developer meeting, which occur regularly on Friday afternoons (UK time ~1-5pm).

Once we stabilise the code base and get all standards up to date, this frequency
is expected to drop.

Maintainers will also have closed meetings in order to discuss security reports
or Code of Conduct violations. Such meetings should be scheduled by any
Maintainer on receipt of a security issue or CoC report.All current Maintainers
must be invited to such closed meetings, except for any Maintainer who is
accused of a CoC violation.

## Security Response Team

The Maintainers will appoint a Security Response Team to handle security reports.
This committee may simply consist of the Maintainer Council themselves. If this
responsibility is delegated, the Maintainers will appoint a team of at least two
contributors to handle it. The Maintainers will review who is assigned to this
at least once a year.

The Security Response Team is responsible for handling all reports of security
holes and breaches according to the [security policy](https://github.com/foundationsedge/nv-i18n/blob/master/SECURITY.md).

## Voting

While most business in nv-i18n is conducted by "[lazy consensus](https://community.apache.org/committers/lazyConsensus.html)",
periodically the Maintainers may need to vote on specific actions or changes.
A vote can be taken on the [developer mailing list](https://nv-i18n.discourse.group/) or
the [private maintainer mailing list](https://nv-i18n-maintainers.discourse.group/) for security or conduct matters.
Votes may also be taken at the developer meeting. Any Maintainer may
demand a vote be taken.

Most votes require a simple majority of all Maintainers to succeed, except where
otherwise noted. Two-thirds majority votes mean at least two-thirds of all
existing maintainers.

## When to Evolve This Governance

The Maintainer Council model works well for focused projects with a small, cohesive group of contributors. As the project grows, watch for these signals that a governance transition may be needed:

* **Decisions stall.** When the maintainer group is too large for lazy consensus to work, or when decisions affect subgroups differently, a delegation structure (working groups, SIGs) helps.
* **New contributors cannot find a path in.** If the only path to influence is "become a maintainer," the project needs intermediate roles (reviewer, approver). Projects with intermediate roles produce more diverse maintainer pools because they give external contributors a visible progression path.
* **A single organisation dominates.** When one company holds a majority of maintainer seats, consider adding org-balanced voting, company representation caps, or transitioning to an elected steering committee.
* **Subprojects diverge.** When parts of the project develop their own contributor communities or release cadences, consider federated subproject governance.

These transitions are a sign of project growth, not governance failure.

## Modifying this Charter

Changes to this Governance and its supporting documents may be approved by
a 2/3 vote of the Maintainers.
