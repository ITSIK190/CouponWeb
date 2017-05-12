package c.hlp;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlRootElement;


import core.beans.Customer;

@XmlRootElement
public class CustomerResponse {
	private String message;
	private ArrayList<Customer> customers;
	public CustomerResponse() {
		super();
	}
	public CustomerResponse(String message) {
		super();
		this.message = message;
	}
	public CustomerResponse(String message, ArrayList<Customer> customers) {
		super();
		this.message = message;
		this.customers = customers;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public ArrayList<Customer> getCustomers() {
		return customers;
	}
	public void setCustomers(ArrayList<Customer> customers) {
		this.customers = customers;
	}
	@Override
	public String toString() {
		return "CustomerResponse [message=" + message + ", customers=" + customers + "]";
	}
	
	
	

}
