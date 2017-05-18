package com.Customer;

import org.bson.Document;
import org.bson.codecs.Codec;
import org.bson.codecs.configuration.CodecRegistries;
import org.bson.codecs.configuration.CodecRegistry;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.Customer.CustomerDetailsCodec;


public class UnoMongoConnector {

	public static MongoClient createMongoClient() {
		
		Codec<Document> defaultDocumentCodec = MongoClient.getDefaultCodecRegistry().get(Document.class);
		
		
		CustomerDetailsCodec customerDetailsCode = new CustomerDetailsCodec(defaultDocumentCodec);
		
		CodecRegistry codecRegistry = CodecRegistries.fromRegistries(
				MongoClient.getDefaultCodecRegistry(),
				CodecRegistries.fromCodecs(
								
								customerDetailsCode));
		
		MongoClientOptions options = MongoClientOptions.builder().codecRegistry(codecRegistry).build();
		
		MongoClient mongoClient = new MongoClient("localhost:27017", options);

		return mongoClient;
	}	
	
}
