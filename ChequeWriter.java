package com.wisetesch.global;

import java.math.BigDecimal;

class BoundaryException extends Exception
{
    BoundaryException(String s)
    {
        super(s);
    }
}

public class ChequeWriter {
    private static final int HUNDRED =100;
    private static final int THOUSAND = 1000;
    private static final int TEN = 10;

    private static final String[] oncePlace = {
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

    private static final String[] tenPlace = {
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

    private static final String[] biggerValues = {
            "",
            " thousand",
            " million",
            " billion"
    };

    private String convertThousandsValueToWords(long curencyValue) {
        String currencyInWords="";

        if (curencyValue % HUNDRED < 20){
            currencyInWords = oncePlace[(int)curencyValue % HUNDRED];
            curencyValue /= HUNDRED;
        }
        else {
            currencyInWords = oncePlace[(int)curencyValue % TEN];
            curencyValue /= TEN;

            currencyInWords = tenPlace[(int)curencyValue % TEN] + currencyInWords;
            curencyValue /= TEN;
        }
        if (curencyValue == 0) {
            return currencyInWords;

        }
            if(!currencyInWords.isEmpty())
                return oncePlace[(int)curencyValue] + " hundred and" + currencyInWords;
            else
                return oncePlace[(int)curencyValue];

    }

    private String convert(BigDecimal bgNumber) throws BoundaryException {

        StringBuilder dollarWords = new StringBuilder();
        String centWords = "";
        int decimalValue;
        long dollarValue;
        if (bgNumber.longValue() == 0) {
            return "zero";
        }

        //Check for boundary condition

         if ((bgNumber.longValue() > 2000000000) || bgNumber.longValue() < 0)
             throw new BoundaryException("  VALUE GREATER THAN TWO BILLION : ChequeWriter");


            //split dollar and decimal value seperatel to process
        if (bgNumber.toString().contains(".")) {
            String[] decimal = String.valueOf(bgNumber).split("\\.");
            dollarValue = Integer.valueOf(decimal[0]);
            decimalValue = Integer.valueOf(decimal[1]);
            centWords = convertThousandsValueToWords(decimalValue);
        } else {
                //if there is no decimal value
                dollarValue = bgNumber.longValue();
            }

            //store cent value to words
            if (!centWords.isEmpty()) {
                centWords = " AND " + centWords + " CENTS";
            }

            int bigValueholder = 0; // index to hold thousand, million and billion


            do {
                long tempNum = dollarValue % THOUSAND;

                if (tempNum != 0) {
                    String strTemp = convertThousandsValueToWords(tempNum);
                    dollarWords.insert(0, strTemp + biggerValues[bigValueholder]);
                }
                bigValueholder++;
                dollarValue /= THOUSAND;
            } while (dollarValue > 0);

            return dollarWords.toString().concat(" DOLLARS").concat(centWords).trim();
        }


    public static void main(String[] args) {
        ChequeWriter cwObj = new ChequeWriter();
        BigDecimal bg = new BigDecimal("200000000");
        BigDecimal bg1 = new BigDecimal("45.55");
        BigDecimal bg2 = new BigDecimal("23456767.09");
        BigDecimal bg3 = new BigDecimal("2000000001");
        try {
            System.out.println(bg + " :  " + cwObj.convert(bg));
            System.out.println(bg1+ " : " + cwObj.convert(bg1));
            System.out.println(bg2+ " : " +cwObj.convert(bg2));
            //System.out.println(bg3+ " : " +cwObj.convert(bg3));
        } catch (BoundaryException e) {
            e.printStackTrace();
        }

    }
}
