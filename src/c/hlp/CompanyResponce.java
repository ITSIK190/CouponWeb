package c.hlp;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlRootElement;

import core.beans.Company;

@XmlRootElement
public class CompanyResponce {
	private String message;
	private ArrayList<Company> companies;
	
	
	public CompanyResponce() {
		super();
	}
	
	
	public CompanyResponce(String message) {
		super();
		this.message = message;
	}


	public CompanyResponce(String message, ArrayList<Company> companies) {
		super();
		this.message = message;
		this.companies = companies;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public ArrayList<Company> getCompanies() {
		return companies;
	}
	public void setCompanies(ArrayList<Company> companies) {
		this.companies = companies;
	}
	@Override
	public String toString() {
		return "CompanyResponce [message=" + message + ", companies=" + companies + "]";
	}
	
	

}
