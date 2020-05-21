package Applicatie;

import java.io.*;
import java.util.Scanner;

public class ServerBeschikbaarheid {

    private static int CPUprocentLinux1;
    private static int MEMprocentLinux1;
    private static int DISKprocentLinux1;

    private static int CPUprocentLinux2;
    private static int MEMprocentLinux2;
    private static int DISKprocentLinux2;

    private static int CPUprocentWindows1;
    private static int MEMprocentWindows1;
    private static int DISKprocentWindows1;

    private static int CPUprocentWindows2;
    private static int MEMprocentWindows2;
    private static int DISKprocentWindows2;

    private static int CPUprocentPfSense;
    private static int MEMprocentPfSense;
    private static int DISKprocentPfSense;


    public static int getCPUprocentLinux1() throws FileNotFoundException {        //deze methode scant het tekstbestand en onthoudt de laatste waarde daarin
        File cputest = new File("./cputest.txt");
        Scanner scanner = new Scanner(cputest);
        while (scanner.hasNextInt()) {
            CPUprocentLinux1 = (scanner.nextInt());
        }
        return CPUprocentLinux1;
    }

    public static int getDISKprocentLinux1() throws FileNotFoundException {
        File disktest = new File("./disktest.txt");
        Scanner scanner = new Scanner(disktest);
        while (scanner.hasNextInt()) {
            DISKprocentLinux1 = (scanner.nextInt());
        }
        return DISKprocentLinux1;
    }

    public static int getMEMprocentLinux1() throws FileNotFoundException {
        File memtest = new File("./memtest.txt");
        Scanner scanner = new Scanner(memtest);
        while (scanner.hasNextInt()) {
            MEMprocentLinux1 = (scanner.nextInt());
        }
        return MEMprocentLinux1;
    }

    public static int getCPUprocentLinux2() throws FileNotFoundException {
        File CPULinux2 = new File("./cputest.txt");
        Scanner scanner = new Scanner(CPULinux2);
        while (scanner.hasNextInt()) {
            CPUprocentLinux2 = (scanner.nextInt());
        }
        return CPUprocentLinux2;
    }

    public static int getDISKprocentLinux2() throws FileNotFoundException {
        File DISKLinux2 = new File("./disktest.txt");
        Scanner scanner = new Scanner(DISKLinux2);
        while (scanner.hasNextInt()) {
            DISKprocentLinux2 = (scanner.nextInt());
        }
        return DISKprocentLinux2;
    }

    public static int getMEMprocentLinux2() throws FileNotFoundException {
        File MEMLinux2 = new File("./memtest.txt");
        Scanner scanner = new Scanner(MEMLinux2);
        while (scanner.hasNextInt()) {
            MEMprocentLinux2 = (scanner.nextInt());
        }
        return MEMprocentLinux2;
    }

    public static int getCPUprocentWindows1() throws FileNotFoundException {
        File CPUWindows1 = new File("./windowsCPUtest.txt");
        Scanner scanner = new Scanner(CPUWindows1);
        while (scanner.hasNextInt()) {
            CPUprocentWindows1 = (scanner.nextInt());
        }
        return CPUprocentWindows1;
    }

    public static int getDISKprocentWindows1() throws FileNotFoundException {
        File DISKWindows1 = new File("./windowsDISKtest.txt");
        Scanner scanner = new Scanner(DISKWindows1);
        while (scanner.hasNextDouble()) {
            DISKprocentWindows1 = (int) scanner.nextDouble();
        }
        return DISKprocentWindows1;
    }

    public static int getMEMprocentWindows1() throws FileNotFoundException {
        File MEMWindows1 = new File("./memtest.txt");
        Scanner scanner = new Scanner(MEMWindows1);
        while (scanner.hasNextInt()) {
            MEMprocentWindows1 = (scanner.nextInt());
        }
        return MEMprocentWindows1;
    }

    public static int getCPUprocentWindows2() throws FileNotFoundException {
        File CPUWindows2 = new File("./cputest.txt");
        Scanner scanner = new Scanner(CPUWindows2);
        while (scanner.hasNextInt()) {
            CPUprocentWindows2 = (scanner.nextInt());
        }
        return CPUprocentWindows2;
    }

    public static int getDISKprocentWindows2() throws FileNotFoundException {
        File DISKWindows2 = new File("./disktest.txt");
        Scanner scanner = new Scanner(DISKWindows2);
        while (scanner.hasNextInt()) {
            DISKprocentWindows2 = (scanner.nextInt());
        }
        return DISKprocentWindows2;
    }

    public static int getMEMprocentWindows2() throws FileNotFoundException {
        File MEMWindows2 = new File("./memtest.txt");
        Scanner scanner = new Scanner(MEMWindows2);
        while (scanner.hasNextInt()) {
            MEMprocentWindows2 = (scanner.nextInt());
        }
        return MEMprocentWindows2;
    }

    public static int getCPUprocentPfSense() throws FileNotFoundException {
        File CPUPfsense = new File("./cputest.txt");
        Scanner scanner = new Scanner(CPUPfsense);
        while (scanner.hasNextInt()) {
            CPUprocentPfSense = (scanner.nextInt());
        }
        return CPUprocentPfSense;
    }

    public static int getDISKprocentPfSense() throws FileNotFoundException {
        File DISKPfsense = new File("./disktest.txt");
        Scanner scanner = new Scanner(DISKPfsense);
        while (scanner.hasNextInt()) {
            DISKprocentPfSense = (scanner.nextInt());
        }
        return DISKprocentPfSense;
    }

    public static int getMEMprocentPfSense() throws FileNotFoundException {
        File MEMPfsense = new File("./memtest.txt");
        Scanner scanner = new Scanner(MEMPfsense);
        while (scanner.hasNextInt()) {
            MEMprocentPfSense = (scanner.nextInt());
        }
        return MEMprocentPfSense;
    }

}
