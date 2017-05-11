package b.cs;

import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import c.hlp.CompanyResponce;
import core.beans.Company;
import core.cs.ClientType;
import core.cs.CouponSystem;
import core.exceptions.CouponSystemException;
import core.facade.AdminFacade;

@Path("/Admin")
public class AdminService {
	private CompanyResponce responce;

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
	public CompanyResponce createCompanyService(@QueryParam("User") String user, @QueryParam("PW") String pw,
			@QueryParam("Email") String email, @QueryParam("name") String name,
			@QueryParam("CompanyPw") String companyPw) {

		try {
			AdminFacade adminfacade = (AdminFacade) CouponSystem.getInstance().login(user, pw, ClientType.ADMIN);
			Company company = new Company(name, companyPw, email);
			adminfacade.createCompany(company);
		} catch (CouponSystemException e) {
			// TODO Auto-generated catch block
			responce = new CompanyResponce("error: " + e.getMessage());
			return responce;
		}

		responce = new CompanyResponce("success");
		return responce;
	}

	@Path("/removeCompanyService")
	@GET
	@Produces(MediaType.APPLICATION_XML)
	public CompanyResponce removeCompanyService(@QueryParam("User") String user, @QueryParam("PW") String pw,
			@QueryParam("Email") String email) {

		try {
			AdminFacade adminfacade = (AdminFacade) CouponSystem.getInstance().login(user, pw, ClientType.ADMIN);
			Company company = new Company(null, null, email);
			adminfacade.removeCompany(company);
		} catch (CouponSystemException e) {
			// TODO Auto-generated catch block
			responce = new CompanyResponce("error: " + e.getMessage());
			return responce;
		}

		responce = new CompanyResponce("success");
		return responce;
	}

	@Path("/updateCompanyService")
	@GET
	@Produces(MediaType.APPLICATION_XML)
	public CompanyResponce updateCompanyService(@QueryParam("User") String user, @QueryParam("PW") String pw,
			@QueryParam("Email") String email, @QueryParam("name") String name,
			@QueryParam("CompanyPw") String companyPw) {

		try {
			AdminFacade adminfacade = (AdminFacade) CouponSystem.getInstance().login(user, pw, ClientType.ADMIN);
			Company company = new Company(name, companyPw, email);
			adminfacade.updateCompany(company);
		} catch (CouponSystemException e) {
			// TODO Auto-generated catch block
			responce = new CompanyResponce("error: " + e.getMessage());
			return responce;
		}

		responce = new CompanyResponce("success");
		return responce;
	}

	@Path("/getCompanyService")
	@GET
	@Produces(MediaType.APPLICATION_XML)
	public CompanyResponce getCompanyService(@QueryParam("User") String user, @QueryParam("PW") String pw,
			@QueryParam("Email") String email)  {
		

		AdminFacade adminfacade;
		Company company = new Company(null, null, email);
		
		responce = new CompanyResponce();
		try {
			adminfacade = (AdminFacade) CouponSystem.getInstance().login(user, pw, ClientType.ADMIN);
			System.out.println(company);
			company = adminfacade.getCompany(company);
			ArrayList<Company> companies = new ArrayList<>();
			companies.add(company);
			responce.setCompanies(companies);
		} catch (CouponSystemException e) {
			// TODO Auto-generated catch block
			responce.setMessage("error: " + e.getMessage());
			return responce;
		}

		responce.setMessage("success");
		return responce;
	}

}
