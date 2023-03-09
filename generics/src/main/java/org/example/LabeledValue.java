package org.example;

public class LabeledValue<E> {

    private final String label;
    private final E value;

    public LabeledValue(String label, E value) {
        this.label = label;
        this.value = value;
    }

    public String getLabel() {
        return label;
    }

    public E getValue() {
        return value;
    }
}
