package com.epam.tal5.khalii.IO;

import java.io.*;

import static java.lang.System.out;

/**
 * Created by Anhelina_Khalii on 29.04.2015.
 */
public class Streams {
    public static void main(String[] args) throws IOException {
        FileInputStream st = new FileInputStream("d:\\test.txt");
        out.print("\nRead from stream by bytes\n");
        while(st.available()!=0)
        {
            int b=st.read();
            char ch=(char)b;
            out.print(ch);

        }
        st.close();
        FileOutputStream so= new FileOutputStream("out.txt");// запись в фаил!
        String d="Привет";
        byte[] bytes= d.getBytes();
        so.write(bytes);
        so.close();

        BufferedReader reader = new BufferedReader(new FileReader("test.txt"));
        String s=null;
        out.print("\nRead from Stream by Strings\n");
        while ((s=reader.readLine())!=null)
        {
            out.println(s);
        }
        reader.close();

        PrintWriter write=new PrintWriter("out1.txt");
        write.printf("%s %d %c", "Строка",100,'ё');
        write.close();
    }
}
