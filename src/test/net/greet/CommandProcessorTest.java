package net.greet;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CommandProcessorTest {

    @Test
    void getCommand() {
        CommandExtractor command = new CommandExtractor("greet yamkela xhosa");

CommandProcessor commandProcessor = new CommandProcessor();

        assertEquals(commandProcessor.processCommands(command), "Molo, yamkela");
}

    @Test
    void getCommand_2() {
        CommandExtractor command = new CommandExtractor("greet yamkela");

        assertEquals("greet", command.getCommand());
        assertEquals("yamkela", command.getUserName());
        assertEquals("english", command.getLanguage());
    }

    @Test
    void getCommand_3() {
        CommandExtractor command = new CommandExtractor("greet");

        assertEquals("greet", command.getCommand());
        assertEquals(null, command.getUserName());
        assertEquals("english", command.getLanguage());
    }
    @Test
    void greetedCommand(){
        CommandExtractor commandProcessor = new CommandExtractor("greeted");
        assertEquals("greeted", commandProcessor.getCommand());
    }
    @Test
    void greetedCommand_2(){
        CommandExtractor commandProcessor = new CommandExtractor("greeted yash");
        assertEquals("greeted", commandProcessor.getCommand());
        assertEquals("yash", commandProcessor.getUserName());
    }
    @Test
    void counterCommand(){
        CommandExtractor commandProcessor = new CommandExtractor("count");
        assertEquals("count", commandProcessor.getCommand());
    }
}