package Day3;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class DayThreePt1 {
    public static void main(String[] args) {


        Scanner input = null;

        try {
            input = new Scanner(new FileInputStream("/Users/sankalpbansal/Desktop/AdventOfCode2025/Day3/input.txt"));
        } catch (FileNotFoundException e) {
            System.out.println("File does not exist");
            return;
        }

        int total = 0;

        while (input.hasNextLine())
        {
            String batteryLine = input.nextLine();
            
            int lenLine = batteryLine.length();

            int max1 = (batteryLine.charAt(0)) - '0';
            int max2 = (batteryLine.charAt(1)) - '0';

            int temp = (max1 * 10) + max2;
            int maxNum = temp;

            for (int i = 0; i < lenLine; i++)
            {
                max1 = batteryLine.charAt(i) - '0';

                for (int j = i + 1; j < lenLine; j++)
                {
                    max2 = batteryLine.charAt(j) - '0';

                    temp = (max1 * 10) + max2;

                    if (temp > maxNum)
                    {
                        maxNum = temp;
                    }
                }
            }

            total += maxNum;
        }

        System.out.println("Total max Joltage: " + total);
    }
}
