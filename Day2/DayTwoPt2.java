package Day2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class DayTwoPt2 {
    public static void main(String[] args) {
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

        while (input.hasNext())
        {
            String range = input.next().trim();
            
            int dash = range.indexOf("-");

            String num1 = range.substring(0, dash);
            String num2 = range.substring(dash + 1);


            long start = Long.parseLong(num1);
            long end = Long.parseLong(num2);

            for (long curNum = start; curNum <= end; curNum++)
            {
                String temp = Long.toString(curNum);
                int currNumLen = temp.length();

                for (int i = 1; i <= currNumLen / 2; i++)
                {
                    if (currNumLen % i == 0)
                    {
                        int numChunks = currNumLen / i;

                        String pattern = temp.substring(0, i);

                        String patternAdded = "";
                        
                        for (int j = 0; j < numChunks; j++)
                        {
                            patternAdded = patternAdded + pattern;
                        }

                        if (patternAdded.equals(temp))
                        {
                            total = total + curNum;
                            break;
                        }
                    }
                }
            }
        }

        System.out.println("Total value of Invalid Numbers: " + total);
    }
}
