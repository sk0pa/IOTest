package com.epam.tal5.khalii.IO;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Anhelina_Khalii on 29.04.2015.
 */
public class Threads {
    public static void main(String[] args) {
        try{
            FileWriter out = new FileWriter("d:\\test.txt");
            BufferedWriter br = new BufferedWriter(out);
            PrintWriter pw = new PrintWriter(br);
            pw.println("I'm a sentence in a text-file.");
            pw.close();
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
