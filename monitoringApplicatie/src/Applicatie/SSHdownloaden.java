package Applicatie;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;
import java.io.*;

public class SSHdownloaden {

    public static class SFTPinJava {
        public SFTPinJava() {
            super();
        }
    }

    public static void downloadLinuxServer1() {
        SFTPinJava sftPinJava = new SFTPinJava();

        String SFTPHOST = "192.168.2.100"; // IP van de host
        int SFTPPORT = 22; // poort waarmee je wilt verbinden
        String SFTPUSER = "student"; // username van het apparaat
        String SFTPPASS = "LinuxProjectL4!"; // wachtwoord van het apparaat
        String SFTPWORKINGDIR = "/home/student/Documents/logLinuxServer1"; // de directory waarin er gewerkt moet worden

        Session session = null;
        Channel channel = null;
        ChannelSftp channelSftp = null;

        try {
            JSch jsch = new JSch(); // maakt nieuwe JSCH sessie aan
            session = jsch.getSession(SFTPUSER, SFTPHOST, SFTPPORT); // maakt een sessie aan met de username, IP en poort
            session.setPassword(SFTPPASS); // voert wachtwoord in
            java.util.Properties config = new java.util.Properties();
            config.put("StrictHostKeyChecking", "no");
            session.setConfig(config);
            session.connect(); // connect met de server
            channel = session.openChannel("sftp"); // opent sftp channel voor het downloaden van gegevens
            channel.connect();
            channelSftp = (ChannelSftp) channel;
            channelSftp.cd(SFTPWORKINGDIR); // directory instellen
            byte[] buffer = new byte[1024];

            BufferedInputStream bis = new BufferedInputStream(channelSftp.get("CPUlog.txt")); // selecteerd de CPUlog.txt om deze de dowloaden
            BufferedInputStream bis1 = new BufferedInputStream(channelSftp.get("MEMORYlog.txt"));
            BufferedInputStream bis2 = new BufferedInputStream(channelSftp.get("DISKlog.txt"));

            File newFile = new File("C:/Users/Student/Documents/Master/monitoringApplicatie/logLinuxServer1/CPULinuxServer1.txt"); // kiest een bestand waar de gegevens in worden gezet
            File newFile1 = new File("C:/Users/Student/Documents/Master/monitoringApplicatie/logLinuxServer1/MEMORYLinuxServer1.txt");
            File newFile2 = new File("C:/Users/Student/Documents/Master/monitoringApplicatie/logLinuxServer1/DISKLinuxServer1.txt");

            OutputStream os = new FileOutputStream(newFile); // output gaat in de nieuwe file
            OutputStream os1 = new FileOutputStream(newFile1);
            OutputStream os2 = new FileOutputStream(newFile2);
            BufferedOutputStream bos = new BufferedOutputStream(os);
            BufferedOutputStream bos1 = new BufferedOutputStream(os1);
            BufferedOutputStream bos2 = new BufferedOutputStream(os2);

            int readCount;

            while ((readCount = bis.read(buffer)) > 0) { //overwrite de lokale bestanden
                System.out.println("Writing: ");
                bos.write(buffer, 0, readCount);
            }

            while ((readCount = bis1.read(buffer)) > 0) {
                System.out.println("Writing: ");
                bos1.write(buffer, 0, readCount);
            }

            while ((readCount = bis2.read(buffer)) > 0) {
                System.out.println("Writing: ");
                bos2.write(buffer, 0, readCount);
            }

            bis.close(); // zet alle streams dicht
            bis1.close();
            bis2.close();
            bos.close();
            bos1.close();
            bos2.close();
        } catch (
                Exception ex) {
            ex.printStackTrace();
        }
        session.disconnect(); // disconnect van de SSH sessie
        channel.disconnect();
    }

