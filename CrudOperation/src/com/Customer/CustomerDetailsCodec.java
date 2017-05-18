package com.Customer;

import org.bson.BsonReader;
import org.bson.BsonString;
import org.bson.BsonValue;
import org.bson.BsonWriter;
import org.bson.Document;
import org.bson.codecs.Codec;
import org.bson.codecs.CollectibleCodec;
import org.bson.codecs.DecoderContext;
import org.bson.codecs.DocumentCodec;
import org.bson.codecs.EncoderContext;

import com.Customer.CustomerDetails;

public class CustomerDetailsCodec implements CollectibleCodec<CustomerDetails> {

	private Codec<Document> documentCodec;

	public CustomerDetailsCodec() {
		this.documentCodec = new DocumentCodec();
	}

	public CustomerDetailsCodec(Codec<Document> codec) {
		this.documentCodec = codec;
	}
	

	@Override
	public void encode(BsonWriter writer, CustomerDetails customer, EncoderContext encoderContext) {
		BsonDocumentBuilder docBuilder = new BsonDocumentBuilder();

		docBuilder.add("customerId", customer.getCustomerId())
		                 
		                  
				          .add("customerName", customer.getCustomerName());
						  
	

		documentCodec.encode(writer, docBuilder.getDocument(), encoderContext);
	}

	@Override
	public Class<CustomerDetails> getEncoderClass() {
		return CustomerDetails.class;
	}

	@Override
	public CustomerDetails decode(BsonReader reader, DecoderContext decoderContext) {
		Document document = documentCodec.decode(reader, decoderContext);

		CustomerDetails template = new CustomerDetails(document.getString("customerId"), 				
													document.getString("customerName"));

		template.setId(document.getObjectId("_id"));

		return template;
	}

	private String valueOf(String string) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean documentHasId(CustomerDetails customer) {
		return null == customer.getId();
	}

	@Override
	public CustomerDetails generateIdIfAbsentFromDocument(CustomerDetails customer) {
		return documentHasId(customer) ? customer.withNewObjectId() : customer;
	}

	@Override
	public BsonValue getDocumentId(CustomerDetails customer) {
		if (!documentHasId(customer)) {
			throw new IllegalStateException("The document does not contain an _id");
		}
		return new BsonString(customer.getId().toHexString());
	}

}
