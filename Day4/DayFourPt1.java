package Day4;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class DayFourPt1 {
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

        while (input.hasNextLine())
        {
            String line = input.nextLine();
            rows++;

            if (cols == 0)
            {
                cols = line.length();
            }
        }

        

        Scanner input2 = null;

        try {
            input2 = new Scanner(new FileInputStream("/Users/sankalpbansal/Desktop/AdventOfCode2025/Day4/input.txt"));
        } catch (FileNotFoundException e) {
            System.out.println("File does not exist");
            return;
        }

        char grid[][] = new char[rows][cols];

        int r = 0;

        while (input2.hasNextLine())
        {
            String line = input2.nextLine();

            for (int c = 0; c < cols; c++)
            {
                grid[r][c] = line.charAt(c);
            }

            r++;

        }

        int total = 0;


        for (int row = 0; row < rows; row++)
        {
            for (int col = 0; col < cols; col++)
            {
                if (grid[row][col] == '@')
                {
                    int counter = 0;
                    //check x location based on @ location
                    // * * *
                    // x @ *
                    // * * *
                    if (col != 0)
                    {
                        if (grid[row][col - 1] == '@')
                        {
                            counter++;
                        }
                    }

                    //check x location based on @ location
                    // * * *
                    // * @ x
                    // * * *
                    if (col != cols - 1)
                    {
                        if (grid[row][col + 1] == '@')
                        {
                            counter++;
                        }
                    }

                    //check x location based on @ location
                    // * x *
                    // * @ *
                    // * * *
                    if (row != 0)
                    {
                        if (grid[row - 1][col] == '@')
                        {
                            counter++;
                        }
                    }

                    //check x location based on @ location
                    // * * *
                    // * @ *
                    // * x *
                    if (row != rows - 1)
                    {
                        if (grid[row + 1][col] == '@')
                        {
                            counter++;
                        }
                    }

                    //check x location based on @ location
                    // x * *
                    // * @ *
                    // * * *
                    if ((row != 0) && (col != 0))
                    {
                        if (grid[row - 1][col - 1] == '@')
                        {
                            counter++;
                        }
                    }

                    // check x location based on @ location
                    // * * x
                    // * @ *
                    // * * *
                    if ((row != 0) && (col != cols - 1))
                    {
                        if (grid[row - 1][col + 1] == '@')
                        {
                            counter++;
                        }
                    }

                    // check x location based on @ location
                    // * * *
                    // * @ *
                    // x * *
                    if ((row != rows - 1) && (col != 0))
                    {
                        if (grid[row + 1][col - 1] == '@')
                        {
                            counter++;
                        }
                    }

                    // check x location based on @ location
                    // * * *
                    // * @ *
                    // * * x
                    if ((row != rows - 1) && (col != cols - 1))
                    {
                        if (grid[row + 1][col + 1] == '@')
                        {
                            counter++;
                        }
                    }

                    if (counter < 4)
                    {
                        total++;
                    }
                }
            }
        }

        System.out.println("Counter: " + total);

    }
}
