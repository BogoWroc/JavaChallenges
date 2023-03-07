package org.example.animal;

public class Animal {
}

// The sealed class must have subclasses
sealed class Pet extends Animal permits Dog, Cat, Fish{}

// Rules for permitted classes
// - it must be a first subclass of sealed class
// - subclass must have one of modifiers: final, non-sealed, sealed
final class Dog extends Pet {}

sealed class Cat extends Pet permits MaineCoon{}
final class MaineCoon extends Cat{}

// non-sealed means: open for extension
non-sealed class Fish extends Pet{}
class Goldfish extends Fish{}
