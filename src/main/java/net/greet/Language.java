package net.greet;

public enum Language {
    setswana("Dumela, "),
    english("Hello, "),
    xhosa("Molo, ");

    private final String myLanguage;

    Language(String myLanguage) {
        this.myLanguage = myLanguage;
    }

    public String getMyLanguage() {
        return myLanguage;
    }
}
