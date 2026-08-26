package leetcode;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.TreeMap;

class CharacterFrequency {
    static void main(String[] args) {
        System.out.println("Using HashMap");
        characterFrequency("Hello");
        characterFrequency("leetcode");
        characterFrequency("abc");
        characterFrequency("aabcc");

        System.out.println("Using LinkedHashMap");
        characterFrequency1("Hello");
        characterFrequency1("leetcode");
        characterFrequency1("abc");
        characterFrequency1("aabcc");

        System.out.println("Using TreeMap");
        characterFrequency2("Hello");
        characterFrequency2("leetcode");
        characterFrequency2("abc");
        characterFrequency2("aabcc");
    }

    // no insertion order maintained in hashmap
    static void characterFrequency(String str) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (char ch: str.toCharArray()) {
            if(map.containsKey(ch)) {
                map.put(ch, map.get(ch)+1);
            } else {
                map.put(ch, 1);
            }
        }

        for (char ch: map.keySet()) {
            System.out.println(ch + "->" + map.get(ch));
        }
        System.out.println("-".repeat(15));
    }

    // insertion order maintained in LinkedHashMap
    static void characterFrequency1(String str) {
        LinkedHashMap<Character, Integer> map = new LinkedHashMap<>();
        for (char ch : str.toCharArray()) {
            if (map.containsKey(ch)) {
                map.put(ch, map.get(ch) + 1);
            } else {
                map.put(ch, 1);
            }
        }

        for (char ch: map.keySet()) {
            System.out.println(ch + "->" + map.get(ch));
        }
        System.out.println("-".repeat(15));
    }

    static void characterFrequency2(String str) {
        TreeMap<Character, Integer> map = new TreeMap<>();
        for (char ch : str.toCharArray()) {
            if (map.containsKey(ch)) {
                map.put(ch, map.get(ch) + 1);
            } else {
                map.put(ch, 1);
            }
        }

        for (char ch: map.keySet()) {
            System.out.println(ch + "->" + map.get(ch));
        }
        System.out.println("-".repeat(15));
    }
}
