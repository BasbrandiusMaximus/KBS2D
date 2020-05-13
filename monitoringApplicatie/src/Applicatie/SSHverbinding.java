package Applicatie;

import com.jcraft.jsch.*;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * @author World
 */
public class SSHverbinding {

    public static void main(String args[]) {
        String user = "student";
        String password = "LinuxProjectL4!";
        String host = "192.168.1.102";
        int port = 22;
        String remoteFile = "/home/student/Documents/log.txt";

        try {
            JSch jsch = new JSch();
            Session session = jsch.getSession(user, host, port);
            session.setPassword(password);
            session.setConfig("StrictHostKeyChecking", "no");
            System.out.println("Establishing Connection...");
            session.connect();
            System.out.println("Connection established.");
            System.out.println("Crating SFTP Channel.");
            ChannelSftp sftpChannel = (ChannelSftp) session.openChannel("sftp");
            sftpChannel.connect();
            System.out.println("SFTP Channel created.");

            InputStream inputStream = sftpChannel.get(remoteFile);

            try (Scanner scanner = new Scanner(new InputStreamReader(inputStream))) {
                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    System.out.println(line);
                }
            }

            sftpChannel.quit();

        } catch (JSchException | SftpException e) {
            e.printStackTrace();
        }

    }
}