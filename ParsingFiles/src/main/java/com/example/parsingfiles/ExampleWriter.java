package com.example.parsingfiles;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

public class ExampleWriter {

    public void createFile(File dir, String name, String content) throws IOException {
        File myFile = null;

        myFile = new File(dir, name);
        if(myFile.createNewFile()){
            System.out.println("File created at: "+ myFile.getPath());
        }else{
            System.out.println("File already existed at: "+ myFile.getPath());
        }

        if(myFile!=null){
            PrintWriter output = new PrintWriter(myFile);
            output.print(content);
            output.close();
        }

    }
}
