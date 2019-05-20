package net.greet;

public class CommandProcessor {
    Greeting greeting;
    public CommandProcessor(Greeting greeting) {
        this.greeting = greeting;
    }
    public String processCommands(CommandExtractor commandProcessor) {
        if (commandProcessor.getCommand().equals("greet")) {
            if(commandProcessor.getUserName() == null) {
                return "Please enter a name you'd like to greet.";
            }

            return  greeting.greet(commandProcessor.getUserName(), commandProcessor.getLanguage());

        } else if (commandProcessor.getCommand().equals("greeted")) {
            return greeting.greeted(commandProcessor.getUserName());
        } else if (commandProcessor.getCommand().equalsIgnoreCase("clear " + commandProcessor.getUserName())) {
            greeting.clear(commandProcessor.getUserName());
        } else if (commandProcessor.getCommand().equals("count")) {
            return greeting.count();
        } else if (commandProcessor.getCommand().equals("clear")) {
            if (commandProcessor.getUserName() != null) {
               return greeting.clear(commandProcessor.getUserName());
            } else {
                return greeting.clearAll();
            }
        }
       else{

            return "Invalid command!\n" + greeting.help();
        }
        return "";
    }
}