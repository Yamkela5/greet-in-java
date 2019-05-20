package net.greet;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;




public class CommandExtractorTest {
    @Test
    void getAname(){
        CommandExtractor commandExtractor = new CommandExtractor("greet yash xhosa");
        assertEquals("yash" , commandExtractor.getUserName());
    }
    @Test
    void getAlanguage(){
        CommandExtractor commandExtractor = new CommandExtractor("greet yash xhosa");
        assertEquals("xhosa", commandExtractor.getLanguage());
    }
    @Test
    void getCommand(){
        CommandExtractor commandExtractor = new CommandExtractor("greet");
        assertEquals("greet", commandExtractor.getCommand());
    }
    @Test
    void getGreetedCommand(){
        CommandExtractor commandExtractor = new CommandExtractor("greeted");
        assertEquals("greeted", commandExtractor.getCommand());

    }
    @Test
    void getCountCommand(){
        CommandExtractor commandExtractor = new CommandExtractor("count");
        assertEquals("count" ,commandExtractor.getCommand());
    }
}
