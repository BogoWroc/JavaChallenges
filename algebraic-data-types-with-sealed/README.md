Sealed classes and interfaces
---

Sealed classes and interfaces control with classes or interfaces extend a class or interface

The rules
---
- keyword 'permits' is used to defined which classes are interfaces can be extended by the class or interface
- sealed classes or interfaces must be stored in the same module or package

Extensibility of Classes and Interfaces
---
- Make a class final -> No subclasses anywhere
- Make the constructor package-private -> Subclasses in the same package only
- Interfaces -> No way to limit implementing or extending

Thanks to using sealed we can add limitation also at the interfaces.

Hint
---
- Records cannot extend sealed classes and cannot be sealed, because are final
- Records can implement sealed interfaces

Algebraic data types
---
With a sealed interface and records you can define a fixed set of alternative types