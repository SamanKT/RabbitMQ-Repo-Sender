package com.rabbitmq.sender.message;

public class MyMessage {

	private int id;
	
	private String message;

	public MyMessage(int id, String message) {
		this.id = id;
		this.message = message;
	}
	
	public MyMessage() {
		
	}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "MyMessage [id=" + id + ", message=" + message + "]";
	}
	
	
	
}