    public static void downloadLinuxServer2() {
        SFTPinJava sftPinJava = new SFTPinJava();

        String SFTPHOST = "192.168.2.101";
        int SFTPPORT = 22;
        String SFTPUSER = "student";
        String SFTPPASS = "LinuxProjectL4!";
        String SFTPWORKINGDIR = "/home/student/Documents/logLinuxServer2";

        Session session = null;
        Channel channel = null;
        ChannelSftp channelSftp = null;

        try {
            JSch jsch = new JSch();
            session = jsch.getSession(SFTPUSER, SFTPHOST, SFTPPORT);
            session.setPassword(SFTPPASS);
            java.util.Properties config = new java.util.Properties();
            config.put("StrictHostKeyChecking", "no");
            session.setConfig(config);
            session.connect();
            channel = session.openChannel("sftp");
            channel.connect();
            channelSftp = (ChannelSftp) channel;
            channelSftp.cd(SFTPWORKINGDIR);
            byte[] buffer = new byte[1024];

            BufferedInputStream bis = new BufferedInputStream(channelSftp.get("CPUlog.txt"));
            //BufferedInputStream bis1 = new BufferedInputStream(channelSftp.get("MEMORYlog.txt"));
            BufferedInputStream bis2 = new BufferedInputStream(channelSftp.get("DISKlog.txt"));

            File newFile = new File("C:/Users/Student/Documents/Master/monitoringApplicatie/logLinuxServer2/CPULinuxServer2.txt");
            //File newFile1 = new File("C:/Users/Student/Documents/Master/monitoringApplicatie/logLinuxServer2/MEMORYLinuxServer2.txt");
            File newFile2 = new File("C:/Users/Student/Documents/Master/monitoringApplicatie/logLinuxServer2/DISKLinuxServer2.txt");

            OutputStream os = new FileOutputStream(newFile);
            //OutputStream os1 = new FileOutputStream(newFile1);
            OutputStream os2 = new FileOutputStream(newFile2);
            BufferedOutputStream bos = new BufferedOutputStream(os);
            //BufferedOutputStream bos1 = new BufferedOutputStream(os1);
            BufferedOutputStream bos2 = new BufferedOutputStream(os2);

            int readCount;

            while ((readCount = bis.read(buffer)) > 0) {
                System.out.println("Writing: ");
                bos.write(buffer, 0, readCount);
            }
/*
            while ((readCount = bis1.read(buffer)) > 0) {
                System.out.println("Writing: ");
                bos1.write(buffer, 0, readCount);
            }

 */
            while ((readCount = bis2.read(buffer)) > 0) {
                System.out.println("Writing: ");
                bos2.write(buffer, 0, readCount);
            }

            bis.close();
            //bis1.close();
            bis2.close();
            bos.close();
            //bos1.close();
            bos2.close();
        } catch (
                Exception ex) {
            ex.printStackTrace();
        }
        session.disconnect();
        channel.disconnect();
    }

    public static void downloadWindowsServer1() {
        SFTPinJava sftPinJava = new SFTPinJava();

        String SFTPHOST = "192.168.1.106";
        int SFTPPORT = 22;
        String SFTPUSER = "Administrator";
        String SFTPPASS = "WindowsProjectL4!";
        String SFTPWORKINGDIR = "Documents/logWindowsServer1";

        Session session = null;
        Channel channel = null;
        ChannelSftp channelSftp = null;

        try {
            JSch jsch = new JSch();
            session = jsch.getSession(SFTPUSER, SFTPHOST, SFTPPORT);
            session.setPassword(SFTPPASS);
            java.util.Properties config = new java.util.Properties();
            config.put("StrictHostKeyChecking", "no");
            session.setConfig(config);
            session.connect();
            channel = session.openChannel("sftp");
            channel.connect();
            channelSftp = (ChannelSftp) channel;
            channelSftp.cd(SFTPWORKINGDIR);
            byte[] buffer = new byte[1024];

            BufferedInputStream bis = new BufferedInputStream(channelSftp.get("CPUlog.txt"));
            BufferedInputStream bis2 = new BufferedInputStream(channelSftp.get("DISKlog.txt"));

            File newFile = new File("C:/Users/Student/Documents/Master/monitoringApplicatie/logWindowsServer1/CPUWindowsServer1.txt");
            File newFile2 = new File("C:/Users/Student/Documents/Master/monitoringApplicatie/logWindowsServer1/DISKWindowsServer1.txt");

            OutputStream os = new FileOutputStream(newFile);
            OutputStream os2 = new FileOutputStream(newFile2);
            BufferedOutputStream bos = new BufferedOutputStream(os);
            BufferedOutputStream bos2 = new BufferedOutputStream(os2);

            int readCount;

            while ((readCount = bis.read(buffer)) > 0) {
                System.out.println("Writing: ");
                bos.write(buffer, 0, readCount);
            }


            while ((readCount = bis2.read(buffer)) > 0) {
                System.out.println("Writing: ");
                bos2.write(buffer, 0, readCount);
            }

            bis.close();
            bis2.close();
            bos.close();
            bos2.close();
        } catch (
                Exception ex) {
            ex.printStackTrace();
        }
        session.disconnect();
        channel.disconnect();
    }

