import java.util.*;

public class Solution {

    public static Map<String, String> map = new HashMap<>();

    public static void main(String[] args) {

        String s = "abcabcabcdeco";
        String s1 = "aaabbc";
        String s2 = "daaca";
        String s3 = "acdcdecd";

        findSubstrings(s);
        findSubstrings(s1);
        findSubstrings(s2);
        findSubstrings(s3);
    }

    public static void findSubstrings(String param) {

        int half = param.length() / 2;

        int length = param.length();

        Queue<String> queue = new LinkedList<>();

        while (half > 0) {
            int start = 0;
            while (start <= length) {

                int end = start + half > length ? (length - start) + start : (start + half) - 1;
                String s = param.substring(start, end);

                if (s.length() > 0) {
                    queue.add(s);
                }
                start++;
            }
            half--;
        }

        while (!queue.isEmpty()) {

            String value = queue.poll();
            int index = param.indexOf(value);

            if (param != null && value != null && index >= 0 && param.length() > 1) {

                int len = value.length();
                int end = index + len;

                String found = param.substring(index, end);
                param = removeRepeatedSequences(param, found);

            }

        }

        print(param);

    }

    public static String removeRepeatedSequences(String sequence, String substring) {

        int position = sequence.indexOf(substring);
        int len = substring.length();
        int nextPosition = position + len;

        if (map.containsKey(substring)) {
            int idx = sequence.indexOf(substring, nextPosition);

            if (idx > 0) {
                StringBuilder sb = new StringBuilder();

                String firstHalf = sequence.substring(0, idx);
                String secondHalf = sequence.substring(idx);

                sb.append(firstHalf);

                if (firstHalf.contains(substring) && firstHalf.endsWith(substring) && secondHalf.startsWith(substring)) {
                    secondHalf = secondHalf.replaceFirst(substring, "");
                }

                sb.append(secondHalf);
                sequence = sb.toString();
            }

        } else {
            map.put(substring, substring);
        }

        return sequence;

    }

    private static void print(String s) {
        System.out.println(s);
    }


}


