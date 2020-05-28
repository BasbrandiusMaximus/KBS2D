package Applicatie;

import java.io.*;

public class ServerBeschikbaarheid {

    public static String getCPUprocentLinux1() throws IOException {        //deze methode scant het tekstbestand en onthoudt de laatste waarde daarin die hij dan als output geeft
        String output = "";
        String url = "monitoringApplicatie/logLinuxServer1/CPULinuxServer1.txt"; // path naar het bestand dat nodig is
        File path = new File(url);
        File CPULinux1 = new File(path.getAbsolutePath()); // het hele pad verkrijgen
        BufferedReader reader = new BufferedReader(new FileReader(CPULinux1)); // nieuwe reader maken
        String line = reader.readLine();
        try {
            while (line != null) { // als er een line is dan gaat deze loop verder
                output = line; // de lijn wordt de nieuwe output
                line = reader.readLine(); // de reader gaat door naar de volgende lijn
            }
            output = output.trim(); // eventuele spaties worden weggewerkt voor een betere display in de GUI
            reader.close(); // de reader wordt gesloten
            return output;

        } catch (IOException e) {
            return "IO error";

        } finally {
            PrintWriter writer = new PrintWriter(url);
            writer.flush(); // de printwriter haalt het document leeg zodat wanneer de servers uitvallen deze als niet beschikbaar worden aangegeven
            writer.close();
        }
    }

    public static String getDISKprocentLinux1() throws IOException {
        String output = "";
        String url = "monitoringApplicatie/logLinuxServer1/DISKLinuxServer1.txt";
        File path = new File(url);
        File DISKLinux1 = new File(path.getAbsolutePath());
        BufferedReader reader = new BufferedReader(new FileReader(DISKLinux1));
        String line = reader.readLine();
        try {
            while (line != null) {
                output = line;
                line = reader.readLine();
            }
            output = output.trim();
            reader.close();
            return output;

        } catch (IOException e) {
            return "IO error";

        } finally {
            PrintWriter writer = new PrintWriter(url);
            writer.flush();
            writer.close();
        }
    }


    public static String getCPUprocentLinux2() throws IOException {
        String output = "";
        String url = "monitoringApplicatie/logLinuxServer2/CPULinuxServer2.txt";
        File path = new File(url);
        File CPULinux2 = new File(path.getAbsolutePath());
        BufferedReader reader = new BufferedReader(new FileReader(CPULinux2));
        String line = reader.readLine();
        try {
            while (line != null) {
                output = line;
                line = reader.readLine();
            }
            output = output.trim();
            reader.close();
            return output;

        } catch (IOException e) {
            return "IO error";

        } finally {
            PrintWriter writer = new PrintWriter(url);
            writer.flush();
            writer.close();
        }
    }

    public static String getDISKprocentLinux2() throws IOException {
        String output = "";
        String url = "monitoringApplicatie/logLinuxServer2/DISKLinuxServer2.txt";
        File path = new File(url);
        File DISKLinux2 = new File(path.getAbsolutePath());
        BufferedReader reader = new BufferedReader(new FileReader(DISKLinux2));
        String line = reader.readLine();
        try {
            while (line != null) {
                output = line;
                line = reader.readLine();
            }
            output = output.trim();
            reader.close();
            return output;

        } catch (IOException e) {
            return "IO error";

        } finally {
            PrintWriter writer = new PrintWriter(url);
            writer.flush();
            writer.close();
        }
    }


    public static String getCPUprocentWindows1() throws IOException {
        String output = "";
        String url = "monitoringApplicatie/logWindowsServer1/CPUWindowsServer1.txt";
        File path = new File(url);
        File CPUWindows1 = new File(path.getAbsolutePath());
        BufferedReader reader = new BufferedReader(new FileReader(CPUWindows1));
        String line = reader.readLine();
        try {
            while (line != null) {
                output += line;
                line = reader.readLine();
            }
            output = output.replaceAll("LoadPercentage", "");
            output = output.trim();
            reader.close();
            return output;

        } catch (IOException e) {
            return "IO error";

        } finally {
            PrintWriter writer = new PrintWriter(url);
            writer.flush();
            writer.close();
        }
    }

    public static String getDISKprocentWindows1() throws IOException {
        String output = "";
        String url = "monitoringApplicatie/logWindowsServer1/DISKWindowsServer1.txt";
        File path = new File(url);
        File DISKWindows1 = new File(path.getAbsolutePath());
        BufferedReader reader = new BufferedReader(new FileReader(DISKWindows1));
        String line = reader.readLine();
        try {
            while (line != null) {
                output += line;
                line = reader.readLine();
            }
            output = output.replaceAll("C", "");
            output = output.replaceAll(":", "");
            output = output.replaceAll("DeviceID", "");
            output = output.replaceAll("FreeSpace", "");
            output = output.trim();
            reader.close();
            return output;

        } catch (IOException e) {
            return "IO error";

        } finally {
            PrintWriter writer = new PrintWriter(url);
            writer.flush();
            writer.close();
        }
    }


    public static String getCPUprocentWindows2() throws IOException {
            String output = "";
            String url = "monitoringApplicatie/logWindowsServer2/CPUWindowsServer2.txt";
            File path = new File(url);
            File CPUWindows2 = new File(path.getAbsolutePath());
            BufferedReader reader = new BufferedReader(new FileReader(CPUWindows2));
            String line = reader.readLine();
            try {
            while (line != null) {
                output += line;
                line = reader.readLine();
            }
            output = output.replaceAll("LoadPercentage", "");
            output = output.trim();
            reader.close();
            return output;

        } catch (IOException e) {
            return "IO error";

        } finally {
            PrintWriter writer = new PrintWriter(url);
            writer.flush();
            writer.close();
        }
    }

    public static String getDISKprocentWindows2() throws IOException {
        String output = "";
        String url = "monitoringApplicatie/logWindowsServer2/DISKWindowsServer2.txt";
        File path = new File(url);
        File CPUWindows2 = new File(path.getAbsolutePath());
        BufferedReader reader = new BufferedReader(new FileReader(CPUWindows2));
        String line = reader.readLine();
        try {
            while (line != null) {
                output += line;
                line = reader.readLine();
            }
            output = output.replaceAll("C", "");
            output = output.replaceAll(":", "");
            output = output.replaceAll("DeviceID", "");
            output = output.replaceAll("FreeSpace", "");
            output = output.trim();
            reader.close();
            return output;

        } catch (IOException e) {
            return "IO error";

        } finally {
            PrintWriter writer = new PrintWriter(url);
            writer.flush();
            writer.close();
        }
    }


}
