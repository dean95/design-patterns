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

## Information Hiding (and Leakage)
* This chapter discusses techniques for creating deep modules.

### Information hiding
* The most important technique for achieving deep modules is **information hiding**.
* Each module should encapsulate a few pieces of knowledge, which is embedded in the module’s implementation but does not appear in its interface, so it is not visible to other modules.
  * Example - How to parse JSON documents.
* The hidden information includes data structures and algorithms related to the mechanism.
* Information hiding reduces complexity in two ways:
  * It simplifies the interface to a module
  * Information hiding makes it easier to evolve the system

### Information leakage
* Information leakage occurs when a design decision is reflected in multiple modules which creates a dependency between the modules.

> **Red Flag: Information Leakage**
>
>Information leakage occurs when the same knowledge is used in multiple places, such as two different classes that both understand the format of a particular type of file.

### Temporal decomposition
* In temporal decomposition, the structure of a system corresponds to the time order in which operations will occur.

> **Red Flag: Temporal Decomposition**
> 
> In temporal decomposition, execution order is reflected in the code structure: operations that happen at different times are in different methods or classes. If the same knowledge is used at different points in execution, it gets encoded in multiple places, resulting in information leakage.

#### Default values
* Interfaces should be designed to make the common case as simple as possible.
* Modules should do "the right thing" without being explicitly asked.
* The most common use case should be how the module works by default.

> **Red Flag: Overexposure**
> 
> If the API for a commonly used feature forces users to learn about other features that are rarely used, this increases the cognitive load on users who don’t need the rarely used features.

## General-Purpose Modules are Deeper
* One of the most common decisions that you will face when designing a new module is whether to implement it in a general-purpose or special-purpose fashion. 
  * General-purpose - approach in which you implement a mechanism that can be used to address a broad range of problems.
  * Special-purpose - building just what you know you need, and specializing it for the way you plan to use it today.

### Make classes somewhat general-purpose
* The phrase “somewhat general-purpose” means that the module’s functionality should reflect your current needs, but its interface should not.
* The interface should be easy to use for today’s needs without being tied specifically to them.
* General-purpose approach results in simpler and deeper interfaces than a special-purpose approach.

### Questions to ask yourself
* Some questions you can ask yourself which will help you find the right balance between general-purpose and special-purpose for an interface.
  * What is the simplest interface that will cover all my current needs?
    * If you reduce the number of methods in an API without reducing its overall capabilities, then you are probably creating more general-purpose methods.
    * If you have to introduce lots of additional arguments in order to reduce the number of methods, then you may not really be simplifying things.
  * In how many situations will this method be used?
    * If a method is designed for one particular use, that is a red flag that it may be too special-purpose. See if you can replace several special-purpose methods with a single general-purpose method.
  * Is this API easy to use for my current needs?
    * If you have to write a lot of additional code to use a class for your current purpose, that’s a red flag that the interface doesn’t provide the right functionality.

### Conclusion
* General-purpose interfaces have many advantages over special-purpose ones. They tend to be simpler, with fewer methods that are deeper. They also provide a cleaner separation between classes, whereas special-purpose interfaces tend to leak information between classes. Making your modules somewhat general-purpose is one of the best ways to reduce overall system complexity.

## Different Layer, Different Abstraction
* Software systems are composed in layers, where higher layers use the facilities provided by lower layers. In a well-designed system, each layer provides a different abstraction from the layers above and below it.
* If a system contains adjacent layers with similar abstractions, this is a red flag that suggests a problem with the class decomposition.

### Pass-through methods
* When adjacent layers have similar abstractions, the problem often manifests itself in the form of **pass-through methods**.
* A pass-through method is one that does little except invoke another method, whose signature is similar or identical to that of the calling method.

> **Red Flag: Pass-Through Method**
> 
> A pass-through method is one that does nothing except pass its arguments to another method, usually with the same API as the pass-through method. This typically indicates that there is not a clean division of responsibility between the classes.

* Pass-through methods make classes shallower: they increase the interface complexity of the class, which adds complexity, but they don’t increase the total functionality of the system.
* Pass-through methods also create dependencies between classes: if the signature of one method changes then all methods will have to change to match.
* Pass-through methods indicate that there is confusion over the division of responsibility between classes.
* The interface to a piece of functionality should be in the same class that implements the functionality.
* The solution to pass-through methods is to refactor the classes so that each class has a distinct and coherent set of responsibilities.
  * One approach is to expose the lower level class directly to the callers of the higher level class, removing all responsibility for the feature from the higher level class.
  * Another approach is to redistribute the functionality between the classes.
  * Finally, if the classes can’t be disentangled, the best solution may be to merge them.

### When is interface duplication OK?
* Having methods with the same signature is not always bad. The important thing is that each new method should contribute significant functionality. Pass-through methods are bad because they contribute no new functionality.
* One example where it’s useful for a method to call another method with the same signature is a dispatcher. A dispatcher is a method that uses its arguments to select one of several other methods to invoke.
* It is fine for several methods to have the same signature as long as each of them provides useful and distinct functionality.
* Another example is interfaces with multiple implementations. When several methods provide different implementations of the same interface, it reduces cognitive load.

### Decorators
* The decorator design pattern (also known as a “wrapper”) is one that encourages API duplication across layers. A decorator object takes an existing object and extends its functionality; it provides an API similar or identical to the underlying object, and its methods invoke the methods of the underlying object.
* The motivation for decorators is to separate special-purpose extensions of a class from a more generic core. However, decorator classes tend to be shallow: they introduce a large amount of boilerplate for a small amount of new functionality. Decorator classes often contain many pass-through methods. It’s easy to overuse the decorator pattern, creating a new class for every small new feature. This results in an explosion of shallow classes.
* Before creating a decorator class, consider alternatives.

### Interface versus implementation
* Another application of the “different layer, different abstraction” rule is that the interface of a class should normally be different from its implementation: the representations used internally should be different from the abstractions that appear in the interface. If the two have similar abstractions, then the class probably isn’t very deep.

### Pass-through variables
* Another form of API duplication across layers is a pass-through variable, which is a variable that is passed down through a long chain of methods.
* Pass-through variables add complexity because they force all the intermediate methods to be aware of their existence, even though the methods have no use for the variables.
* If a new variable comes into existence you may have to modify a large number of interfaces and methods to pass the variable through all the relevant paths.
* Eliminating pass-through variables can be challenging.
  * One approach is to see if there is already an object shared between the topmost and bottommost methods.
  * Another approach is to store the information in a global variable.
  * Another solution is to introduce a context object that stores all the application’s global state (anything that would otherwise be a pass-through variable or global variable).

### Conclusion
* Each piece of design infrastructure added to a system, such as an interface, argument, function, class, or definition, adds complexity, since developers must learn about this element. In order for an element to provide a net gain against complexity, it must eliminate some complexity that would be present in the absence of the design element. Otherwise, you are better off implementing the system without that particular element. For example, a class can reduce complexity by encapsulating functionality so that users of the class needn’t be aware of it.
* The “different layer, different abstraction” rule is just an application of this idea: if different layers have the same abstraction, such as pass-through methods or decorators, then there’s a good chance that they haven’t provided enough benefit to compensate for the additional infrastructure they represent. Similarly, pass-through arguments require each of several methods to be aware of their existence (which adds to complexity) without contributing additional functionality.
