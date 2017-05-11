package b.cs;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;


import core.beans.Company;
import core.cs.ClientType;
import core.cs.CouponSystem;
import core.exceptions.CouponSystemException;
import core.facade.AdminFacade;

@Path("/Admin")
public class AdminService {

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
	@Produces(MediaType.TEXT_HTML)
	public String createCompanyService(@QueryParam("User") String user, @QueryParam("PW") String pw,
			@QueryParam("Email") String email, @QueryParam("name") String name,
			@QueryParam("CompanyPw") String companyPw) {

		try {
			AdminFacade adminfacade = (AdminFacade) CouponSystem.getInstance().login(user, pw, ClientType.ADMIN);
			Company company = new Company(name, companyPw, email);
			adminfacade.createCompany(company);
		} catch (CouponSystemException e) {
			// TODO Auto-generated catch block
			return "error: " + e.getMessage();
		}

		return "success";
	}

	@Path("/removeCompanyService")
	@GET
	@Produces(MediaType.TEXT_HTML)
	public String removeCompanyService(@QueryParam("User") String user, @QueryParam("PW") String pw,
			@QueryParam("Email") String email) {

		try {
			AdminFacade adminfacade = (AdminFacade) CouponSystem.getInstance().login(user, pw, ClientType.ADMIN);
			Company company = new Company(null, null, email);
			adminfacade.removeCompany(company);
		} catch (CouponSystemException e) {
			// TODO Auto-generated catch block
			return "error: " + e.getMessage();
		}

		return "success";
	}

	@Path("/updateCompanyService")
	@GET
	@Produces(MediaType.TEXT_HTML)
	public String updateCompanyService(@QueryParam("User") String user, @QueryParam("PW") String pw,
			@QueryParam("Email") String email, @QueryParam("name") String name,
			@QueryParam("CompanyPw") String companyPw) {

		try {
			AdminFacade adminfacade = (AdminFacade) CouponSystem.getInstance().login(user, pw, ClientType.ADMIN);
			Company company = new Company(name, companyPw, email);
			adminfacade.updateCompany(company);
		} catch (CouponSystemException e) {
			// TODO Auto-generated catch block
			return "error: " + e.getMessage();
		}

		return "success";
	}

	@Path("/getCompanyService")
	@GET
	@Produces(MediaType.APPLICATION_XML)
	public Company getCompanyService(@QueryParam("User") String user, @QueryParam("PW") String pw,
			@QueryParam("Email") String email)  {
		

		AdminFacade adminfacade;
		Company company = new Company(null, null, email);
		try {
			adminfacade = (AdminFacade) CouponSystem.getInstance().login(user, pw, ClientType.ADMIN);
			company = adminfacade.getCompany(company);
		} catch (CouponSystemException e) {
			// TODO Auto-generated catch block
			company.setEmail(e.getMessage());
		}
		 
		
		

		return company;
	}

}
