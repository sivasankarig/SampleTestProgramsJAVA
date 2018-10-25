/**
 * Created by sivan on 10/7/18.
 */
public class reverseSentence {
    public static String reverseString(String line) {
        if (line.trim().isEmpty()) {
            return line;
        }
        StringBuilder reverse = new StringBuilder();
        String[] sa = line.trim().split("\\s");
        for (int i = sa.length - 1; i >= 0; i--) {
            reverse.append(sa[i]);
            reverse.append(' ');
        }
        return reverse.toString().trim();
    }
    public static String reversestr(String input)
    {
        if(input == null || input.isEmpty())
        {
            return input;
        }
        System.out.println(input.substring(0, input.length() - 1));
        return input.charAt(input.length()- 1) + reversestr(input.substring(0, input.length() - 1));
        //return input;
    }



    public static void main(String[] args) {
        String resut = reverseString("siva");
        System.out.println(resut.length());
        System.out.println(reversestr(resut));

        int i = Integer.valueOf("000000071");
        System.out.println("i: " + i);


        String price = String.valueOf(344);
        System.out.println(price);

        String priced = String.format ("%d", 123);
        System.out.println(priced);

    }
}
