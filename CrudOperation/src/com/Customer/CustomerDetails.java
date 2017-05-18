package com.Customer;

import javax.xml.bind.annotation.XmlRootElement;

import org.bson.BsonDocument;
import org.bson.BsonDocumentWrapper;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;



@XmlRootElement
public class CustomerDetails implements Bson {
	
	
	public String customerId;
	public String customerName;
	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public CustomerDetails(){
		
	}



	
	public CustomerDetails( String customerId, String customerName) {
		super();
	
		this.customerId = customerId;
		this.customerName = customerName;
		
	}
	
	
	
	private ObjectId _id;

	public CustomerDetails withNewObjectId() {
		setId(new ObjectId());
		return this;
	}

	public org.bson.types.ObjectId getId() {
		return _id;
	}

	public void setId(ObjectId _id) {
		this._id = _id;
	}

	@Override
	public <TDocument> BsonDocument toBsonDocument(Class<TDocument> documentClass, CodecRegistry codecRegistry) {
		return new BsonDocumentWrapper<CustomerDetails>(this, codecRegistry.get(CustomerDetails.class));
	}
	
	
	@Override
	public String toString() {
		return "AgentDetails [_id=" + _id + ",  customerId=" + customerId + ",customerName="
				+ customerName + "]";
	}

	
}
