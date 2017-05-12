package a.test;

import java.util.Calendar;
import java.util.Date;

import core.beans.Company;
import core.beans.Coupon;
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
		
		Calendar cal = Calendar.getInstance();
		cal.set(2017, Calendar.APRIL, 20);
		Date future = new Date(cal.getTime().getTime());
		cal.set(2017, Calendar.FEBRUARY, 23);
//		long ts = System.currentTimeMillis();
		Date past = new Date(cal.getTime().getTime());
		
		Coupon coupon = new Coupon("", startDate, endDate, amount, type, message, price, image)
		
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
