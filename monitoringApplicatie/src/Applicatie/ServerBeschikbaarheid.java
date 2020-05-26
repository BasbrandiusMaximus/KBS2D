package Applicatie;

import java.io.*;

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


    public static String getCPUprocentLinux1() throws IOException {        //deze methode scant het tekstbestand en onthoudt de laatste waarde daarin
        String output = "";
        String url = "monitoringApplicatie/logLinuxServer1/CPULinuxServer1.txt";
        File path = new File(url);
        File CPULinux1 = new File(path.getAbsolutePath());
        BufferedReader reader = new BufferedReader(new FileReader(CPULinux1));
        String line = reader.readLine();
        while (line != null) {
            output = line;
            line = reader.readLine();
        }
        reader.close();
        return output;
    }

    public static String getDISKprocentLinux1() throws IOException {
        String output = "";
        String url = "monitoringApplicatie/logLinuxServer1/DISKLinuxServer1.txt";
        File path = new File(url);
        File DISKLinux1 = new File(path.getAbsolutePath());
        BufferedReader reader = new BufferedReader(new FileReader(DISKLinux1));
        String line = reader.readLine();
        while (line != null) {
            output = line;
            line = reader.readLine();
        }
        reader.close();
        return output;
    }

    public static String getMEMprocentLinux1() throws IOException {
        String output = "";
        String url = "monitoringApplicatie/logLinuxServer1/MEMORYLinuxServer1.txt";
        File path = new File(url);
        File MEMLinux1 = new File(path.getAbsolutePath());
        BufferedReader reader = new BufferedReader(new FileReader(MEMLinux1));
        String line = reader.readLine();
        while (line != null) {
            output = line;
            line = reader.readLine();
        }
        reader.close();
        return output;
    }

    public static String getCPUprocentLinux2() throws IOException {
        String output = "";
        String url = "monitoringApplicatie/logLinuxServer2/CPULinuxServer2.txt";
        File path = new File(url);
        File CPULinux2 = new File(path.getAbsolutePath());
        BufferedReader reader = new BufferedReader(new FileReader(CPULinux2));
        String line = reader.readLine();
        while (line != null) {
            output = line;
            line = reader.readLine();
        }
        reader.close();
        return output;
    }

    public static String getDISKprocentLinux2() throws IOException {
        String output = "";
        String url = "monitoringApplicatie/logLinuxServer2/DiskLinuxServer2.txt";
        File path = new File(url);
        File DISKLinux2 = new File(path.getAbsolutePath());
        BufferedReader reader = new BufferedReader(new FileReader(DISKLinux2));
        String line = reader.readLine();
        while (line != null) {
            output = line;
            line = reader.readLine();
        }
        reader.close();
        return output;
    }

    public static String getMEMprocentLinux2() throws IOException {
        String output = "";
        String url = "monitoringApplicatie/logLinuxServer2/MEMORYLinuxServer2.txt";
        File path = new File(url);
        File CPULinux1 = new File(path.getAbsolutePath());
        BufferedReader reader = new BufferedReader(new FileReader(CPULinux1));
        String line = reader.readLine();
        while (line != null) {
            output = line;
            line = reader.readLine();
        }
        reader.close();
        return output;
    }

    public static String getCPUprocentWindows1() throws IOException {
        String output = "";
        String url = "monitoringApplicatie/logWindowsServer1/CPUWindowsServer1.txt";
        File path = new File(url);
        File CPUWindows1 = new File(path.getAbsolutePath());
        BufferedReader reader = new BufferedReader(new FileReader(CPUWindows1));
        String line = reader.readLine();
        while (line != null ) {
            output = line;
            line = reader.readLine();
        }
        reader.close();
        return output;
    }

    public static String getDISKprocentWindows1() throws IOException {
        String output = "";
        String url = "monitoringApplicatie/logWindowsServer1/DISKWindowsServer1.txt";
        File path = new File(url);
        File DISKWindows1 = new File(path.getAbsolutePath());
        BufferedReader reader = new BufferedReader(new FileReader(DISKWindows1));
        String line = reader.readLine();
        while (line != null) {
            output = line;
            line = reader.readLine();
        }
        reader.close();
        return output;
    }

    public static String getMEMprocentWindows1() throws IOException {
        String output = "";
        String url = "monitoringApplicatie/logWindowsServer1/MEMORYWindowsServer1.txt";
        File path = new File(url);
        File MEMWindows1 = new File(path.getAbsolutePath());
        BufferedReader reader = new BufferedReader(new FileReader(MEMWindows1));
        String line = reader.readLine();
        while (line != null ) {
            output = line;
            line = reader.readLine();
        }
        reader.close();
        return output;
    }

    public static String getCPUprocentWindows2() throws IOException {
            String output = "";
            String url = "monitoringApplicatie/logWindowsServer2/CPUWindowsServer2.txt";
            File path = new File(url);
            File CPUWindows2 = new File(path.getAbsolutePath());
            BufferedReader reader = new BufferedReader(new FileReader(CPUWindows2));
            String line = reader.readLine();
            while (line != null ) {
                output = line;
                line = reader.readLine();
            }
            reader.close();
            return output;
    }

    public static String getDISKprocentWindows2() throws IOException {
        String output = "";
        String url = "monitoringApplicatie/logWindowsServer2/DISKWindowsServer2.txt";
        File path = new File(url);
        File CPUWindows2 = new File(path.getAbsolutePath());
        BufferedReader reader = new BufferedReader(new FileReader(CPUWindows2));
        String line = reader.readLine();
        while (line != null ) {
            output = line;
            line = reader.readLine();
        }
        reader.close();
        output = output.replace("C: ", "");
        return output;
    }

    public static String getMEMprocentWindows2() throws IOException {
        String output = "";
        String url = "monitoringApplicatie/logWindowsServer2/MEMORYWindowsServer2.txt";
        File path = new File(url);
        File MEMWindows2 = new File(path.getAbsolutePath());
        BufferedReader reader = new BufferedReader(new FileReader(MEMWindows2));
        String line = reader.readLine();
        while (line != null) {
            output = line;
            line = reader.readLine();
        }
        reader.close();
        return output;
    }

    public static String getCPUprocentPfSense() throws IOException {
        String output = "";
        String url = "monitoringApplicatie/logPfSense/CPUPfSense.txt";
        File path = new File(url);
        File CPUPfSense = new File(path.getAbsolutePath());
        BufferedReader reader = new BufferedReader(new FileReader(CPUPfSense));
        String line = reader.readLine();
        while (line != null) {
            output = line;
            line = reader.readLine();
        }
        reader.close();
        return output;
    }

    public static String getDISKprocentPfSense() throws IOException {
        String output = "";
        String url = "monitoringApplicatie/logPfSense/DISKPfSense.txt";
        File path = new File(url);
        File DISKPfSense = new File(path.getAbsolutePath());
        BufferedReader reader = new BufferedReader(new FileReader(DISKPfSense));
        String line = reader.readLine();
        while (line != null) {
            output = line;
            line = reader.readLine();
        }
        reader.close();
        return output;
    }

    public static String getMEMprocentPfSense() throws IOException {
        String output = "";
        String url = "monitoringApplicatie/logPfSense/MEMPfSense.txt";
        File path = new File(url);
        File MEMPfSense = new File(path.getAbsolutePath());
        BufferedReader reader = new BufferedReader(new FileReader(MEMPfSense));
        String line = reader.readLine();
        while (line != null) {
            output = line;
            line = reader.readLine();
        }
        reader.close();
        return output;
    }

}
