package ua.com.foxminded.numberUniqueCharacters;

import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        String str = "";
        Counter counter = new Counter();
        counter.print("Hello world!");
        
        Scanner in = new Scanner(System.in);
        
        do {
            System.out.print("Input a string: ");
            str = in.nextLine();
            if (str.equals("q")) {
                System.out.println("Quit program");
            } else {
                  counter.print(str);
            }
        } while (!str.equals("q"));
        in.close();
    }
}
