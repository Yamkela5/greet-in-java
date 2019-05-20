package net.greet;

import java.util.Scanner;

public class Greet {
    public static void main(String[] args) {


        Scanner myScanner = new Scanner(System.in);
        Greeting greets = new JDBC();
        CommandProcessor commandExtracter = new CommandProcessor();

        while (true) {
            System.out.println("Please enter a command");
            String input = myScanner.nextLine();
            CommandExtractor commandProcessor = new CommandExtractor(input);


            if (commandProcessor.getCommand().equals("exit")) {
                break;
            }
            else {
                System.out.println(commandExtracter.processCommands(commandProcessor));
            }
        }
    }
}