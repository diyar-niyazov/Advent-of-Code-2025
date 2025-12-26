import java.io.File;
import java.util.Scanner;

public class Day1 {
    public static void main(String[] args) throws Exception {
        File file = new File("Day1.txt");
        Scanner scanner = new Scanner(file);

        int zeroCount = 0;
        int position = 50;
        int number;

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            number = Integer.parseInt(line.substring(1));
            position += line.charAt(0) == 'L' ? number * -1 : number;
            if (position > 99) {
                position %= 100;
            }
            while(position < 0) {
                position += 100;
            }
            if(position == 0) {
                zeroCount++;
            }
            System.out.println("POSITION: " + position);
            System.out.println("ZEROCOUNT: " + zeroCount);
        }
    }
}