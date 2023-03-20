package org.example;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class FormattingDoubles {
    public static void main(String[] args) {
        double v = 3.53423423423d;

        NumberFormat nf = new DecimalFormat("#00.00");
        System.out.println(nf.format(v));

        NumberFormat nf2 = new DecimalFormat("00,000.000000");
        System.out.println(nf2.format(v));
    }
}
