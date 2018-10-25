package com.wisetesch.global;

import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Pattern;


// user-defined expception
class OutofBoundException extends Exception
{
    OutofBoundException(String s)
    {
        super(s);
    }
}
public class RomanNumerals {
    enum Romanletters {
        M(1000),CM(900),D(500),CD(400),
        C(100),XC(90),L(50),XL(40),X(10),
        IX(9),V(5),IV(4),I(1);

        private int value;
        Romanletters (int value){
            this.value=value;
        }

        public int getValue(){
            return this.value;
        }

    }

    private static String convertToRoman(int number){
        StringBuilder endValue= new StringBuilder();
        Romanletters[] enumArray = Romanletters.values();
        int temp=0;
        while (temp<enumArray.length){
            if(number>=enumArray[temp].getValue()){
                endValue.append(enumArray[temp].name());
                number-=enumArray[temp].getValue();
            }
            else {
                temp++;
            }
        }

        return endValue.toString();
    }
    public static void main(String[] args) {

        String numberStr;
        Pattern pattern = Pattern.compile(".*[0-9].*");
        System.out.println("Enter the Numbers to convert to Roman Numeral and Enter 'QUIT' to exit");
        try {
            do {
                Scanner sc = new Scanner(System.in);
                numberStr = sc.nextLine();

                if(pattern.matcher(numberStr).matches()) {
                    int numValue = Integer.valueOf(numberStr);
                    if((numValue>0) && (numValue<=3000))
                        System.out.println(" value of number : " + convertToRoman(numValue));
                    else
                        throw new OutofBoundException("VALUES TAKEN : 1 to 3000");
                }
            } while (!numberStr.equalsIgnoreCase("quit"));
        }catch (Exception e)
        {
            System.out.println("Exception :" +e.getMessage());
        }

    }

}
