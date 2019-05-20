package net.greet;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CommandProcessorTest {

    @Test
    void shouldGreetUser() {
        Greeting greets = new JDBC();
        CommandExtractor command = new CommandExtractor("greet yamkela xhosa");

        CommandProcessor commandProcessor = new CommandProcessor(greets);

        assertEquals(commandProcessor.processCommands(command), "Molo, yamkela");
    }
    @Test
    void shouldCountGreetedUsers(){
        Greeting greeting = new JDBC();
        CommandExtractor commandExtractor = new CommandExtractor("count");
        CommandProcessor commandProcessor = new CommandProcessor(greeting);
        assertEquals("The number of greeted people greeted is: 0", commandProcessor.processCommands(commandExtractor));
    }
    @Test
    void shouldDisplayGreetedUsers(){
        Greeting greeting = new JDBC();
        CommandExtractor commandExtractor = new CommandExtractor("greeted");
        CommandProcessor commandProcessor = new CommandProcessor(greeting);
        assertEquals("{}", commandProcessor.processCommands(commandExtractor));
    }
    @Test
    void shouldClearAUser(){
        Greeting greeting = new JDBC();
        CommandExtractor commandExtractor = new CommandExtractor("clear Yamkela");
        CommandProcessor commandProcessor = new CommandProcessor(greeting);
        assertEquals("Yamkela has been cleared ", "Yamkela has been cleared ", commandProcessor.processCommands(commandExtractor));
    }
    @Test
    void shouldClearAllUsers(){
    Greeting greeting = new JDBC();
    CommandExtractor commandExtractor = new CommandExtractor("clear");
    CommandProcessor commandProcessor = new CommandProcessor(greeting);
    assertEquals("All names are cleared", commandProcessor.processCommands(commandExtractor));
}}