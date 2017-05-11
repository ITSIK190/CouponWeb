package a.test;

import core.beans.Company;
import core.cs.ClientType;
import core.cs.CouponSystem;
import core.exceptions.CouponSystemException;
import core.facade.AdminFacade;
import testcs.Test;

public class TestCode {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Test.delete();
		
		Company company = new Company();
		System.out.println(company);
		try {
		AdminFacade adminfacade = (AdminFacade) CouponSystem.getInstance().login("Admin", "Admin", ClientType.ADMIN);
		company = new Company(null, null, "aa");
		company.setId(0);
		
			company = adminfacade.getCompany(company);
		} catch (CouponSystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println(company); 
		

	}

}
