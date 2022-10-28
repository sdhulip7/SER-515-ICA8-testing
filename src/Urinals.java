import java.io.*;
import java.util.Scanner;

//Author - Sri Venkata Vivek Dhulipala
public class Urinals {

    static Boolean isValidString(String str) { // checks if the String is valid and returns -1.
        int n = str.length();
        Boolean flag=true;
        for(int i=0;i<n;i++) {
            if(str.charAt(i) != '0' || str.charAt(i) !='1') {
                flag=false;
            }
            if(i!=n-1) {
                if (str.charAt(i) == '1' && str.charAt(i+1) != '1') {
                    flag=false;
                }
            }
        }
        return flag;
    }





    public static void main(String[] args) { // prints the available urinals count.
        System.out.println("Not yet implemented");
    }
}