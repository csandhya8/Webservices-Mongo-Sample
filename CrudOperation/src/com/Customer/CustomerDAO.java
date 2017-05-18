package com.Customer;

import java.util.ArrayList;

import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.result.UpdateResult;
import com.Customer.CustomerDetails;
import com.Customer.UnoMongoConnector;

public class CustomerDAO {
	
	public static int pageSize = 100;


	//--------------------------------------------create a record------------------------------------------------------
		public void createCustomer(CustomerDetails customerDetails){
			MongoClient mongoClient = UnoMongoConnector.createMongoClient();
			MongoDatabase database = mongoClient.getDatabase("uno_db");
			
			MongoCollection<CustomerDetails> templateCollection = database.getCollection("customer", CustomerDetails.class);
			templateCollection.insertOne(customerDetails);
			mongoClient.close();
		}	
//-------------------------------------------------retrieve a single data--------------------------------------
	public CustomerDetails listCustomer(){
		

		
		MongoClient mongClient = UnoMongoConnector.createMongoClient();
		MongoDatabase database = mongClient.getDatabase("uno_db");
		
		MongoCollection<CustomerDetails> customerCollection = database.getCollection("customer", CustomerDetails.class);
		ArrayList<CustomerDetails> customerDetails = customerCollection.find().limit(200).into(new ArrayList<CustomerDetails>());		
		
		mongClient.close();
		
		return customerDetails.get(0);
	}
//--------------------------------------------update------------------------------------------------------------------	

	/*public void updateCustomer(){
		
		MongoClient mongClient = UnoMongoConnector.createMongoClient();
		MongoDatabase database = mongClient.getDatabase("uno_db");
		MongoCollection<CustomerDetails> CustomerCollection = database.getCollection("customer", CustomerDetails.class);
		BasicDBObject newDocument = new BasicDBObject();
		newDocument.put("customerId", 101);
		UpdateResult updateCustomer = CustomerCollection.updateMany(new BasicDBObject().append("customerId", 100), newDocument);	
		mongClient.close();
		
		
	}*/
	
public CustomerDetails updateCustomer(BasicDBObject searchQuery){
		
		MongoClient mongClient = UnoMongoConnector.createMongoClient();
		MongoDatabase database = mongClient.getDatabase("uno_db");
		
		MongoCollection<CustomerDetails> customerCollection = database.getCollection("customer", CustomerDetails.class);
		CustomerDetails updateCustomer = customerCollection.findOneAndUpdate(searchQuery,searchQuery);		
		
		mongClient.close();
		
		return updateCustomer;
	}
//----------------------------------------------delete-------------------------------------------------------------	
	
		
		public void deleteCustomer(CustomerDetails customerDetails){
			MongoClient mongoClient = UnoMongoConnector.createMongoClient();
			MongoDatabase database = mongoClient.getDatabase("uno_db");
			
			MongoCollection<CustomerDetails> templateCollection = database.getCollection("customer", CustomerDetails.class);
			templateCollection.deleteOne(customerDetails);
			mongoClient.close();
		}
		
		
		
		
//-----------------------------------------inserting more than one records------------------------------------------------------		
		
		
		
		public void createCustomer(ArrayList<CustomerDetails> customerList) {
			MongoClient mongoClient = UnoMongoConnector.createMongoClient();
			MongoDatabase database = mongoClient.getDatabase("uno_db");
			MongoCollection<CustomerDetails> templateCollection = database.getCollection("customer", CustomerDetails.class);
			templateCollection.insertMany(customerList);
			mongoClient.close();
			
		}	
		
//-------------------------------------------------retrieve  many data--------------------------------------------------------		
		public ArrayList<CustomerDetails> listAllCustomers(){
			
			MongoClient mongClient = UnoMongoConnector.createMongoClient();
			MongoDatabase database = mongClient.getDatabase("uno_db");
			
			MongoCollection<CustomerDetails> customerCollection = database.getCollection("customer", CustomerDetails.class);
			ArrayList<CustomerDetails> customerList = customerCollection.find().limit(pageSize).into(new ArrayList<CustomerDetails>());		
			
			mongClient.close();
			
			return customerList;
		}
			 
	 
	}	
	

	
	

