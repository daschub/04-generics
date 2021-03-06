_This is an assignment to the class [Programmieren 3](https://hsro-inf-prg3.github.io) at the [University of Applied Sciences Rosenheim](http://www.fh-rosenheim.de)._

# Assignment 4: Generics

In this assignment we want to improve the previously implemented `SimpleListImpl` of [Assignment 2](https://github.com/hsro-inf-prg3/02-classes-interfaces).
Back then, `SimpleListImpl` was implemented to store references of type `Object`, which in turn required a type cast on retrieval:

```java
SimpleList sl = new SimpleListImpl();
sl.add(new MyClass());
MyClass k = (MyClass) sl.get(0);

```

Inside `SimpleListImpl`, the knowledge about the actual class was lost, and worse: the following code would compile but produce a runtime exception:

```java
SimpleList sl = new SimpleListImpl();
sl.add(new MyClass());
sl.add(new MyOtherClass());
MyClass k1 = (MyClass) sl.get(0);  // all ok
MyClass k2 = (MyOtherClass) sl.get(1);  // ClassCastException!
```

Generics help us to avoid both the type cast and the risk of runtime exceptions by checking the type at compile time.

For this assignment, start with the reference solution of assignment 2 and the `abstract` model class `Plant`.


## Setup

1. Create a fork of this repository (button in the right upper corner)
2. Clone the project (get the link by clicking the green _Clone or download button_)
3. Import the project to your IDE (remember the guide in assignment 1)
4. Validate your environment by running the tests from your IntelliJ and by running `gradle test` on the command line.


## Generic Lists

![class spec 1](assets/class-spec-1.svg)

To make a class generic, introduce a generic type (typically named `T`) in the class or interface signature, and replace all affected actual types with the generic type.

1. Make the following interfaces and classes generic
    * `SimpleList`
    * `SimpleFilter`
    * `SimpleListImpl`
    * `SimpleIteratorImpl`
    * `Element`
2. Adopt the changes in the test class `SimpleListTests.java`
3. Remove the now unnecessary type casts
4. Add the new method `addEmpty()` in the `SimpleList` interface<br>
    _Hint:_ this method aims at the instantiation problem of generics.


## Use of Generics

![class spec 2](assets/class-spec-2.svg)

In the second part we want to use our own generic list by implementing a flower bed which keeps track of all plants in it.
Additionally we want to implement a short utility method which shows you how to use generics in `static` contexts.

1. Implement the two child classes:
    * `Flower`<br>
        A flower may have any color except green; make sure to validate this in the constructor.
    * `Shrub`<br>
        A shrub is always green; think of it when you implement the `abstract` method `getColor()`.
2. Implement the class `PlantBed`.
    Have a look at the given UML to get an idea what this class is for.
3. Implement the `static` utility method `splitByColor(...)` in an `abstract` utility class `PlantUtility` (can you imagine why this class should be `abstract` and optimally has a `private` constructor?)
