package Day3;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class DayThreePt2 {
    public static void main(String[] args) {

        Scanner input = null;

        try {
            input = new Scanner(new FileInputStream("/Users/sankalpbansal/Desktop/AdventOfCode2025/Day3/input.txt"));
        } catch (FileNotFoundException e) {
            System.out.println("File does not exist");
            return;
        }

        long total = 0;

        while (input.hasNextLine())
        {
            String batteryLine = input.nextLine();
            
            int lenLine = batteryLine.length();

            int need = 12;

            int startIndex = 0;

            long maxNum = 0;

            while (need > 0)
            {
                int endIndex = lenLine - need;

                int maxDigit = -1;
                int maxIndex = -1;

                for (int i = startIndex; i <= endIndex; i++)
                {
                    int digit = batteryLine.charAt(i) - '0';
                    if (digit > maxDigit)
                    {
                        maxDigit = digit;
                        maxIndex = i;
                    }
                }

                maxNum = maxNum * 10 + maxDigit;

                startIndex = maxIndex + 1;
                need--;
            }

            total += maxNum;
        }

        System.out.println("Max Joltage: " + total);

    }
}
