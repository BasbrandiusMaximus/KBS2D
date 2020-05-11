package Applicatie;

import java.io.*;
import java.util.Scanner;

public class ServerBeschikbaarheid {

    private static int CPUprocent;
    private static int MEMprocent;
    private static int DISKprocent;


    public static int getCPUprocent() throws FileNotFoundException {
        File cputest = new File("./cputest.txt");
        Scanner scanner = new Scanner(cputest);
        while (scanner.hasNextInt()) {
            CPUprocent = (scanner.nextInt());
        }
        return CPUprocent;
    }

    public static int getDISKprocent() throws FileNotFoundException {
        File disktest = new File("./disktest.txt");
        Scanner scanner = new Scanner(disktest);
        while (scanner.hasNextInt()) {
            DISKprocent = (scanner.nextInt());
        }
        return DISKprocent;
    }

    public static int getMEMprocent() throws FileNotFoundException {
        File memtest = new File("./memtest.txt");
        Scanner scanner = new Scanner(memtest);
        while (scanner.hasNextInt()) {
            MEMprocent = (scanner.nextInt());
        }
        return MEMprocent;
    }
}
