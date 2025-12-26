import java.nio.file.Files;
import java.nio.file.Path;

public class Day2 {
    public static void main(String[] args) throws Exception {

        String input = Files.readString(Path.of("Day2.txt"));
        String[] idRangesArray = input.split(",");
        long invalidSum = 0;

        for (String idRange : idRangesArray) {
            long min = Long.parseLong(idRange.substring(0, idRange.indexOf("-")));
            long max = Long.parseLong(idRange.substring(idRange.indexOf("-") + 1).trim());
            for (long i = min; i <= max; i++) {
                String num = Long.toString(i);
                int digitCount = num.length();
                if (digitCount % 2 == 0) {
                    if (num.substring(0, digitCount / 2).equals(num.substring(digitCount / 2))) {
                        invalidSum += i;
                    }
                }
            }
        }
        System.out.println("SUM OF INVALID IDS:" + invalidSum);
    }
}