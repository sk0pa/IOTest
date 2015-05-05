package com.epam.tal5.khalii.IO;

import java.io.File;
import java.util.Date;

import static java.lang.System.out;

/**
 * Created by Anhelina_Khalii on 29.04.2015.
 */
public class Directory {

    public static Date a;
    public static final String FileName=".\\test.txt";



    public static void fileWork(String fileName){
        File f1=new File(fileName);
        if (!f1.exists()) {
            out.printf("File %s doesn't exist",f1.getAbsolutePath());
        } else {
            out.println("Work with file");
            a=new Date(f1.lastModified());
            out.printf("File %s  Date: %s Size :%d\n",f1.getName(),a.toString(),f1.length());
        }
    }

    public static void dirWork(File dir){
        if(!dir.exists()){
            out.printf("Dir %s doesn't exist", dir.getAbsolutePath());
        } else {
            if(dir.isDirectory()){
                System.out.println("Directory work");
                File[] files = dir.listFiles();
                for(File file:files){

                    if(file.isDirectory()){
                        System.out.println(file.getName().toUpperCase());
                        dirWork(file);
                    } else {
                        System.out.println(file.getName().toLowerCase());
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        File d1=new File("D:\\python");
        dirWork(d1);
    }
}
