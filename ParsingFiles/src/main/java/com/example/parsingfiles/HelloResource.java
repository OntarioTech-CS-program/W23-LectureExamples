package com.example.parsingfiles;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;



@Path("/read")
public class HelloResource {
    ObjectMapper mapper = new ObjectMapper();

    @GET
    @Produces("text/html")
     /**
     * Endpoint URL: http://localhost:8080/ParsingFiles-1.0-SNAPSHOT/api/read
     * **/
    public String rootEndpoint() {
        String res = "Available endpoints are: <br>"+
                    "api/read/{colName} -- return the average grade for the given column name <br>"+
                    "api/read/book -- returns frequency of words in the text documents";
        return res;

    }
    @GET
    @Produces("text/plain")
    @Path("/{col}")
    /**
     * Endpoint URL: http://localhost:8080/ParsingFiles-1.0-SNAPSHOT/api/read/{colName}
     * **/
    public String readData(@PathParam("col") String colName) {
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
             res = myparser.findColumnAVG(colName);
        }

        return res;
    }

    @GET
    @Produces("application/json")
    @Path("/book")
    /**
     * Endpoint URL: http://localhost:8080/ParsingFiles-1.0-SNAPSHOT/api/read/book
     * **/
    public Response readBook() throws IOException {
        URL url = this.getClass().getClassLoader().getResource("/documents");
        File data = null;
        try {
            data = new File(url.toURI());
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
        BookParser myParser = new BookParser();
        // call function from parser to calculate the freq of words in text
        Map<String, Integer> freq = myParser.wordFrequencyDir(data);

        Response myResp = Response.status(200).header("Access-Control-Allow-Origin", "http://localhost:8448")
                .header("Content-Type", "application/json")
                .entity(mapper.writeValueAsString(freq))
                .build();

    return myResp;
    }

    @POST
    @Consumes("text/plain")
    @Path("/save")
    public Response save(String content) throws IOException {
        Map<String, Object> result = mapper.readValue(content, HashMap.class);

        String title = (String) result.get("title");
        String body = (String) result.get("content");

        URL url = this.getClass().getClassLoader().getResource("/records");
        File data = null;
        try {
            data = new File(url.toURI());
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }

        ExampleWriter myWriter = new ExampleWriter();
        myWriter.createFile(data, title, body);

        Response myResp = Response.status(200).header("Access-Control-Allow-Origin", "http://localhost:8448")
                .header("Content-Type", "application/json")
                .build();

        return myResp;

    }

}