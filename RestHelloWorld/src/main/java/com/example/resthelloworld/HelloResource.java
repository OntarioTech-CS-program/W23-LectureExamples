package com.example.resthelloworld;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;

@Path("/hello-world")
public class HelloResource {
    @GET
    @Produces("text/plain")
    public String hello() {
        return "Hello, World!";
    }

    @GET
    @Produces("text/plain")
    @Path("/{name}")
    public String greeting(@PathParam("name") String someVal){
        return "Hello, " + someVal;
    }

    @GET
    @Produces("text/plain")
    @Path("/{name}/{day}")
    public String greetingTIme(@PathParam("name") String someVal, @PathParam("day") String dayVal){
        return "Hello, " + someVal + ". Have a good " + dayVal + "!";
    }
}