package com.framework.cupomfiscal;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

public class PDFtoByte {
    public static byte[] convert(File invoice){
        byte[] bFile = null;
        
        try{
            bFile = Files.readAllBytes(Paths.get(invoice.getAbsolutePath()));
        }catch (Exception e){
            e.printStackTrace();
        }
        
        return bFile;
    }
}