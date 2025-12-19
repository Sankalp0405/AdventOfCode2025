package Day2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class DayTwoPt1 {
    public static void main(String[] args) {
        //get input
        Scanner input = null;

        try {
            input = new Scanner(new FileInputStream("/Users/sankalpbansal/Desktop/AdventOfCode2025/Day2/input.txt"));
        } catch (FileNotFoundException e) {
            System.out.println("File does not exist");
            return;
        }

        input.useDelimiter(",");

        //what im going to return at the end
        long total = 0;

        //loop over input
        while (input.hasNext())
        {
            String range = input.next().trim();
            
            int dash = range.indexOf("-");

            String num1 = range.substring(0, dash);
            String num2 = range.substring(dash + 1);


            long start = Long.parseLong(num1);
            long end = Long.parseLong(num2);

            for (long i = start; i <= end; i++)
            {
                String temp = Long.toString(i);
                if (temp.length() % 2 == 0)
                {
                    int tempLen = temp.length();
                    int halfLen = tempLen / 2;

                    String firstHalf = temp.substring(0, halfLen);
                    String secondHalf = temp.substring(halfLen);

                    if (firstHalf.equals(secondHalf))
                    {
                        total = total + i;
                    }
                }
            }

        }


        System.out.println("Total value of Invalid Numbers: " + total);

    }
}