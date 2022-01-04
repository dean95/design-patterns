# Design document
## Introduction
* Complexity increases inevitably over the life on any program.
* Simpler designs allow us to build larger and more powerful systems.
* There are two approaches to fighting complexity:
  * Make code simpler and more obvious.
  * Encapsulate complexity (modular design) - Software system is divided up into modules that are relatively independent of each other.
* Use an incremental approach where design will be continuously evaluated and corrected on each iteration. 
* Reducing complexity is the most important element of software design.
* While reviewing code, recognize red flags and think about whether it conforms to the concepts discussed here.
* Balance between competing ideas and approaches. Try not to "overdo" it.

## The Nature of Complexity
* The ability to recognize complexity allows you to identify problems and to make good choices among alternatives.

### Complexity defined
* Complexity is anything related to the structure of a software system that makes it hard to understand and modify the system.
* Isolating complexity in a place where it will never be seen is almost as good as eliminating the complexity entirely.
* Your job is to create code that you and others can work with easily.

### Symptoms of complexity
Complexity manifests itself in three general ways:
* **Change amplification** - a seemingly simply change requires code modification in many different places. The goal of good design is to reduce the amount of code that is affected by each design decision.
* **Cognitive load** - Refers to how much a developer needs to know in order to complete a task. Cognitive load arises in many ways, such as APIs with many methods, global variables, inconsistencies, and dependencies between modules.
* **Unknown unknowns** - A design where it's not obvious which pieces of code must be modified to complete a task, or what information developer must have to carry out the task successfully. One of the most important goals of good design is for a system to be obvious, where a developer can quickly understand how the existing code works and what is required to make a change.

### Causes of complexity
* Complexity is caused by two things: **dependencies** and **obscurity**.
* A dependency exists when a given piece of code cannot be understood and modified in isolation; the code relates in some way to other code, and the other code must be considered and/or modified if the given code is changed.
* Dependencies can't be completely eliminated. The goal is to make the dependencies that remain as simple and obvious as possible.
* Obscurity occurs when important information is not obvious. A simple example is a variable name that is to generic (e.g., `time`), or if the same variable name is used for two different purposes.
* The best way to reduce obscurity is to have a clean and obvious design.
* Dependencies lead to change amplification and a high cognitive load.
* Obscurity creates unknown unknowns, and also contributes to cognitive load.

### Complexity is incremental
* Complexity comes from an accumulation of dependencies and obscurities.
* In order to slow the growth of complexity you must adopt a "zero tolerance" philosophy, which will be discussed later.

### Conclusion
* Complexity makes it difficult and risky to modify an existing code base. 
