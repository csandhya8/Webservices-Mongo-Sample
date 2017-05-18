package com.Customer;

import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.log4j.Logger;

@Path("/customer")
public class Customer {

	@GET
	@Path("/list")
	@Produces(MediaType.APPLICATION_XML)
	public ArrayList<CustomerDetails> listAllCustomers() {

		CustomerDAO dao = new CustomerDAO();
		ArrayList<CustomerDetails> details  = dao.listAllCustomers();
		
		return details;
	}

@GET
@Path("/listone")
@Produces(MediaType.APPLICATION_XML)
public CustomerDetails listCustomer() {

	CustomerDAO dao = new CustomerDAO();
	CustomerDetails details  = dao.listCustomer();
	
	return details;
}
}

