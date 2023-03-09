package org.example;

public class Main {
    public static void main(String[] args) {
        LabeledValue<String> l1 = new LabeledValue<>("test","value");
        LabeledValue<Integer> l2 = new LabeledValue<>("test",2);

        // truthy
        System.out.println(l1.getValue().equals("value"));
        System.out.println(l2.getValue() == 2);

        KeyValue<String, String> k1 = new KeyValue<>("test", "22");
        KeyValue<String, Integer> k2 = k1.mapValue(Integer::parseInt);

        // truthy
        System.out.println(k2.value() == 22);
    }
}