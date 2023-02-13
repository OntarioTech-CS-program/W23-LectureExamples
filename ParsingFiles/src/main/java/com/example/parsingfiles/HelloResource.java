package com.example.parsingfiles;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;

import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;

@Path("/read")
public class HelloResource {
    @GET
    @Produces("text/plain")
    public String readData() {
        URL url = this.getClass().getClassLoader().getResource("/records/data.csv");
        System.out.print(url);

        File data = null;
        try {
            data = new File(url.toURI());
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }

        String res = "Something went wrong";
        if (data!=null){
            ExampleParser myparser = new ExampleParser(data);
             res = myparser.findColumnAVG("Labs");
        }

        return res;
    }
}