package com.epam.tal5.khalii.IO;

import javax.print.DocFlavor;
import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

/**
 * Created by Anhelina_Khalii on 29.04.2015.
 */
public class IOTest {
    public static void main(String[] args) throws IOException {
   /*     InputStream inFile = new FileInputStream("d:\\test.txt");
        readFullyByByte(inFile);
        System.out.println("\n\n\n");

        InputStream inUrl = new URL("https://google.com").openStream();
        readFullyByByte(inUrl);
        System.out.println("\n\n\n");*/

        InputStream inArray = new ByteArrayInputStream(new byte[]{65, -66, -67, 68, 69});
        readFullyByByte(inArray);
        System.out.println("\n\n\n");

    }

    public static void readFullyByByte(InputStream in) throws IOException{
        while(true){
            int oneByte = in.read();
            if (oneByte !=-1){
         //       System.out.println((char) oneByte);
                System.out.println(oneByte);
            } else {
                System.out.println("\n"+"end");
                break;
            }
        }
    }
}

