package com.company;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class Main {

    public static void main(String[] args) {
        // write your code here
        System.out.println(sortByStrings("weather", "therapyw"));
        System.out.println(decodeString("4[ab]"));
        System.out.println(changePossibilities(6, new int[]{1,2}));
    }

    /**
     * Question 1 -- sortByStrings(s,t): Sort the letters in the string s by the order they occur in the string t.
     * You can assume t will not have repetitive characters.
     * For s = "weather" and t = "therapyw",
     * the output should be sortByString(s, t) = "theeraw".
     * For s = "good" and t = "odg", the output should be sortByString(s, t) = "oodg".
     ***/

    public static String sortByStrings(String s, String t) {
        if (s == null) {
            return "";
        }

        if (t == null) {
            return "";
        }

        StringBuilder sBuilder = new StringBuilder();
        Queue<Character> tBuilder = new LinkedList<>();

        Map<Character, Integer> sMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char sChar = s.charAt(i);
            if (sMap.containsKey(sChar)) sMap.put(sChar, sMap.get(sChar) + 1);
            else sMap.put(sChar, 1);
        }

        fillQueue(t, tBuilder);

        while (!tBuilder.isEmpty()) {
            if (sMap.containsKey(tBuilder.peek()) && sMap.get(tBuilder.peek()) > 1) {
                sBuilder.append(tBuilder.peek());
                sMap.put(tBuilder.peek(), sMap.get(tBuilder.peek()) - 1);
            } else if (sMap.containsKey(tBuilder.peek())) {
                sBuilder.append(tBuilder.poll());
            } else {
                tBuilder.poll();
            }
        }

        return sBuilder.toString();
    }

    private static void fillQueue(String t, Queue<Character> tBuilder) {
        for (Character tChar : t.toCharArray()) {
            tBuilder.add(tChar);
        }
    }

    /**
     * Question 2 -- decodeString(s): Given an encoded string, return its corresponding decoded string.
     * <p>
     * The encoding rule is:
     * k[encoded_string],
     * where the encoded_string inside the square brackets is repeated exactly k times.
     * Note: k is guaranteed to be a positive integer.
     * <p>
     * For s = "4[ab]", the output should be decodeString(s) = "abababab"
     * For s = "2[b3[a]]", the output should be decodeString(s) = "baaabaaa"
     */

    public static String decodeString(String s) {
        if (s == null || s.isEmpty()) {
            return "";
        }
        int numberOfPrints = 0;
        int positionDenomination = 0;
        while (s.charAt(positionDenomination) > '0' && s.charAt(positionDenomination) < '9') {
            positionDenomination += 1;
        }

        numberOfPrints = Integer.parseInt(s.substring(0, positionDenomination));
        StringBuilder decodedString = new StringBuilder();
        int positionInString = positionDenomination + 1;
        while (positionInString < s.length()) {
            if ((s.charAt(positionInString) > '0' && s.charAt(positionInString) < '9') || s.charAt(positionInString) == ']') {
                break;
            }
            positionInString++;
        }
        String stringInEncode = s.substring(positionDenomination + 1, positionInString);


        while (numberOfPrints > 0) {
            decodedString.append(stringInEncode);
            if (s.charAt(positionInString) != ']')
                decodedString.append(decodeString(s.substring(positionInString, s.length() - 1)));

            numberOfPrints--;
        }
        return decodedString.toString();
    }


    /**
     * Question 3 -- changePossibilities(amount,amount): Your quirky boss collects rare, old coins. They found out you're a programmer and asked you to solve something they've been wondering for a long time.
     * <p>
     * Write a function that, given an amount of money and an array of coin denominations, computes the number of ways to make the amount of money with coins of the available denominations.
     * <p>
     * Example: for amount=4 (4¢) and denominations=[1,2,3] (1¢, 2¢ and 3¢), your program would output 4—the number of ways to make 4¢ with those denominations:
     * <p>
     * 1¢, 1¢, 1¢, 1¢
     * 1¢, 1¢, 2¢
     * 1¢, 3¢
     * 2¢, 2¢
     **/


    static int[] denominations;
    static int count;
    public static int changePossibilities(int amount, int[] denomination) {
        if (amount == 0){
            return 0;
        }
        count = 0;
        denominations = denomination;
        change(0, amount);

        return count;

    }

    private static void change(int index, int amount) {
        if (index >= denominations.length){
            return;
        }
        if (amount % denominations[index] == 0) {
            count++;
        }

        while (amount > 0) {
            change(index+1,amount);
            amount -= denominations[index];
        }

        return;
    }


}
