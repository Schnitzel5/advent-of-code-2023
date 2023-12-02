import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DayOne {

    public static void main(String[] args) throws IOException {
        var data = Files.readAllLines(new File("data/day1.txt").toPath());
        long sum = 0;
        for (var line : data) {
            List<Character> nums = new ArrayList<>();
            Map<Integer, Character> extractedNums = new HashMap<>();
            extractedNums.put(line.indexOf("one"), '1');
            extractedNums.put(line.lastIndexOf("one"), '1');
            extractedNums.put(line.indexOf("two"), '2');
            extractedNums.put(line.lastIndexOf("two"), '2');
            extractedNums.put(line.indexOf("three"), '3');
            extractedNums.put(line.lastIndexOf("three"), '3');
            extractedNums.put(line.indexOf("four"), '4');
            extractedNums.put(line.lastIndexOf("four"), '4');
            extractedNums.put(line.indexOf("five"), '5');
            extractedNums.put(line.lastIndexOf("five"), '5');
            extractedNums.put(line.indexOf("six"), '6');
            extractedNums.put(line.lastIndexOf("six"), '6');
            extractedNums.put(line.indexOf("seven"), '7');
            extractedNums.put(line.lastIndexOf("seven"), '7');
            extractedNums.put(line.indexOf("eight"), '8');
            extractedNums.put(line.lastIndexOf("eight"), '8');
            extractedNums.put(line.indexOf("nine"), '9');
            extractedNums.put(line.lastIndexOf("nine"), '9');
            var sorted = extractedNums.keySet().stream().filter(i -> i != -1).sorted().toList();
            int firstIdx = -1;
            int lastIdx = -1;
            if (!sorted.isEmpty()) {
                firstIdx = sorted.getFirst();
                lastIdx = sorted.getLast();
                System.out.println(firstIdx + "\t" + lastIdx);
            }
            for (int i = 0; i < line.length(); i++) {
                if (i == firstIdx) {
                    nums.add(extractedNums.get(firstIdx));
                    continue;
                }
                if (i == lastIdx) {
                    nums.add(extractedNums.get(lastIdx));
                    continue;
                }
                char c = line.charAt(i);
                if (c >= 48 && c <= 57) {
                    nums.add(c);
                }
            }
            //System.out.println(nums.getFirst() + "\t" + nums.getLast());
            long combined = Integer.parseInt(nums.getFirst() + "" + nums.getLast());
            sum += combined;
        }
        System.out.println("Result: " + sum);
    }

}
