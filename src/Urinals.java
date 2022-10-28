import java.io.*;
import java.util.*;

//Author - Sri Venkata Vivek Dhulipala
public class Urinals {

    public static int file_no = 0;
    static boolean isValidString(String str) { // checks if the String is valid and returns -1.
        int n = str.length();
        boolean flag=true;
        for(int i=0;i<n;i++) {
            if(str.charAt(i) != '0' && str.charAt(i) !='1') {
                flag=false;
                break;
            }
            if(i!=n-1) {
                if (str.charAt(i) == '1' && str.charAt(i+1) == '1') {
                    flag=false;
                    break;
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
    private static void openAndprocessDatFile(Urinals urinal, StringBuilder op) throws IOException {
        File daFile = new File("src/urinal.dat");
        FileReader fr = new FileReader(daFile);
        if(fr == null) {
            System.err.println("Error in reading dat file");
            System.exit(1);
        }
        Scanner sc = new Scanner(fr);
        String input;
        while(sc.hasNextLine()) {
            input = sc.nextLine();
            if(input.compareTo("-1")==0) break;
            boolean isValidInput = urinal.isValidString(input);
            if(isValidInput) {
                int cnt = urinal.urinalsCount(input);
                op.append(cnt+"\n");
            } else {
                op.append("-1"+"\n");
            }
        }
    }

    private static void processTerminalInput(Urinals urinal, StringBuilder op) {
        while(true) {
            Scanner sc = new Scanner(System.in);
            String input =sc.nextLine().trim();
            if(input.equals("-1"))break;
            boolean isValidInput = urinal.isValidString(input);
            if(isValidInput) {
                int cnt = urinal.urinalsCount(input);
                op.append(cnt+"\n");
            } else {
                op.append("-1"+"\n");
            }
        }
    }

    static boolean writeOutput(String op, File f) {
        try {
            FileWriter writer = new FileWriter(f);
            writer.write(op);
            writer.close();
            file_no++;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    static File createFile() {
        String path = "rule"+file_no+".txt";
        if(file_no == 0) {
            path = "rule.txt";
        }
        File f = new File(path);
        while(f.exists()) {
            file_no++;
            return createFile();
        }
        return f;
    }


    public static void main(String[] args) { // prints the available urinals count.
        Urinals u = new Urinals();
        System.out.println("Type `Terminal` (case sensitive) for terminal input and `File` (case sensitive) for file input ");
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        StringBuilder op =  new StringBuilder("");
        if(str.compareTo("Terminal")==0) {
            processTerminalInput(u, op);
        } else if(str.compareTo("File")==0) {
            try {
                System.out.println("You chose File input");
                openAndprocessDatFile(u, op);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if(!op.toString().isEmpty()) {
            System.out.println(u.writeOutput(op.toString(), u.createFile()));
        }
    }
}