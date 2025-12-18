import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class DayOnePt2 {
    public static void main(String[] args) {

        // setup file input
        Scanner fileReader = null;
        try {
            fileReader = new Scanner(new FileInputStream("/Users/sankalpbansal/Desktop/AdventOfCode2025/Day1/input.txt"));
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
            return;
        }

        long dialPointer = 50;
        long countZero = 0;

        while (fileReader.hasNextLine()) {
            String line = fileReader.nextLine().trim();
            if (line.isEmpty()) continue;

            char direction = line.charAt(0);
            long steps = Long.parseLong(line.substring(1));

            long fullRotations = steps / 100;
            long rest = steps % 100;

            // each full 100 clicks hits 0 exactly once
            countZero += fullRotations;

            // remainder (<100) can hit 0 at most once
            if (rest != 0 && dialPointer != 0) {
                if (direction == 'R') {
                    if (rest >= (100 - dialPointer)) {
                        countZero++;
                    }
                } else { // 'L'
                    if (rest >= dialPointer) {
                        countZero++;
                    }
                }
            }

            // update pointer (full rotations don't change it)
            if (direction == 'R') {
                dialPointer += rest;
            } else { // L
                dialPointer -= rest;
            }

            dialPointer = dialPointer % 100;
            if (dialPointer < 0) dialPointer += 100;
        }

        fileReader.close();
        System.out.println(countZero);
    }
}