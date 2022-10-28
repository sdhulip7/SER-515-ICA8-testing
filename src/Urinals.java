import java.io.*;
import java.util.*;

//Author - Sri Venkata Vivek Dhulipala
public class Urinals {

    static boolean isValidString(String str) { // checks if the String is valid and returns -1.
        int n = str.length();
        boolean flag=true;
        for(int i=0;i<n;i++) {
            if(str.charAt(i) != '0' && str.charAt(i) !='1') {
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

    static int urinalsCount(String str) { // checks the number of available urinals
        if(isValidString(str) == false) return -1;
        int cnt=0, n=str.length();
        StringBuilder s = new StringBuilder(str);
        for(int i=0;i<n;i++) {
            if(s.charAt(i)=='0') {
                boolean leftZero = (i==0) || (s.charAt(i-1)=='0');
                boolean rightZero = (i==n-1) || (s.charAt(i+1)=='0');

                if(leftZero && rightZero) {
                    cnt++;
                    s.setCharAt(i,'1');
                }
            }
        }
        return cnt;
    }

    public static void main(String[] args) { // prints the available urinals count.
        System.out.println("Not yet implemented");
    }
}