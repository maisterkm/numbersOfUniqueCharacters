package ua.com.foxminded.numberUniqueCharacters;

import java.util.Scanner;

public class App 
{
    public static void main( String[] args )
    {
        String str = "";
        Counter counter = new Counter();
        Scanner in = new Scanner(System.in);
        do {
            System.out.print("Input a string: ");
            str = in.nextLine();
            if (str.equals("q")) {
                System.out.println("Program was terminated");
            } else {
                counter.addStringToGlobalMap(str);
                counter.print(str);
                counter.countCharacterType(str);
                counter.printFrequencyFromGlobalMap();
                System.out.println("Number continuous consonant sequences in the line: " + counter.countConsonantSequences(str));
                counter.printContinuousConsonantSequences();
                counter.printMinMaxIndexForSymbol(str);
            }
        } while (!str.equals("q"));
        in.close();
    }
}
