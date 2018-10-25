package com.tryNew.one;

/**
 * Created by sivan on 10/5/18.
 */


public class NumberToWords

{
    private static final String[] specialNames = {
            "",
            " thousand",
            " million",
            " billion",
            " trillion",
            " quadrillion",
            " quintillion"
    };

    private static final String[] tensNames = {
            "",
            " ten",
            " twenty",
            " thirty",
            " forty",
            " fifty",
            " sixty",
            " seventy",
            " eighty",
            " ninety"
    };

    private static final String[] numNames = {
            "",
            " one",
            " two",
            " three",
            " four",
            " five",
            " six",
            " seven",
            " eight",
            " nine",
            " ten",
            " eleven",
            " twelve",
            " thirteen",
            " fourteen",
            " fifteen",
            " sixteen",
            " seventeen",
            " eighteen",
            " nineteen"
    };

    private String convertLessThanOneThousand(long number) {
        String current;

        if (number % 100 < 20){
            current = numNames[(int)number % 100];
            number /= 100;
        }
        else {
            current = numNames[(int)number % 10];
            number /= 10;

            current = tensNames[(int)number % 10] + current;
            number /= 10;
        }
        if (number == 0) {
            //System.out.println("1 currrent " + current);
            return current;

        }
        //System.out.println("2 current " + current);
        return numNames[(int)number] + " hundred" + current;
    }

    public String convert(long number) {

        if (number == 0) { return "zero"; }

        String prefix = "";

        if (number < 0) {
            number = -number;
            prefix = "negative";
        }

        String current = "";
        int place = 0;

        do {
            long n = number % 1000;
            System.out.println("remider "+n);
            if (n != 0){
                String s = convertLessThanOneThousand(n);
                current = s + specialNames[place] + current;
            }
            place++;
            number /= 1000;
        } while (number > 0);

        return (prefix + current).trim();
    }

    public static void main(String[] args) {
        NumberToWords obj = new NumberToWords();
        System.out.println("*** " + obj.convert(1234567891234L));
        System.out.println("*** " + obj.convert(55));
    }
}