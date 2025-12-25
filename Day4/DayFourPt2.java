package Day4;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class DayFourPt2 {
    public static void main(String[] args) {

        Scanner input = null;

        try {
            input = new Scanner(new FileInputStream("/Users/sankalpbansal/Desktop/AdventOfCode2025/Day4/input.txt"));
        } catch (FileNotFoundException e) {
            System.out.println("File does not exist");
            return;
        }

        int rows = 0;
        int cols = 0;

        while (input.hasNextLine()) {
            String line = input.nextLine();
            rows++;
            if (cols == 0) {
                cols = line.length();
            }
        }
        input.close();

        Scanner input2 = null;
        try {
            input2 = new Scanner(new FileInputStream("/Users/sankalpbansal/Desktop/AdventOfCode2025/Day4/input.txt"));
        } catch (FileNotFoundException e) {
            System.out.println("File does not exist");
            return;
        }

        char[][] grid = new char[rows][cols];
        int r = 0;

        while (input2.hasNextLine()) {
            String line = input2.nextLine();
            for (int c = 0; c < cols; c++) {
                grid[r][c] = line.charAt(c);
            }
            r++;
        }
        input2.close();

        int total = 0;
        boolean stillLeft = true;

        while (stillLeft) {
            stillLeft = false;

            boolean[][] toRemove = new boolean[rows][cols];

            for (int row = 0; row < rows; row++) {
                for (int col = 0; col < cols; col++) {

                    if (grid[row][col] == '@') {
                        int counter = 0;

                        // LEFT
                        if (col != 0 && grid[row][col - 1] == '@') counter++;

                        // RIGHT
                        if (col != cols - 1 && grid[row][col + 1] == '@') counter++;

                        // UP
                        if (row != 0 && grid[row - 1][col] == '@') counter++;

                        // DOWN
                        if (row != rows - 1 && grid[row + 1][col] == '@') counter++;

                        // TOP-LEFT
                        if (row != 0 && col != 0 && grid[row - 1][col - 1] == '@') counter++;

                        // TOP-RIGHT
                        if (row != 0 && col != cols - 1 && grid[row - 1][col + 1] == '@') counter++;

                        // BOTTOM-LEFT
                        if (row != rows - 1 && col != 0 && grid[row + 1][col - 1] == '@') counter++;

                        // BOTTOM-RIGHT
                        if (row != rows - 1 && col != cols - 1 && grid[row + 1][col + 1] == '@') counter++;

                        if (counter < 4) {
                            toRemove[row][col] = true;
                        }
                    }
                }
            }

            for (int row = 0; row < rows; row++) {
                for (int col = 0; col < cols; col++) {
                    if (toRemove[row][col]) {
                        grid[row][col] = '.';
                        total++;
                        stillLeft = true;
                    }
                }
            }
        }

        System.out.println("Counter: " + total);
    }
}