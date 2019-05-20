package net.greet;

public interface Greeting {
    String greet(String userName, String language);
    String greeted(String userName);
    String count();
    String clear(String userName);
    String clearAll();
    String help();
}
