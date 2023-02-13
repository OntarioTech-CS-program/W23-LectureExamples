package com.example.parsingfiles;

import java.io.*;

public class ExampleParser {
    private File directory = null;
    ExampleParser(File dir){
        this.directory = dir;
    }



    public String findColumnAVG(String col){
//        File inFile = new File();
        String columnName = col;
        String msg = "Not found or error occurred";

        try {
            FileReader fileInput = new FileReader(directory);
            BufferedReader input = new BufferedReader(fileInput);

            // read the first line
            String line = null;
            try {
                line = input.readLine();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            // find the index of the named column
            int columnIndex = -1;
            String[] columnNames = line.split(",");

            for (int i = 0; i < columnNames.length; i++) {
                if (columnNames[i].equals(columnName)) {
                    columnIndex = i;
                    break;
                }
            }

            if (columnIndex < 0) {
                System.err.println("Error: Column name not found");
                System.exit(0);
            }

            // calculate the average for that column
            float total = 0f;
            int count = 0;
            // reading line by line
            while ((line = input.readLine()) != null) {
                String[] data = line.split(",");
                float nextVal = Float.parseFloat(data[columnIndex]);
                total += nextVal;
                count++;
            }

           msg = "The average for "+ columnName+" is "+ (total/count);

            input.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return msg;
    }

}
