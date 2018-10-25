package com.wisetesch.global;

import java.util.Scanner;
import java.util.regex.Pattern;

// user-defined expception
class AdditionException extends Exception
{
    AdditionException(String s)
    {
        super(s);
    }
}
public class RomanNumeralsCalculator {
    enum RomanLetters {
        M(1000),CM(900),D(500),CD(400),
        C(100),XC(90),L(50),XL(40),X(10),
        IX(9),V(5),IV(4),I(1);

        private int value;
        RomanLetters (int value){
            this.value=value;
        }

        public int getValue(){
            return this.value;
        }

    }
    private static int convertTONumber(String[] romanStrArray){

        int endValue=0;

        for (String romanValue : romanStrArray ) {
            RomanLetters[] enumArray = RomanLetters.values();
            int tempCount=0;
            while ((romanValue.length() > 0) && (tempCount < enumArray.length)) {
                RomanLetters symbol = enumArray[tempCount];
                if (romanValue.startsWith(symbol.name())) {
                    endValue += symbol.getValue();
                    romanValue = romanValue.substring(symbol.name().length());
                } else tempCount++;
            }
        }
        return endValue;
    }
    private static String convertToRoman(int number){
        StringBuilder result= new StringBuilder();
        RomanLetters[] enumArray = RomanLetters.values();
        int tempCount=0;
        while (tempCount<enumArray.length){
            if(number>=enumArray[tempCount].getValue()){
                result.append(enumArray[tempCount].name());
                number-=enumArray[tempCount].getValue();
            }
            else {
                tempCount++;
            }
        }

        return result.toString();
    }
    public static void main(String[] args) {
        String str1="",str2="";
        Pattern pattern = Pattern.compile("^M{0,3}(CM|CD|D?C{0,3})(XC|XL|L?X{0,3})(IX|IV|V?I{0,3})$");

        try {
            while(true){
                System.out.println("Enter the first Roman numeral or quit to exit");
                Scanner sc = new Scanner(System.in);
                str1 = sc.nextLine();
                switch(str1){
                    case "quit": {
                        System.out.println("Bye!!");
                        System.exit(0);
                    }
                    case "": {
                        System.out.println("Empty Value..Try Again.");
                        System.exit(0);
                    }
                }
                System.out.println("Enter the second Roman numeral or quit to exit");
                Scanner scc = new Scanner(System.in);
                str2 = scc.nextLine();

                switch(str2){
                    case "quit": {
                        System.out.println("Bye!!");
                        System.exit(0);
                    }
                    case "": {
                        System.out.println("Empty Value..Try Again.");
                        System.exit(0);
                    }
                }
                if((pattern.matcher(str1).matches()) && (pattern.matcher(str2).matches())) {
                    String[] strArray = {str1, str2};
                    int addedValue = convertTONumber(strArray);
                    if(addedValue>3000)
                        throw new AdditionException(" TOTAL VALUE EXCEEDS 3000");
                    System.out.println("Added value is : " + convertToRoman(addedValue));
                }
                else{
                    throw new Exception("NOT A VALID ROMAN NUMERAL (OR) VALUE EXCEEDS 3000");
                }
            }
        }catch (Exception e)
        {
            System.out.println("Exception :" +e.getMessage());
        }

    }

}
