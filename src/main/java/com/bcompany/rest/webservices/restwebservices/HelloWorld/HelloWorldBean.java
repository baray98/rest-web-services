package com.bcompany.rest.webservices.restwebservices.HelloWorld;

public class HelloWorldBean {

	private String message;
	public HelloWorldBean(String string) {
		// TODO Auto-generated constructor stub
		this.setMessage(string);
	}
	public String getMessage() {
		return message;
	}
	@Override
	public String toString() {
		return "HelloWorldBean [message=" + message + "]";
	}
	public void setMessage(String message) {
		this.message = message;
	}

}
