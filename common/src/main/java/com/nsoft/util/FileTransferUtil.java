package com.nsoft.util;

import com.nsoft.ApplicationConfig;
import com.nsoft.exception.*;
import org.apache.commons.io.FileUtils;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.log4j.Logger;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.SocketException;
import java.util.Arrays;


public class FileTransferUtil {
    private static final Logger log = Logger.getLogger(FileTransferUtil.class);
    private static final ApplicationConfig applicationConfig = ApplicationConfig.getInstance();


    public static InputStream getFileViaFTP(String fileName, FTPClient ftpClient) {
        InputStream inputStream;
        try {
            inputStream = ftpClient.retrieveFileStream(fileName);
            if (inputStream == null){
                final String logMessage = "FTP retrieve file error : File not found : [" + fileName + "]";
                log.info(logMessage);
                throw new RequestedFileNotFoundInServerException(logMessage);
            }
        } catch (MalformedURLException ex) {
            log.error(ex.getMessage(), ex);
            throw new RequestedFileNotFoundInServerException();
        } catch (SocketException e) {
            log.error(e.getMessage(), e);
            throw new UnableToConnectToFtpServerException(e);
        } catch (BaseException e) {
            throw e;
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new UnknownSystemException(e);
        }
        return inputStream;
    }

    public static InputStream getFileViaFTP(String fileName, String ftpHost, String userName, String password, String destinationDirectory) {
        InputStream inputStream;
        try {
            FTPClient ftpClient = connectToFTPServer(ftpHost, userName, password, destinationDirectory);
            if (!fileExistsInServer(ftpClient, fileName)) {
                throw new RequestedFileNotFoundInServerException();
            }
            inputStream = ftpClient.retrieveFileStream(fileName);
            disconnectFTPServer(ftpClient);
        } catch (SocketException e) {
            log.error(e.getMessage(), e);
            throw new UnableToConnectToFtpServerException(e);
        } catch (BaseException e) {
            throw e;
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new UnknownSystemException(e);
        }
        return inputStream;

    }

    public static void sendFileViaFTP(File content, String destinationFileName, String ftpHost, String userName, String password, String destinationDirectory) {
        try {
            sendFile(content, destinationFileName, ftpHost, userName, password, destinationDirectory);
        } catch (IOException e) {
            throw new UnableToConnectToFtpServerException(e);
        } catch (BaseException e) {
            throw e;
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new UnknownSystemException(e);
        }

    }

    public static void sendBinaryFileViaFTP(File content, String destinationFileName, String ftpHost, String userName, String password, String destinationDirectory)  {
        try {
            sendBinaryFile(content, destinationFileName, ftpHost, userName, password, destinationDirectory);
        } catch (IOException e) {
            throw new UnableToConnectToFtpServerException(e);
        } catch (BaseException e) {
            throw e;
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new UnknownSystemException(e);
        }
    }

    private static void sendFile(File content, String destinationFileName, String ftpHost, String userName, String password, String destinationDirectory) throws IOException {
        FTPClient ftpClient = connectToFTPServer(ftpHost, userName, password, destinationDirectory);
        if (fileExistsInServer(ftpClient, destinationFileName)) {
            throw new DuplicatedFileInServerException();
        }
        FileInputStream fileInputStream = new FileInputStream(content);
        if (!ftpClient.storeFile(destinationFileName, fileInputStream)) {
            throw new FtpServerPermissionDeniedException();
        }
        disconnectFTPServer(ftpClient);

        fileInputStream.close();
    }

    private static void sendBinaryFile(File content, String destinationFileName, String ftpHost, String userName, String password, String destinationDirectory) throws IOException {
        FTPClient ftpClient = connectToFTPServer(ftpHost, userName, password, destinationDirectory);
        if (fileExistsInServer(ftpClient, destinationFileName)) {
            throw new DuplicatedFileInServerException();
        }
        FileInputStream fileInputStream = new FileInputStream(content);
        ftpClient.setFileType(FTPClient.BINARY_FILE_TYPE);
        if (!ftpClient.storeFile(destinationFileName, fileInputStream)) {
            throw new FtpServerPermissionDeniedException();
        }
        disconnectFTPServer(ftpClient);

        fileInputStream.close();
    }

    public static void sendFileViaFTP(String fileContent, String destinationFileName, String ftpHost, String userName, String password, String destinationDirectory) {
        String tempFileName = applicationConfig.getTempFilesPath() + System.getProperty("file.separator") + destinationFileName;
        File file = new File(tempFileName);
        try {
            FileUtils.writeStringToFile(file, fileContent, "UTF-8");
            try {
                sendFile(file, destinationFileName, ftpHost, userName, password, destinationDirectory);
            } catch (IOException ex) {
                log.info("Unable to connect to ftp server ...");
                log.info(ex);
                log.info("Retrying to establish connection to ftp server ...");
                sendFile(file, destinationFileName, ftpHost, userName, password, destinationDirectory);
            }
        } catch (IOException e) {
            throw new UnableToConnectToFtpServerException(e);
        } catch (BaseException e) {
            throw e;
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new UnknownSystemException(e);
        } finally {
            boolean delete = file.delete();
            if (!delete) {
                file.deleteOnExit();
            }
        }
    }

    private static void disconnectFTPServer(FTPClient ftpClient) throws IOException {
        if (ftpClient != null) {
            ftpClient.logout();
            ftpClient.disconnect();
        }
    }

    public static FTPClient connectToFTPServer(String ftpHost, String userName, String password, String destinationDirectory) throws IOException {
        FTPClient ftpClient = new FTPClient();
        ftpClient.setConnectTimeout(10000);
        ftpClient.connect(ftpHost);
        ftpClient.enterLocalPassiveMode();
        boolean ftpLoginResult = ftpClient.login(userName, password);
        if (!ftpLoginResult) {
            final String logMessage = "Error connecting to ftpServer. ftpHost : ["
                    + ftpHost + "], destinationDirectory : [" + destinationDirectory;
            log.error(logMessage);
        }

        if (Empty.isNotEmpty(destinationDirectory)) {
            ftpClient.changeWorkingDirectory(destinationDirectory);
        }
        return ftpClient;
    }

    private static boolean fileExistsInServer(FTPClient ftpClient, String fileName) throws IOException {
        String[] fileNames = ftpClient.listNames();
        return Empty.isNotEmpty(fileNames) && Arrays.asList(fileNames).contains(fileName);
    }
}