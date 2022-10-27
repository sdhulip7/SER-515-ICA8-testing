import org.junit.jupiter.api.Assertions;

import static org.junit.jupiter.api.Assertions.*;


class UrinalsTest {

    @org.junit.jupiter.api.Test
    void testIsValidString() {
        System.out.println("====== Sri Venkata Vivek Dhulipala == TEST ONE EXECUTED =======");
        Assertions.assertEquals(Urinals.isValidString("Hi"),false);
    }
}