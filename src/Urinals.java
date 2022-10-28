import java.io.*;
import java.util.*;

//Author - Sri Venkata Vivek Dhulipala
public class Urinals {

    static boolean isValidString(String str) { // checks if the String is valid and returns -1.
        int n = str.length();
        boolean flag=true;
        for(int i=0;i<n;i++) {
            if(str.charAt(i) != '0' || str.charAt(i) !='1') {
                flag=false;
            }
            if(i!=n-1) {
                if (str.charAt(i) == '1' && str.charAt(i+1) == '1') {
                    flag=false;
                }
            }
        }
        return flag;
    }

    int urinalsCount(String str) { // checks the number of available urinals
        return 0;
    }

    public static void main(String[] args) { // prints the available urinals count.
        System.out.println("Not yet implemented");
    }
}