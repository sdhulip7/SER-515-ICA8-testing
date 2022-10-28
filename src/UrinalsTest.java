import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;


class UrinalsTest {

    @org.junit.jupiter.api.Test
    void isValidString() {
        System.out.println("====== Sri Venkata Vivek Dhulipala == TEST ONE EXECUTED ======= IsValidString");
        Assertions.assertEquals(Urinals.isValidString("Hi"),false);
        System.out.println("====== Sri Venkata Vivek Dhulipala == TEST TWO EXECUTED ======= IsValidString");
        Assertions.assertEquals(Urinals.isValidString("10101"),true);
    }

    @Test
    void urinalsCount() {
        System.out.println("====== Sri Venkata Vivek Dhulipala == TEST ONE EXECUTED ======= UrinalsCount");
        Assertions.assertEquals(Urinals.urinalsCount("10001"), 1);
        System.out.println("====== Sri Venkata Vivek Dhulipala == TEST TWO EXECUTED ======= UrinalsCount");
        Assertions.assertEquals(Urinals.urinalsCount("1001"), 0);
        System.out.println("====== Sri Venkata Vivek Dhulipala == TEST THREE EXECUTED ======= UrinalsCount");
        Assertions.assertEquals(Urinals.urinalsCount("00000"), 3);
        System.out.println("====== Sri Venkata Vivek Dhulipala == TEST FOUR EXECUTED ======= UrinalsCount");
        Assertions.assertEquals(Urinals.urinalsCount("0000"), 2);
        System.out.println("====== Sri Venkata Vivek Dhulipala == TEST FIVE EXECUTED ======= UrinalsCount");
        Assertions.assertEquals(Urinals.urinalsCount("01000"), 1);
        System.out.println("====== Sri Venkata Vivek Dhulipala == TEST SIX EXECUTED ======= UrinalsCount");
        Assertions.assertEquals(Urinals.urinalsCount("011"), -1);
    }

    @Test
    void createFile() {
        System.out.println("====== Sri Venkata Vivek Dhulipala == TEST ONE EXECUTED ======= createFile");
        Assertions.assertNotEquals(Urinals.createFile(),null);
    }

    @Test
    void writeOutput() {
        System.out.println("====== Sri Venkata Vivek Dhulipala == TEST ONE EXECUTED ======= writeOutput");
        File f = new File("test.txt");
        Assertions.assertEquals(Urinals.writeOutput("test rule.txt", f), true);
    }
}