package com.nsoft.util;

import java.io.*;
import java.nio.charset.Charset;
import java.util.Collection;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import com.nsoft.exception.UnknownSystemException;
import org.apache.commons.io.IOUtils;
import org.apache.log4j.Logger;


public class FileUtil {
    private final static Logger log = Logger.getLogger(FileUtil.class);
    public static File createFileFromInputStream(InputStream inputStream, String fileName, String filePath){
        File rootDirectory = new File(filePath);
        if(!rootDirectory.exists()){
            rootDirectory.mkdirs();
        }

        String fileFullPath = filePath + System.getProperty("file.separator") + fileName;
        File file = new File(fileFullPath);
        OutputStream outputStream = null;
        try {
            file.createNewFile();
            outputStream = new FileOutputStream(file);
            int read = 0;
            byte[] bytes = new byte[1024];

            while ((read = inputStream.read(bytes)) != -1) {
                outputStream.write(bytes, 0, read);
            }
        } catch (Exception e) {
            throw new UnknownSystemException(e);
        } finally {
            try {
                if (outputStream != null) {
                    outputStream.flush();
                }
            } catch (Exception ex) {
                log.error(ex.getMessage(), ex);
            }
            try {
                if (outputStream != null) {
                    outputStream.close();
                }
            } catch (Exception ex) {
                log.error(ex.getMessage(), ex);
            }
            try {
                inputStream.close();
            } catch (Exception ex) {
                log.error(ex.getMessage(), ex);
            }
        }


        return file;
    }

    public static void deleteFiles(Collection<File> values, boolean deleteOnExit) {
        for (File file : values) {
            if (deleteOnExit) {
                file.deleteOnExit();
            } else {
                boolean delete = file.delete();
                if(!delete){
                    file.deleteOnExit();
                }
            }
        }
    }


    public static ByteArrayInputStream getByteArrayUTF8WithBOM(String content){
        try {
            byte[] bom = {(byte) 239, (byte) 187, (byte) 191};
            byte[] utf8s = content.getBytes(Charset.forName("UTF8"));
            byte[] finalArray = new byte[bom.length + utf8s.length];
            System.arraycopy(bom, 0, finalArray, 0 , bom.length);
            System.arraycopy(utf8s, 0, finalArray, bom.length , utf8s.length);
            return new ByteArrayInputStream(finalArray);
        } catch (Exception e) {
            throw new UnknownSystemException(e);
        }
    }

    public static File compressFilesToZip (File[] files , String zipFilePath, String zipFileName) {

        File rootDirectory = new File(zipFilePath);
        if(!rootDirectory.exists()){
            rootDirectory.mkdirs();
        }

        String fileFullPath = zipFilePath + System.getProperty("file.separator") + zipFileName + ".zip";

        File zippedFile = new File(fileFullPath);
        ZipOutputStream outputStream = null;

        try {

            outputStream = new ZipOutputStream(new FileOutputStream(zippedFile));

            for (File file : files) {
                byte[] buffer = new byte[10 * 1024];
                ZipEntry zipEntry = new ZipEntry(file.getName());
                outputStream.putNextEntry(zipEntry);
                FileInputStream inputStream = new FileInputStream(file.getPath());
                int i;
                while ((i = inputStream.read(buffer, 0, buffer.length)) != -1) {
                    outputStream.write(buffer, 0 , buffer.length);
                }
                inputStream.close();
                outputStream.flush();
                outputStream.closeEntry();
            }



        } catch (Exception e) {
            throw new UnknownSystemException(e);
        } finally {
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (Exception e) {
                    throw new UnknownSystemException(e);
                }
            }
        }
        return zippedFile;
    }

    public static String getFileContentInString(File file) {
        try {
            return IOUtils.toString(new FileInputStream(file),"UTF-8");
        } catch (Exception e) {
            throw new UnknownSystemException(e);
        }
    }

}
