package net.greet;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GreetTest {
    @Test
    void shouldGreet() {
        Greets greeter = new Greets();
        greeter.greet("Yamkela", "xhosa");
        greeter.greet("Yash", "TshiVenda");
        assertEquals(greeter.greet("Yamkela", "setswana"), "Dumela, Yamkela");
    }

    @Test
    void shouldReturnGreetedUsers() {
        Greets greeter = new Greets();
        assertEquals(greeter.greeted(""), "{}");

    }

    @Test
    public void shouldClearOneUser() {

        Greets greeted = new Greets();
        greeted.greeted("Lelo");
        greeted.greeted("Mawu");
        greeted.greeted("Owam");
        greeted.greeted("Simo");
        greeted.greeted("Yash");
        assertEquals("Yash cleared", greeted.clear("Yash"));
    }
    @Test
    public void shouldRemoveAllUsers() {

        Greets greeted = new Greets();
        greeted.greeted("Yamkela");
        greeted.greeted("Yamkela");
        greeted.greeted("Lelo");
        greeted.greeted("Mfundo");
        greeted.greeted("Spokie");
        assertEquals("All names are cleared", greeted.clearAll());

    }
}
