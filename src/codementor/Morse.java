package codementor;

import java.util.*;

public class Morse {
    public static Map<String, String> MORSE;
    static {
        MORSE = new HashMap<>();
        MORSE.put(".", "E");
        MORSE.put("-", "T");
        MORSE.put("..", "I");
        MORSE.put(".-", "A");
        MORSE.put("-.", "N");
        MORSE.put("--", "M");
        MORSE.put("...", "S");
        MORSE.put("..-", "U");
        MORSE.put(".-.", "R");
        MORSE.put(".--", "W");
        MORSE.put("-..", "D");
        MORSE.put("-.-", "K");
        MORSE.put("--.", "G");
        MORSE.put("---", "O");
    }

    public static List<String> possibilities(String signals) {
        List<String> results = new ArrayList<String>();
        recursiveMorse(signals, 0, results);
        return results;
    }

    public static void recursiveMorse(String signals, int position, List<String> results) {
        System.out.println(signals + " - " + position);
        if (!signals.contains("?")) {
            results.add(MORSE.get(signals));
            return;
        }
        if (position >= signals.length()) {
            return;
        }
        if (signals.charAt(position) == '?') {
            recursiveMorse(signals.substring(0, position) + "." + signals.substring(position + 1), position + 1, results);
            recursiveMorse(signals.substring(0, position) + "-" + signals.substring(position + 1), position + 1, results);
        } else {
            recursiveMorse(signals, position + 1, results);
        }
    }
    
    public static void main(String[] args) {
        List<String> possibilities = Morse.possibilities("?.");
        for (String possibility : possibilities) {
            System.out.println(possibility);
        }
    }
}
