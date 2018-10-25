package com.tryNew.one;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
/**
 * Created by sivan on 10/7/18.
 */
public class PrintDuplicateCharacters {

    private Map<Character,Integer> mapDuplicate = new HashMap<>();
    public void verifyDuplicate(String word)
    {
        if(word.isEmpty()){

        }
        char[] charWord = word.toCharArray();

        for(char letter : charWord) {
            if(mapDuplicate.containsKey(letter) && Character.isLetter(letter)){
                mapDuplicate.put(letter,mapDuplicate.get(letter)+1);
            }
            else
                mapDuplicate.put(letter,1);
        }
        printDuplicate();
    }
    public void printDuplicate(){

        mapDuplicate.forEach((k,v)->{
            if(v > 1 ) {
                System.out.println("Character : "+ k + " Count : " + v);
            }
        });
       /* for (Map.Entry<Character, Integer> entry : mapDuplicate.entrySet()) {
            System.out.println("Item : " + entry.getKey() + " Count : " + entry.getValue());
        }*/
    }
    public static void main(String[] args) {
        PrintDuplicateCharacters obj = new PrintDuplicateCharacters();
        Scanner sc = new Scanner(System.in);
        String sword = sc.nextLine();
        if(sword.isEmpty())
            System.out.println("Input not given");
        else
            obj.verifyDuplicate(sword);

    }
}
