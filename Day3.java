import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Day3 {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("Day3.txt");
        Scanner scanner = new Scanner(file);

        String bank;
        int joltage1 = 0;
        int joltage2 = 0;
        int maxJoltage = 0;
        ArrayList<Integer> maxJoltages = new ArrayList<>();

        while (scanner.hasNextLine()) {
            bank = scanner.nextLine();
            for (int i = 0; i < bank.length(); i++) {
                joltage1 = Character.getNumericValue(bank.charAt(i));
                for (int j = i + 1; j < bank.length(); j++) {
                    joltage2 = Character.getNumericValue(bank.charAt(j));
                    maxJoltage = Integer.parseInt(joltage1 + "" + joltage2) > maxJoltage
                            ? Integer.parseInt(joltage1 + "" + joltage2)
                            : maxJoltage;
                }
            }
            maxJoltages.add(maxJoltage);
            maxJoltage = 0;
        }
        int sum = 0;
        for(int i : maxJoltages) {
            sum += i;
        }
        scanner.close();
        System.out.println(sum);
    }
}
