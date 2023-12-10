package com.example.poetical;

import android.content.Context;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class FileOps {
    Context context;
    public FileOps(Context context){
        this.context=context;
    }
    public void writeToIntFile(String fileName,String text){
        try {
            File file = new File(context.getFilesDir(), fileName);
            FileOutputStream outputStream = new FileOutputStream(file);
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(outputStream));
            if(text!=null) {
                writer.write(text);
                writer.close();
            }
        }
        catch(IOException e){

        }
    }
    public String readIntStorage(String fileName){
        String contents=" ";
        try {
            File file = new File(context.getFilesDir(), fileName);
            FileInputStream inputStream = new FileInputStream(file);
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            String line;
            StringBuilder stringBuilder = new StringBuilder();
            while ((line = reader.readLine()) != null) {
                stringBuilder.append(line);
            }
            contents = stringBuilder.toString().trim();
            return contents;
        } catch (IOException e) {
            //Toast.makeText(context, e.toString(), Toast.LENGTH_LONG).show();
            return  contents;
        }
    }
    public void deleteFile(String fileName){
        File file = new File(context.getFilesDir(), fileName); // Create a File object representing the file

        if (file.exists()) { // Check if the file exists
            file.delete();
        } else {
        }
    }

    public void writeNotif(String fileName,String text){
        try {
            File file = new File(context.getFilesDir(), fileName);
            if(!file.exists()) {
                FileOutputStream outputStream = new FileOutputStream(file);
                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(outputStream));
                writer.write(text);
                writer.close();
            }
        }
        catch(IOException e){

        }
    }
}
