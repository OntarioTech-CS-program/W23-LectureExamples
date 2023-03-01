package org.example;

import org.json.JSONObject;

import java.io.*;
import java.net.*;
import java.util.*;


public class BookData {

    public static void main(String[] args) throws IOException {

        System.out.println("Hello world!");

        String url = "http://localhost:8080/ParsingFiles-1.0-SNAPSHOT/api/read/book";
        URL netURL = new URL(url);

        URLConnection conn = netURL.openConnection();
        conn.setDoOutput(false);
        conn.setDoInput(true);

        InputStream inStream = conn.getInputStream();
        BufferedReader in = new BufferedReader(new InputStreamReader(inStream));

        System.out.println(url);

        StringBuffer buffer = new StringBuffer();
        String line;
        while ((line = in.readLine()) != null) {
            buffer.append(line);
        }
        String jsonData = buffer.toString();

        System.out.println(jsonData);

        // transforming the string into objects using org.json library
        JSONObject data = new JSONObject(jsonData);
        Map<String, Object> mapData = data.toMap();

        Set<String> keys = mapData.keySet();
        Iterator<String> keyIterator = keys.iterator();

        // iterating over items in the map
        while(keyIterator.hasNext()){
            String word = keyIterator.next();
            int count = (int) mapData.get(word);
            System.out.printf("Found: %s (%s)\n", word, count);
        }

        inStream.close();



    }
}
