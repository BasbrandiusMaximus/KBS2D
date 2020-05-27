package Applicatie;

import com.sun.source.tree.WhileLoopTree;

import java.io.*;

public class ReplaceText {

    static void modifyFile(String filePath, String oldString, String newString) {
        File fileToBeModified = new File(filePath);
        String oldContent = "";
        BufferedReader reader = null;
        FileWriter writer = null;

        try {
            reader = new BufferedReader(new FileReader(fileToBeModified));

            String line = reader.readLine();

            while (line != null) {
                oldContent = oldContent + line + System.lineSeparator();
                line = reader.readLine();
            }

            String newContent = oldContent.replaceAll(oldString, newString);

            writer = new FileWriter(fileToBeModified);
            writer.write(newContent);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                reader.close();
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {

        modifyFile("monitoringApplicatie/logWindowsServer2/DISKWindowsServer2.txt", "��", "");
        modifyFile("monitoringApplicatie/logWindowsServer2/DISKWindowsServer2.txt", "DeviceID  FreeSpace    \n" + "C:       ", "");
        System.out.println("done");
    }
}
