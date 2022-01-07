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

## Working Code Isn't Enough
* If you want a good design, you must take a more strategic approach where you invest time to produce clean design and fix problems.

### Tactical programming
* In the tactical approach, your main focus is to get something working, such as a new feature or a bug fix.
* Tactical programming is short-sighted since it introduces a bit of complexity in order to finish the task more quickly.

### Strategic programming
* The most important thing is the long-term structure of the system where your primary goal is to produce a great design. This is **strategic programming**.
* If you program strategically, you will continually make small improvements to the system design. These improvements will slow you down a bit in the short term, but they will speed you up in the long term. 

### How much to invest?
* The best approach is to make small improvements to the design on a continual basis. This means spending 10-20% of your total development time on improvements.
* The term _technical debt_ is often used to describe problems caused by tactical programming.

### Conclusion
* You have to continuously invest in good design so that small problems don't accumulate into big ones.
* The most effective approach is one where every engineer makes continuous small improvements in design.

## Modules Should Be Deep
* Modular design is a system design where developers only need to face a small fraction of the overall complexity.

### Modular design
* In modular design, a software system is decomposed into a collection of modules that are relatively independent.
* The goal of modular design is to minimize dependencies between modules.
* In order to manage dependencies, we think of each module in two parts:
  * _interface_ - describes what the module does but not how it does it
  * _implementation_ - carries out the promises made by the interface
* The best modules are those whose interfaces are much simpler than their implementations

### What’s in an interface?
* The interface to a module contains two kinds of information:
  * formal - specified explicitly in the code.
  * informal - not specified in a way that can be understood or enforced by the programming language (high-level behavior).
* The informal aspects of an interface can only be described using comments, and the programming language cannot ensure that the description is complete or accurate.
* One of the benefits of a clearly specified interface is that it indicates exactly what developers need to know in order to use the associated module.

### Abstractions
* An abstraction is a simplified view of an entity, which omits unimportant details.
* Abstractions make easier for us to think about and manipulate complex things.
* In modular programming, each module provides an abstraction in form of its interface.
* The interface presents a simplified view of the module’s functionality; the details of the implementation are unimportant from the standpoint of the module’s abstraction, so they are omitted from the interface.

### Deep modules
* **Deep modules** are modules that provide powerful functionality yet have simple interfaces.
* A deep module is a good abstraction because only a small fraction of its internal complexity is visible to its users.
* A module’s interface represents the complexity that the module imposes on the rest of the system: the smaller and simpler the interface, the less complexity that it introduces.

### Shallow modules
* A **shallow module** is one whose interface is relatively complex in comparison to the functionality that it provides.
* An example of a shallow method:

```
private void addNullValueForAttribute(String attribute) {
    data.put(attribute, null);
}
```

* The method offers no abstraction, since all of its functionality is visible through its interface.
* The method adds complexity (in the form of a new interface for developers to learn) but provides no compensating benefit.

> **Red Flag: Shallow Module**
> 
> A shallow module is one whose interface is complicated relative to the functionality it provides. Shallow modules don’t help much in the battle against complexity, because the benefit they provide (not having to learn about how they work internally) is negated by the cost of learning and using their interfaces.

### Conclusion
* Users of a module need only understand the abstraction provided by its interface.
* Modules should be deep, so that they have simple interfaces for the common use cases, yet still provide significant functionality.
