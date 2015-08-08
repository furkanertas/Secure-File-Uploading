package com.core;
import com.google.common.io.ByteStreams;
import com.google.common.io.Files;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.http.HttpServletRequest;
import javax.xml.bind.DatatypeConverter;
import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Random;

/**
 * Created by Furkan on 8.8.2015.
 */
public class Upload {
    private static final String UPLOAD_DIRECTORY = "C:\\uploads";
    public static HttpServletRequest uploadFile (HttpServletRequest request) {
        if(ServletFileUpload.isMultipartContent(request)){
            try {
                List<FileItem> multiparts = new ServletFileUpload(new DiskFileItemFactory()).parseRequest(request);
                Random rnd = new Random();
                for(FileItem item : multiparts){
                    if(!item.isFormField()){
                        String name = (100000000+rnd.nextInt(999999999))+".jpg";
                        File file = new File(UPLOAD_DIRECTORY + "\\" + name);
                        item.write(file);
                        if (isJpg(UPLOAD_DIRECTORY + "\\" + name)==true) {
                            request.setAttribute("ok", "File Uploaded Successfully");
                        } else {
                            file.delete();
                            request.setAttribute("error", "File Is Not JPEG");
                        }
                    }
                }
            } catch (Exception ex) {
                request.setAttribute("error", "File Upload Failed due to " + ex);
            }
        }else{
            request.setAttribute("error", "Sorry this Servlet only handles file upload request");
        }
        return request;
    }
    public static boolean isJpg (String url) {
        File file = new File(url);
        String hex=null;
        String jpgSignature="FFD8FFE04A46494600";
        try {
            byte[] bytes = Files.toByteArray(file);
            hex = bytesToHex(bytes);
        } catch (IOException e) {
           return false;
        }
        hex=hex.substring(0,8)+hex.substring(12,22);
        if (hex.equals(jpgSignature)) {
            return true;
        } else {
            return false;
        }
    }
    public static String bytesToHex(byte[] bytes) {
        char[] hexArray = "0123456789ABCDEF".toCharArray();
        char[] hexChars = new char[bytes.length * 2];
        for ( int j = 0; j < bytes.length; j++ ) {
            int v = bytes[j] & 0xFF;
            hexChars[j * 2] = hexArray[v >>> 4];
            hexChars[j * 2 + 1] = hexArray[v & 0x0F];
        }
        return new String(hexChars);
    }
}
