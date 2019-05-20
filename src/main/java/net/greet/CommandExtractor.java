package net.greet;

public class CommandExtractor {
    String command;
    String userName;
    String language;
    public CommandExtractor(String input) {
        String[] inputs = input.split(" ");
        this.command = inputs[0].toLowerCase();

            if(inputs.length == 3) {
                this.language = inputs[2].toLowerCase();
            } else {
                this.language = "english";
            }

            if (inputs.length >= 2){
                userName = inputs[1].toLowerCase();
            }

    }

    public String getUserName() {

        return userName;
    }

    public String getCommand() {

        return command;
    }

    public String getLanguage() {

        return language;
    }
}

