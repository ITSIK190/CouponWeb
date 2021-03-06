package b.cs;

import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import c.hlp.CompanyResponse;
import c.hlp.CouponResponse;
import c.hlp.CustomerResponse;
import core.beans.Company;
import core.beans.Coupon;
import core.beans.Customer;
import core.cs.ClientType;
import core.cs.CouponSystem;
import core.exceptions.CouponSystemException;
import core.facade.AdminFacade;

@Path("/Admin")
public class AdminService {
	private CompanyResponse companyResponse;
	private CustomerResponse customerResponse;
	private CouponResponse couponResponse;
	

	static {
		try {
			Class.forName("org.apache.derby.jdbc.ClientDriver");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	// This method is called if HTML is request
	@Path("/createCompanyService")
	@GET
	@Produces(MediaType.APPLICATION_XML)
	public CompanyResponse createCompanyService(@QueryParam("User") String user, @QueryParam("PW") String pw,
			@QueryParam("Email") String email, @QueryParam("name") String name,
			@QueryParam("CompanyPw") String companyPw) {

		try {
			AdminFacade adminfacade = (AdminFacade) CouponSystem.getInstance().login(user, pw, ClientType.ADMIN);
			Company company = new Company(name, companyPw, email);
			adminfacade.createCompany(company);
		} catch (CouponSystemException e) {
			// TODO Auto-generated catch block
			companyResponse = new CompanyResponse("error: " + e.getMessage());
			return companyResponse;
		}

		companyResponse = new CompanyResponse("success");
		return companyResponse;
	}

	@Path("/removeCompanyService")
	@GET
	@Produces(MediaType.APPLICATION_XML)
	public CompanyResponse removeCompanyService(@QueryParam("User") String user, @QueryParam("PW") String pw,
			@QueryParam("Email") String email) {

		try {
			AdminFacade adminfacade = (AdminFacade) CouponSystem.getInstance().login(user, pw, ClientType.ADMIN);
			Company company = new Company(null, null, email);
			adminfacade.removeCompany(company);
		} catch (CouponSystemException e) {
			// TODO Auto-generated catch block
			companyResponse = new CompanyResponse("error: " + e.getMessage());
			return companyResponse;
		}

		companyResponse = new CompanyResponse("success");
		return companyResponse;
	}

	@Path("/updateCompanyService")
	@GET
	@Produces(MediaType.APPLICATION_XML)
	public CompanyResponse updateCompanyService(@QueryParam("User") String user, @QueryParam("PW") String pw,
			@QueryParam("Email") String email, @QueryParam("name") String name,
			@QueryParam("CompanyPw") String companyPw) {

		try {
			AdminFacade adminfacade = (AdminFacade) CouponSystem.getInstance().login(user, pw, ClientType.ADMIN);
			Company company = new Company(name, companyPw, email);
			adminfacade.updateCompany(company);
		} catch (CouponSystemException e) {
			// TODO Auto-generated catch block
			companyResponse = new CompanyResponse("error: " + e.getMessage());
			return companyResponse;
		}

		companyResponse = new CompanyResponse("success");
		return companyResponse;
	}

	@Path("/getCompanyService")
	@GET
	@Produces(MediaType.APPLICATION_XML)
	public CompanyResponse getCompanyService(@QueryParam("User") String user, @QueryParam("PW") String pw,
			@QueryParam("Email") String email)  {
		

		AdminFacade adminfacade;
		Company company = new Company(null, null, email);
		
		companyResponse = new CompanyResponse();
		try {
			adminfacade = (AdminFacade) CouponSystem.getInstance().login(user, pw, ClientType.ADMIN);
			System.out.println(company);
			company = adminfacade.getCompany(company);
			ArrayList<Company> companies = new ArrayList<>();
			companies.add(company);
			companyResponse.setCompanies(companies);
		} catch (CouponSystemException e) {
			// TODO Auto-generated catch block
			companyResponse.setMessage("error: " + e.getMessage());
			return companyResponse;
		}

		companyResponse.setMessage("success");
		return companyResponse;
	}
	
	
	@Path("/getAllCompaniesService")
	@GET
	@Produces(MediaType.APPLICATION_XML)
	public CompanyResponse getAllCompaniesService(@QueryParam("User") String user, @QueryParam("PW") String pw) {
		
		AdminFacade adminfacade;
		companyResponse = new CompanyResponse();
		try {
			adminfacade = (AdminFacade) CouponSystem.getInstance().login(user, pw, ClientType.ADMIN);
			
			companyResponse.setCompanies((ArrayList<Company>)adminfacade.getAllCompanies());
		} catch (CouponSystemException e) {
			// TODO Auto-generated catch block
			companyResponse.setMessage("error: " + e.getMessage());
			return companyResponse;
		}

		companyResponse.setMessage("success");
		return companyResponse;
	}
	
	
	@Path("/createCustomerService")
	@GET
	@Produces(MediaType.APPLICATION_XML)
	public CustomerResponse createCustomerService(@QueryParam("User") String user, @QueryParam("PW") String pw,
			@QueryParam("Email") String email, @QueryParam("name") String name,
			@QueryParam("CustomerPw") String customerPw) {

		try {
			AdminFacade adminfacade = (AdminFacade) CouponSystem.getInstance().login(user, pw, ClientType.ADMIN);
			Customer custromer = new Customer(name, customerPw, email);
			adminfacade.createCustomer(custromer);
		} catch (CouponSystemException e) {
			// TODO Auto-generated catch block
			customerResponse = new CustomerResponse("error: " + e.getMessage());
			return customerResponse;
		}

		customerResponse = new CustomerResponse("success");
		return customerResponse;
	}

	

	@Path("/removeCustomerService")
	@GET
	@Produces(MediaType.APPLICATION_XML)
	public CustomerResponse removeCustomerService(@QueryParam("User") String user, @QueryParam("PW") String pw,
			@QueryParam("Email") String email) {

		try {
			AdminFacade adminfacade = (AdminFacade) CouponSystem.getInstance().login(user, pw, ClientType.ADMIN);
			Customer customer = new Customer(null, null, email);
			adminfacade.removeCustomer(customer);
		} catch (CouponSystemException e) {
			// TODO Auto-generated catch block
			customerResponse = new CustomerResponse("error: " + e.getMessage());
			return customerResponse;
		}

		customerResponse = new CustomerResponse("success");
		return customerResponse;
	}

	@Path("/updateCustomerService")
	@GET
	@Produces(MediaType.APPLICATION_XML)
	public CustomerResponse updateCustomerService(@QueryParam("User") String user, @QueryParam("PW") String pw,
			@QueryParam("Email") String email, @QueryParam("name") String name,
			@QueryParam("CustomerPw") String customerPw) {

		try {
			AdminFacade adminfacade = (AdminFacade) CouponSystem.getInstance().login(user, pw, ClientType.ADMIN);
			Customer customer = new Customer(name, customerPw, email);
			adminfacade.updateCustomer(customer);
		} catch (CouponSystemException e) {
			// TODO Auto-generated catch block
			customerResponse = new CustomerResponse("error: " + e.getMessage());
			return customerResponse;
		}

		customerResponse = new CustomerResponse("success");
		return customerResponse;
	}

	@Path("/getCustomerService")
	@GET
	@Produces(MediaType.APPLICATION_XML)
	public CustomerResponse getCustomerService(@QueryParam("User") String user, @QueryParam("PW") String pw,
			@QueryParam("Email") String email)  {
		

		AdminFacade adminfacade;
		Customer customer = new Customer(null, null, email);
		
		customerResponse = new CustomerResponse();
		try {
			adminfacade = (AdminFacade) CouponSystem.getInstance().login(user, pw, ClientType.ADMIN);
			System.out.println(customer);
			customer = adminfacade.getCustomer(customer);
			ArrayList<Customer> customers = new ArrayList<>();
			customers.add(customer);
			customerResponse.setCustomers(customers);
		} catch (CouponSystemException e) {
			// TODO Auto-generated catch block
			customerResponse.setMessage("error: " + e.getMessage());
			return customerResponse;
		}

		customerResponse.setMessage("success");
		return customerResponse;
	}
	
	
	@Path("/getAllCustomersService")
	@GET
	@Produces(MediaType.APPLICATION_XML)
	public CustomerResponse getAllCustomersService(@QueryParam("User") String user, @QueryParam("PW") String pw) {
		
		AdminFacade adminfacade;
		customerResponse = new CustomerResponse();
		try {
			adminfacade = (AdminFacade) CouponSystem.getInstance().login(user, pw, ClientType.ADMIN);
			
			customerResponse.setCustomers((ArrayList<Customer>)adminfacade.getAllCustomers());
		} catch (CouponSystemException e) {
			// TODO Auto-generated catch block
			customerResponse.setMessage("error: " + e.getMessage());
			return customerResponse;
		}

		customerResponse.setMessage("success");
		return customerResponse;
	}
	
	
	
	
	@Path("/getAllCouponsService")
	@GET
	@Produces(MediaType.APPLICATION_XML)
	public CouponResponse getAllCouponsService(@QueryParam("User") String user, @QueryParam("PW") String pw) {
		
		AdminFacade adminfacade;
		couponResponse = new CouponResponse();
		try {
			adminfacade = (AdminFacade) CouponSystem.getInstance().login(user, pw, ClientType.ADMIN);
			
			couponResponse.setCoupons((ArrayList<Coupon>)adminfacade.getAllCoupon());
		} catch (CouponSystemException e) {
			// TODO Auto-generated catch block
			couponResponse.setMessage("error: " + e.getMessage());
			return couponResponse;
		}

		couponResponse.setMessage("success");
		return couponResponse;
	}
	
	
	

	@Path("/getCouponByCompanyService")
	@GET
	@Produces(MediaType.APPLICATION_XML)
	public CouponResponse getCouponByCompanyService(@QueryParam("User") String user, @QueryParam("PW") String pw,
			@QueryParam("Email") String email) {
		
		AdminFacade adminfacade;
		couponResponse = new CouponResponse();
		 Company company = new Company();
		 company.setEmail(email);
		try {
			adminfacade = (AdminFacade) CouponSystem.getInstance().login(user, pw, ClientType.ADMIN);
			company = adminfacade.getCompany(company);
			couponResponse.setCoupons((ArrayList<Coupon>)adminfacade.getCouponByCompany(company));
		} catch (CouponSystemException e) {
			// TODO Auto-generated catch block
			couponResponse.setMessage("error: " + e.getMessage());
			return couponResponse;
		}

		couponResponse.setMessage("success");
		return couponResponse;
	}

}
