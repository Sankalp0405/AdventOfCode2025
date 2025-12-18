import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class DayOnePt1 {
    public static void main(String[] args) {
        
        //setup file input
        Scanner fileReader = null;
        try {
            fileReader = new Scanner(new FileInputStream("/Users/sankalpbansal/Desktop/AdventOfCode2025/Day1/input.txt"));
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }

        int dialPointer = 50;
        int countZero = 0;

        while (fileReader.hasNextLine()) {
            String line = fileReader.nextLine();

            String direction = line.substring(0, 1);
            int steps = Integer.parseInt(line.substring(1));

            //if left
            if (direction.equals("L"))
            {
                dialPointer = dialPointer - steps;

                dialPointer = (dialPointer + 100) % 100;

                //if dialPointer is 0, increment countZero
                if (dialPointer == 0)
                {
                    countZero++;
                }
            }

            else if (direction.equals("R"))
            {
                dialPointer = dialPointer + steps;

                dialPointer = (dialPointer + 100) % 100;

                //if dialPointer is 0, increment countZero
                if (dialPointer == 0)
                {
                    countZero++;
                }
            }
        }

        System.out.println("Count of 0s: " + countZero);
    }
}