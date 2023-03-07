package org.example.inter;

public interface Animal {
}

sealed interface Pet extends Animal permits Dog, Cat, Fish {
}

final class Dog implements Pet {
}

sealed interface Cat extends Pet permits MaineCoon {
}

final class MaineCoon implements Cat {
}

// non-sealed means: open for extension
non-sealed interface Fish extends Pet {
}

class Goldfish implements Fish {
}
