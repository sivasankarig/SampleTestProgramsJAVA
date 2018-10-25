package com.tryNew.one;
import java.util.Arrays;
import java.util.Scanner;
/**
 * Created by sivan on 10/7/18.
 */

public class findAnagram {
    public boolean anagramOrNot(String word1, String word2){
        boolean isAnagram = false;

        System.out.println("Anagram or not " + word1 + " "+word2);
        StringBuilder anagram = new StringBuilder(word2);
        char[] charword = word1.toCharArray();
        for(char c : charword){
            int index = anagram.indexOf(""+c);
            if(anagram.toString().isEmpty()){
                return false;
            }
            if (index != -1) {
                anagram.deleteCharAt(index);
            }
        }
        isAnagram = anagram.toString().isEmpty();
        return isAnagram;
       /* Arrays.sort(word1.toCharArray());
        Arrays.sort(word2.toCharArray());
        boolean status = Arrays.equals(word1.toCharArray(),word2.toCharArray());
        return status;*/
    }
    public static void main(String[] args) {
        boolean status = false;
        System.out.println("Enter the first string : ");
        Scanner sc1 = new Scanner(System.in);
        StringBuilder sc1Str = new StringBuilder(sc1.nextLine().replaceAll("\\s",""));
        System.out.println("Enter the Second string : ");
        Scanner sc2 = new Scanner(System.in);
        StringBuilder sc2Str = new StringBuilder(sc2.nextLine().replaceAll("\\s",""));

        System.out.println("string "+sc1Str + " " + sc2Str);
        if((sc1Str.length() == 0) || (sc2Str.length() == 0)){
            System.out.println("Either or both strings are empty");
        }
       /* else if(sc1Str.length() != sc2Str.length()){
            System.out.println("varied length: strings are not anagram");
        }*/
        else {
            findAnagram obj = new findAnagram();
            status= obj.anagramOrNot(sc1Str.toString().toLowerCase(),sc2Str.toString().toLowerCase());
        }
        if(status)
        {
            System.out.println("Anagram");
        }
        else{
            System.out.println("Not anagram");
        }
    }
}
