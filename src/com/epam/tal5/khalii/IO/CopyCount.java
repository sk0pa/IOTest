package com.epam.tal5.khalii.IO;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

import static java.lang.System.out;

/**
 * Created by Anhelina_Khalii on 29.04.2015.
 */
public class CopyCount {
    public static final String sourceFileName= "d:\\test.txt";
    public static final String destFileName= "d:\\dest.txt";

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(sourceFileName));
        PrintWriter write=new PrintWriter(destFileName);
        String s=null;
        int words=0, lines=0,chars=0;
        while ((s=reader.readLine())!=null) {
            lines++;
            String[] ws=s.trim().split("\\s");
            words+=ws.length;
            for(String l:ws)
                chars+=l.length();
            write.println(s.toUpperCase());
        }
        reader.close();
        write.close();
        out.printf("Copied chars - %d; words-%d; lines-%d\n",chars,words,lines);
    }
}
