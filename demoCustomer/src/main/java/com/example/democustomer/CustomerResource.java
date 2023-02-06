package com.example.democustomer;

import com.example.domain.Customers;
import com.example.domain.Customer;
import com.example.util.CustomerUtility;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Response;

import static com.example.util.CustomerUtility.*;


@Path("/customers")
public class CustomerResource {
    Customers customersList;
    ObjectMapper objectMapper = new ObjectMapper();

    CustomerResource()  {
        loadResource();
    }

    private void loadResource(){
        try {
            this.customersList = objectMapper.readValue(readFileContents("/customers.json"), Customers.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    @GET
    @Produces("application/json")
    public Response getAllCustomers() {
        loadResource();
        String val = "Problem";
        try {
            val = objectMapper.writeValueAsString(customersList);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        Response myResp = Response.status(200).header("Access-Control-Allow-Origin", "http://localhost:8448")
                .header("Content-Type", "application/json")
                .entity(val)
                .build();

        return myResp;
    }

    @GET
    @Path("/{id}")
    @Produces("application/json")
    public String getCustomerId(@PathParam("id") String cId){
        loadResource();
        Customer c = customersList.findCustomerId(cId);
        if (c!=null){
            try {
                return objectMapper.writeValueAsString(c);
            } catch (JsonProcessingException e) {
                throw new RuntimeException(e);
            }
        }

        return "{\"Error\": \"Customer not found.\"}";

    }
}