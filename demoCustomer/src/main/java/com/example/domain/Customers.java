package com.example.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.Objects;


public class Customers {

    @JsonProperty("customers")
    public List<Customer> customersList;

    public Customer findCustomerId(String id){
        if (customersList!=null){
            for(Customer c: customersList){
                if (Objects.equals(c.getId(), id)){
                    return c;
                }
            }
        }
        return null;
    }
}
