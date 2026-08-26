package practiceTest.java;

/**
 * 5. StringsAssignment:Build a mini text analyzer that counts vowels, consonants,
 * words, and reverses the input string.
 * Sample Input:
 * Enter a sentence: Java is fun!
 * Expected Output:
 * Vowels: 4
 * Consonants: 5
 * Words: 3
 * Reversed: !nuf si avaj
 * */

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.HashSet;

class StringOp {
    static void main(String[] args) {
        String str = "Java is fun!";
        Map<Character, Integer> letterMap = countLetters(str);
        Map<String, Integer> vowelsAndConsonants = countVowelsAndConsonants(letterMap);
        String[] words = countWords(str);

        System.out.println("Vowels: " + vowelsAndConsonants.get("vowels"));
        System.out.println("Consonants: " + vowelsAndConsonants.get("consonants"));
        System.out.println("Words: " + words.length);
        System.out.println("Reversed: " + reversed(str));
    }

    private static Map<Character, Integer> countLetters(String str) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c: str.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        return map;
    }

    private static Map<String, Integer> countVowelsAndConsonants(Map<Character, Integer> map) {
        Map<String, Integer> resultMap = new HashMap<>();
        Set<Character> vowels = new HashSet<>();
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');
        for (Map.Entry<Character, Integer> entry: map.entrySet()) {
            if (vowels.contains(entry.getKey()))  {
                resultMap.put("vowels", resultMap.getOrDefault("vowels", 0) + entry.getValue());
//                System.out.println("letter: " + entry.getKey());
//                System.out.println("vowels: " + resultMap.get("vowels"));
            } else if (!entry.getKey().equals(' ') && !entry.getKey().equals('!')) {
                resultMap.put("consonants", resultMap.getOrDefault("consonants", 0) + entry.getValue());
            }
        }
        return resultMap;
    }

    private static String[] countWords(String str) {
        return str.split(" ");
    }

    private static String reversed(String str) {
//        StringBuilder stringBuilder = new StringBuilder(str).reverse();
        StringBuilder reversedStr = new StringBuilder();
        for (char c: str.toCharArray()) {
            reversedStr.insert(0,c);
        }
        return reversedStr.toString();
    }
}
