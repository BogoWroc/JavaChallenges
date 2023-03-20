package org.example;

import java.text.NumberFormat;
import java.util.Locale;

public class LocaleAndCompactFormatDoubles {

    public static void main(String[] args) {
        double v = 1213.43535345d;

        System.out.println("Current locale: " + NumberFormat.getInstance().format(v));
        System.out.println("US locale: " + NumberFormat.getInstance(Locale.US).format(v));

        NumberFormat f1 = NumberFormat.getCompactNumberInstance(Locale.FRENCH, NumberFormat.Style.LONG);
        NumberFormat f2 = NumberFormat.getCompactNumberInstance(Locale.KOREAN   , NumberFormat.Style.SHORT);

        System.out.println(f1.format(1_000_000));
        System.out.println(f2.format(1_000_000));
    }

}
