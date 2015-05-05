package com.epam.tal5.khalii.IO;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;

/**
 * Created by Anhelina_Khalii on 30.04.2015.
 */
public class Copy {

    public static String source = "D:\\Folder";
    public static String destination = "D:\\Dest";

    public static void copyStream(File source, File destination) throws IOException{
        FileInputStream inputStream = new FileInputStream(source);
        FileOutputStream outputStream = new FileOutputStream(destination);
        byte[] buffer = new byte[4096];
        int length;
        while ((length = inputStream.read(buffer))>0){
            outputStream.write(buffer, 0, length);
        }
    }

    public static void copyNIO(File source, File destination) throws IOException{
        try(FileChannel sourceChanel = new FileInputStream(source).getChannel();
        FileChannel destinationChanel = new FileOutputStream(destination).getChannel()){
            destinationChanel.transferFrom(sourceChanel, 0, sourceChanel.size());
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void copy(File source, File destination, boolean flag){
        if (source.isDirectory()){
            destination.mkdir();
            String [] files = source.list();
            for(String file: files){
                  copy(new File(source, file), new File(destination, file), flag);
            }
        } else {
            try{
                if(flag)
                    copyStream(source, destination);
                else
                    copyNIO(source, destination);
            } catch (IOException e){
                e.printStackTrace();
            }
        }
    }

    public static void deleteFolder(File destination){
        if(!destination.exists())
            return;
        if(destination.isDirectory()){
            for(File file:destination.listFiles()){
                deleteFolder(file);
            }
            destination.delete();
        } else {
            destination.delete();
        }
    }

    public static void preparation(File destination){
        if(destination.exists())
            deleteFolder(destination);
        if(!destination.exists())
            destination.mkdir();
    }

    public static void main(String[] args) {
        File sour = new File(source);
        File dest = new File(destination);
        preparation(dest);
        long start, end;
        start = System.nanoTime();
        copy(sour, dest, true);
        end = System.nanoTime();
        System.out.println(end - start);
        preparation(dest);
        start = System.nanoTime();
        copy(sour, dest, false);
        end = System.nanoTime();
        System.out.println(end-start);

    }
}
