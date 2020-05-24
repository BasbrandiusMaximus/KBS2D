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

        String SFTPHOST = "192.168.2.100";
        int SFTPPORT = 22;
        String SFTPUSER = "student";
        String SFTPPASS = "LinuxProjectL4!";
        String SFTPWORKINGDIR = "/home/student/Documents/logLinuxServer1";

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
            BufferedInputStream bis1 = new BufferedInputStream(channelSftp.get("MEMORYlog.txt"));
            BufferedInputStream bis2 = new BufferedInputStream(channelSftp.get("DISKlog.txt"));

            File newFile = new File("C:/Users/Student/Documents/Github/KBS2D-master/monitoringApplicatie/logLinuxServer1/CPULinuxServer1.txt");
            File newFile1 = new File("C:/Users/Student/Documents/Github/KBS2D-master/monitoringApplicatie/logLinuxServer1/MEMORYLinuxServer1.txt");
            File newFile2 = new File("C:/Users/Student/Documents/Github/KBS2D-master/monitoringApplicatie/logLinuxServer1/DISKLinuxServer1.txt");

            OutputStream os = new FileOutputStream(newFile);
            OutputStream os1 = new FileOutputStream(newFile1);
            OutputStream os2 = new FileOutputStream(newFile2);
            BufferedOutputStream bos = new BufferedOutputStream(os);
            BufferedOutputStream bos1 = new BufferedOutputStream(os1);
            BufferedOutputStream bos2 = new BufferedOutputStream(os2);

            int readCount;

            while ((readCount = bis.read(buffer)) > 0) {
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

            bis.close();
            bis1.close();
            bis2.close();
            bos.close();
            bos1.close();
            bos2.close();
        } catch (
                Exception ex) {
            ex.printStackTrace();
        }
        session.disconnect();
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
            BufferedInputStream bis1 = new BufferedInputStream(channelSftp.get("MEMORYlog.txt"));
            BufferedInputStream bis2 = new BufferedInputStream(channelSftp.get("DISKlog.txt"));

            File newFile = new File("C:/Users/Student/Documents/Github/KBS2D-master/monitoringApplicatie/logLinuxServer2/CPULinuxServer2.txt");
            File newFile1 = new File("C:/Users/Student/Documents/Github/KBS2D-master/monitoringApplicatie/logLinuxServer2/MEMORYLinuxServer2.txt");
            File newFile2 = new File("C:/Users/Student/Documents/Github/KBS2D-master/monitoringApplicatie/logLinuxServer2/DISKLinuxServer2.txt");

            OutputStream os = new FileOutputStream(newFile);
            OutputStream os1 = new FileOutputStream(newFile1);
            OutputStream os2 = new FileOutputStream(newFile2);
            BufferedOutputStream bos = new BufferedOutputStream(os);
            BufferedOutputStream bos1 = new BufferedOutputStream(os1);
            BufferedOutputStream bos2 = new BufferedOutputStream(os2);

            int readCount;

            while ((readCount = bis.read(buffer)) > 0) {
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

            bis.close();
            bis1.close();
            bis2.close();
            bos.close();
            bos1.close();
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
            BufferedInputStream bis1 = new BufferedInputStream(channelSftp.get("MEMORYlog.txt"));
            BufferedInputStream bis2 = new BufferedInputStream(channelSftp.get("DISKlog.txt"));

            File newFile = new File("C:/Users/Student/Documents/Github/KBS2D-master/monitoringApplicatie/logWindowsServer1/CPUWindowsServer1.txt");
            File newFile1 = new File("C:/Users/Student/Documents/Github/KBS2D-master/monitoringApplicatie/logWindowsServer1/MEMORYWindowsServer1.txt");
            File newFile2 = new File("C:/Users/Student/Documents/Github/KBS2D-master/monitoringApplicatie/logWindowsServer1/DISKWindowsServer1.txt");

            OutputStream os = new FileOutputStream(newFile);
            OutputStream os1 = new FileOutputStream(newFile1);
            OutputStream os2 = new FileOutputStream(newFile2);
            BufferedOutputStream bos = new BufferedOutputStream(os);
            BufferedOutputStream bos1 = new BufferedOutputStream(os1);
            BufferedOutputStream bos2 = new BufferedOutputStream(os2);

            int readCount;

            while ((readCount = bis.read(buffer)) > 0) {
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

            bis.close();
            bis1.close();
            bis2.close();
            bos.close();
            bos1.close();
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

            File newFile = new File("C:/Users/Student/Documents/Github/KBS2D-master/monitoringApplicatie/logWindowsServer2/CPUWindowsServer2.txt");
           // File newFile1 = new File("C:/Users/Student/Documents/Github/KBS2D-master/monitoringApplicatie/logWindowsServer2/MEMORYWindowsServer2.txt");
            File newFile2 = new File("C:/Users/Student/Documents/Github/KBS2D-master/monitoringApplicatie/logWindowsServer2/DISKWindowsServer2.txt");

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

    public static void downloadPfSense() {
        SFTPinJava sftPinJava = new SFTPinJava();

        String SFTPHOST = "192.168.2.1";
        int SFTPPORT = 22;
        String SFTPUSER = "Student";
        String SFTPPASS = "ProjectL4!";
        String SFTPWORKINGDIR = "C:/Users/Student/Documents/logPfSense";

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
            BufferedInputStream bis1 = new BufferedInputStream(channelSftp.get("MEMORYlog.txt"));
            BufferedInputStream bis2 = new BufferedInputStream(channelSftp.get("DISKlog.txt"));

            File newFile = new File("C:/Users/Student/Documents/Github/KBS2D-master/monitoringApplicatie/logPfSense/CPUPfSense.txt");
            File newFile1 = new File("C:/Users/Student/Documents/Github/KBS2D-master/monitoringApplicatie/logPfSense/MEMORYPfSense.txt");
            File newFile2 = new File("C:/Users/Student/Documents/Github/KBS2D-master/monitoringApplicatie/logPfSense/DISKPfSense.txt");

            OutputStream os = new FileOutputStream(newFile);
            OutputStream os1 = new FileOutputStream(newFile1);
            OutputStream os2 = new FileOutputStream(newFile2);
            BufferedOutputStream bos = new BufferedOutputStream(os);
            BufferedOutputStream bos1 = new BufferedOutputStream(os1);
            BufferedOutputStream bos2 = new BufferedOutputStream(os2);

            int readCount;

            while ((readCount = bis.read(buffer)) > 0) {
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

            bis.close();
            bis1.close();
            bis2.close();
            bos.close();
            bos1.close();
            bos2.close();
        } catch (
                Exception ex) {
            ex.printStackTrace();
        }
        session.disconnect();
        channel.disconnect();
    }

}
