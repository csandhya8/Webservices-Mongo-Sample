package com.Customer;

import org.bson.Document;

public class BsonDocumentBuilder {
	
	Document document = null;
	
	public BsonDocumentBuilder(){
		document = new Document(); 
	}
	
	public Document getDocument() {
		return document;
	}

	public BsonDocumentBuilder add(String key, Object val) {
		if (null != val) {
			document.put(key, val);
		}
		return this;
	}

	/**
	 * Added logic to include only when greater than zero or skipLessThanZero is false. 
	 * Otherwise while query, even this key will be added and results are wrong
	 * @param key
	 * @param val
	 * @param skipLessThanZero
	 * @return
	 */
	public BsonDocumentBuilder add(String key, int val, boolean skipLessThanZero) {
		if( !skipLessThanZero || val > 0){
			document.put(key, val);			
		}
		return this;
	}
	

	public BsonDocumentBuilder add(String key, Double val) {
		if( val != null){
			document.put(key, val);			
		}
		return this;
	}

	/**
	 * Added logic to include only when greater than zero or skipLessThanZero is false. 
	 * Otherwise while query, even this key will be added and results are wrong 
	 * @param key
	 * @param val
	 * @param skipLessThanZero
	 * @return
	 */
	public BsonDocumentBuilder add(String key, long val, boolean skipLessThanZero) {
		if( !skipLessThanZero || val > 0){
			document.put(key, val);
		}
		return this;
	}

	public BsonDocumentBuilder add(String key, String val) {
		if(null != val){
			document.put(key, val);
		}
		return this;
	}
	
	public BsonDocumentBuilder add(String key, String[] val) {
		if(null != val){
			document.put(key, val);
		}
		return this;
	}
	
}