    public static void downloadWindowsServer2() {
        SFTPinJava sftPinJava = new SFTPinJava();

        String SFTPHOST = "192.168.1.107";
        int SFTPPORT = 22;
        String SFTPUSER = "Administrator";
        String SFTPPASS = "WindowsProjectL4!";
        String SFTPWORKINGDIR = "Documents/logWindowsServer2";

        Session session = null;
        Channel channel = null;
        ChannelSftp channelSftp = null;

        try {
            JSch jsch = new JSch();
            session = jsch.getSession(SFTPUSER, SFTPHOST, SFTPPORT);
            session.setPassword(SFTPPASS);
            java.util.Properties config = new java.util.Properties();
            config.put("StrictHostKeyChecking", "no");
            session.setConfig(config);
            session.connect();
            channel = session.openChannel("sftp");
            channel.connect();
            channelSftp = (ChannelSftp) channel;
            channelSftp.cd(SFTPWORKINGDIR);
            byte[] buffer = new byte[1024];

            BufferedInputStream bis = new BufferedInputStream(channelSftp.get("CPUlog.txt"));
           // BufferedInputStream bis1 = new BufferedInputStream(channelSftp.get("MEMORYlog.txt"));
            BufferedInputStream bis2 = new BufferedInputStream(channelSftp.get("DISKlog.txt"));

            File newFile = new File("C:/Users/Student/Documents/Master/monitoringApplicatie/logWindowsServer2/CPUWindowsServer2.txt");
           // File newFile1 = new File("C:/Users/Student/Documents/Github/KBS2D-master/monitoringApplicatie/logWindowsServer2/MEMORYWindowsServer2.txt");
            File newFile2 = new File("C:/Users/Student/Documents/Master/monitoringApplicatie/logWindowsServer2/DISKWindowsServer2.txt");

            OutputStream os = new FileOutputStream(newFile);
           // OutputStream os1 = new FileOutputStream(newFile1);
            OutputStream os2 = new FileOutputStream(newFile2);
            BufferedOutputStream bos = new BufferedOutputStream(os);
           // BufferedOutputStream bos1 = new BufferedOutputStream(os1);
            BufferedOutputStream bos2 = new BufferedOutputStream(os2);

            int readCount;

            while ((readCount = bis.read(buffer)) > 0) {
                System.out.println("Writing: ");
                bos.write(buffer, 0, readCount);
            }

          //  while ((readCount = bis1.read(buffer)) > 0) {
          //      System.out.println("Writing: ");
          //      bos1.write(buffer, 0, readCount);
          //  }

            while ((readCount = bis2.read(buffer)) > 0) {
                System.out.println("Writing: ");
                bos2.write(buffer, 0, readCount);
            }

            bis.close();
           // bis1.close();
            bis2.close();
            bos.close();
           // bos1.close();
            bos2.close();
        } catch (
                Exception ex) {
            ex.printStackTrace();
        }
        session.disconnect();
        channel.disconnect();
        channelSftp.disconnect();
    }

}
