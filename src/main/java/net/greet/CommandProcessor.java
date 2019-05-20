package net.greet;

public class CommandProcessor {
    JDBC jdbc = new JDBC();
    public String processCommands(CommandExtractor commandProcessor) {
        if (commandProcessor.getCommand().equals("greet")) {
            if(commandProcessor.getUserName() == null) {
                return "Please enter a name you'd like to greet.";
            }

            return  jdbc.greet(commandProcessor.getUserName(), commandProcessor.getLanguage());

        } else if (commandProcessor.getCommand().equals("greeted")) {
            return jdbc.greeted(commandProcessor.getUserName());
        } else if (commandProcessor.getCommand().equalsIgnoreCase("clear " + commandProcessor.getUserName())) {
            jdbc.clear(commandProcessor.getUserName());
        } else if (commandProcessor.getCommand().equals("count")) {
            return jdbc.count();
        } else if (commandProcessor.getCommand().equals("clear")) {

            if (commandProcessor.getUserName() != null) {
                jdbc.clear(commandProcessor.getUserName());
            } else {
                jdbc.clearAll();
            }
        }
        else if (commandProcessor.getCommand().equals("help")) {

            return jdbc.help();
        }
       else{

            return "Invalid command!\n" + jdbc.help();
        }
        return "";
    }
}