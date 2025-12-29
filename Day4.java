// --- Day 4: Printing Department --- 
// You ride the escalator down to the printing department. They're clearly getting ready for Christmas; they have lots of large rolls of paper everywhere, and there's even a massive printer in the corner (to handle the really big print jobs).

// Decorating here will be easy: they can make their own decorations. What you really need is a way to get further into the North Pole base while the elevators are offline.

// "Actually, maybe we can help with that," one of the Elves replies when you ask for help. "We're pretty sure there's a cafeteria on the other side of the back wall. If we could break through the wall, you'd be able to keep moving. It's too bad all of our forklifts are so busy moving those big rolls of paper around."

// If you can optimize the work the forklifts are doing, maybe they would have time to spare to break through the wall.

// The rolls of paper (@) are arranged on a large grid; the Elves even have a helpful diagram (your puzzle input) indicating where everything is located.

// For example:

// ..@@.@@@@.
// @@@.@.@.@@
// @@@@@.@.@@
// @.@@@@..@.
// @@.@@@@.@@
// .@@@@@@@.@
// .@.@.@.@@@
// @.@@@.@@@@
// .@@@@@@@@.
// @.@.@@@.@.
// The forklifts can only access a roll of paper if there are fewer than four rolls of paper in the eight adjacent positions. If you can figure out which rolls of paper the forklifts can access, they'll spend less time looking and more time breaking down the wall to the cafeteria.

// In this example, there are 13 rolls of paper that can be accessed by a forklift (marked with x):

// ..xx.xx@x.
// x@@.@.@.@@
// @@@@@.x.@@
// @.@@@@..@.
// x@.@@@@.@x
// .@@@@@@@.@
// .@.@.@.@@@
// x.@@@.@@@@
// .@@@@@@@@.
// x.x.@@@.x.
// Consider your complete diagram of the paper roll locations. How many rolls of paper can be accessed by a forklift?

// Your puzzle answer was 1474.

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Day4 {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("Day4.txt");
        Scanner scanner = new Scanner(file);

        ArrayList<String> rows = new ArrayList<>();
        while (scanner.hasNextLine()) {
            rows.add(scanner.nextLine());
        }

        int adjacentRolls = 0;
        int accessibleRolls = 0;
        String rowString = "";

        for (int row = 0; row < rows.size(); row++) {
            rowString = rows.get(row);
            for (int column = 0; column < rowString.length(); column++) {
                if (rowString.charAt(column) == '@') {

                    if (row > 0) {
                        if (column > 0) {
                            if (rows.get(row - 1).charAt(column - 1) == '@') {
                                adjacentRolls++;
                            }
                        }
                        if (rows.get(row - 1).charAt(column) == '@') {
                            adjacentRolls++;
                        }
                        if (column < rowString.length() - 1) {
                            if (rows.get(row - 1).charAt(column + 1) == '@') {
                                adjacentRolls++;
                            }
                        }
                    }

                    if (column > 0) {
                        if (rows.get(row).charAt(column - 1) == '@') {
                            adjacentRolls++;
                        }
                    }

                    if (column < rowString.length() - 1) {
                        if (rows.get(row).charAt(column + 1) == '@') {
                            adjacentRolls++;
                        }
                    }

                    if (row < rows.size() - 1) {
                        if (column > 0)
                            if (rows.get(row + 1).charAt(column - 1) == '@') {
                                adjacentRolls++;
                            }
                        if (rows.get(row + 1).charAt(column) == '@') {
                            adjacentRolls++;
                        }
                        if (column < rowString.length() - 1) {
                            if (rows.get(row + 1).charAt(column + 1) == '@') {
                                adjacentRolls++;
                            }
                        }
                    }

                    if (adjacentRolls < 4) {
                        accessibleRolls++;
                    }
                    adjacentRolls = 0;
                }
            }
        }

        for (String row : rows) {
            System.out.println(row);
        }
        System.out.println(accessibleRolls);
    }
}

