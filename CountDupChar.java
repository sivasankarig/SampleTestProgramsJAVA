/**
 * Created by sivan on 3/22/17.
 * Maximum number of elements Hashmap can hold theoritically is 2^31-1. which is INTEGER.MAX_VALUE returned by Hashmap.size()
 */
import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;

public class CountDupChar {
    public static void main(String[] args) {
        String inStr;

        CountDupChar obj = new CountDupChar();
        System.out.println("Hello World");
        Scanner input = new Scanner(System.in);

        System.out.println("Enter the string to parse");
        inStr = input.nextLine();
        inStr = inStr.toLowerCase();
        System.out.println(inStr);
        obj.findDupchars(inStr);
    }
    public void findDupchars(String str){

        Map<Character,Integer> map = new HashMap<Character,Integer>();

        char [] ch= str.toCharArray();

        for(Character c: ch) {
            if(map.containsKey(c)){
                map.put(c,map.get(c)+1);
            }
            else
                map.put(c,1);
        }

        for(Character key : map.keySet()) {
            if(map.get(key) > 1)
                System.out.println("Duplicate Characters " + key + " " + map.get(key));
        }

    }
}
