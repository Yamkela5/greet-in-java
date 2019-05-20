package net.greet;

import java.util.HashMap;
import java.util.Map;

public class Greets implements Greeting {
    private Map<String, Integer> map = new HashMap<String, Integer>();

    public String greet(String name, String language) {
        if (map.containsKey(name)) {
            map.put(name, map.get(name) + 1);
        } else {
            map.put(name, 1);
        }

        try {
            return Language.valueOf(language).getMyLanguage() + name;
        }catch (Exception e) {
            return Language.valueOf("setswana").getMyLanguage() + name;
        }

    }
    public String greeted(String name) {
        try {
            if (name.equals("")) {
                return map.toString();
            }
            else {
                return name + " has been greeted " + map.get(name) + " time(s)";
            }
        } catch (Exception e) {
            return map.toString();
        }

    }

    public String count() {

        return "Names greeted " + map.size();
    }
    public String clear(String userName){
        map.remove(userName);
        return userName + " cleared";
    }

    public String clearAll() {
        map.clear();
        return "All names are cleared";
    }

    public String help(){
        return"greet >> followed by the name and the language the user is to be greeted in,\n" +
                "greeted >> should display a list of all users that has been greeted and how many time each user has been greeted,\n" +
                "greeted followed by a username >> returns how many times that username have been greeted,\n" +
                "counter >> returns a count of how many unique users has been greeted,\n" +
                "clear >> deletes of all users greeted and the reset the greet counter to 0,\n" +
                "clear followed by a username >> delete the greet counter for the specified user and decrement the greet counter by 1,\n" +
                "exit >> exits the application,\n" +
                "help >> shows a user an overview of all possible commands.";
    }
}