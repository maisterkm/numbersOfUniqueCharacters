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
                counter.printNumbersUniqueCharachters(str);
                counter.printNumbersUniqueCharachtersInGlobalText();
                counter.printNumbersOfCharactersTypes(str);
                counter.printContinuousConsonantSequences(str);
                counter.printMinMaxIndexForSymbol(str);
            }
        } while (!str.equals("q"));
        in.close();
    }
}
