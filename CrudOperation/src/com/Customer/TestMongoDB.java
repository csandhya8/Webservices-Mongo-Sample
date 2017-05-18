package com.Customer;

import java.util.ArrayList;
import java.util.Iterator;

import org.bson.conversions.Bson;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.WriteResult;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.result.UpdateResult;
import com.sun.tools.javac.util.List;
import com.sun.xml.internal.txw2.Document;


public class TestMongoDB {
	
	
	

	public static void main(String arg[])
	{
		
		try {
			
			
	//------------------------------------------update---------------------------------------------------------------------------		
			
			/*MongoClient mongClient = UnoMongoConnector.createMongoClient();
			MongoDatabase database = mongClient.getDatabase("uno_db");
			
			MongoCollection<CustomerDetails> CustomerCollection = database.getCollection("customer", CustomerDetails.class);
			
			BasicDBObject newDocument = new BasicDBObject();
			newDocument.put("$set", new BasicDBObject("customerName","sdfa"));
			CustomerCollection.findOneAndUpdate(new BasicDBObject().append("_Id","576bba836f0e2fbf29f93fd2" ), newDocument);	
			
			
			System.out.println(CustomerCollection);
*/
			CustomerDAO dao = new CustomerDAO();
			BasicDBObject newDocument = new BasicDBObject();
			newDocument.append("$set", new BasicDBObject().append("customerName", "sandy"));
					
			BasicDBObject searchQuery = new BasicDBObject().append("_id", "576bba836f0e2fbf29f93fd2");

			dao.updateCustomer(searchQuery);
//-------------------------------------------------inserting a single record--------------------------------------------------------------------------------			
			
		
		CustomerDetails customer = new CustomerDetails("101", "Customer1");
		//CustomerDAO dao = new CustomerDAO();
		dao.createCustomer(customer);
		System.out.println("Get All Customer");
//-------------------------------------------------inserting a multiple record--------------------------------------------------------------------------------					
		CustomerDetails customer1 = new CustomerDetails("1", "sandhya");
		CustomerDetails customer2 = new CustomerDetails("2", "bablu");
		//CustomerDAO dao = new CustomerDAO();
		ArrayList<CustomerDetails> customerList = new ArrayList<CustomerDetails>();
		customerList.add(customer1);
		customerList.add(customer2);
		dao.createCustomer(customerList);
		
		
		
//------------------------------------------------retrieve data from the Mongodb------------------------------------------------------------------------------		
			//CustomerDAO dao = new CustomerDAO();
	   System.out.println(dao.listCustomer().toString());
	    

			
			
//------------------------------------------------retrieve all data from the Mongodb------------------------------------------------------------------------------					
	 
				
			Iterator<CustomerDetails> cursor = dao.listAllCustomers().iterator();
			while(cursor.hasNext()) {
			        System.out.println(cursor.next());
			    }
	        System.out.println("hello");	
			
			
//-----------------------------------------------deleting a record	-------------------------------------------------------------------------------------------
		    
			//CustomerDetails customer = new CustomerDetails("111", "Customer1");
			//CustomerDAO dao = new CustomerDAO();
			dao.deleteCustomer(customer);
		   
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		
	}

	
}
