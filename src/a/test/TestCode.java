package a.test;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import core.beans.Company;
import core.beans.Coupon;
import core.beans.CouponType;
import core.cs.ClientType;
import core.cs.CouponSystem;
import core.exceptions.CouponSystemException;
import core.facade.AdminFacade;
import core.facade.CompanyFacade;
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
		
		java.util.Date pastutilDate = new java.util.Date();
		java.util.Date futureutilDate = new java.util.Date();
		
		
		java.sql.Date pastsqlDate = new java.sql.Date(pastutilDate.getTime());
		java.sql.Date futuresqlDate = new java.sql.Date(futureutilDate.getTime());
		
		
		 
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		//Date date =  df.parse("2010-12-30");
		 
		 
		Coupon coupon = new Coupon("title", pastsqlDate, futuresqlDate, 50, CouponType.CAMPING, "message", 90, "image");
		
		try {
		AdminFacade adminfacade = (AdminFacade) CouponSystem.getInstance().login("Admin", "Admin", ClientType.ADMIN);
		company = new Company("aaa", "aaa", "aaa");
		adminfacade.createCompany(company);
		//company.setId(0);
		CompanyFacade companyFacade = (CompanyFacade)  CouponSystem.getInstance().login("aaa", "aaa", ClientType.COMPANY);
		companyFacade.createCoupon(coupon);
		 adminfacade.removeCompany(company);
		 System.out.println("done");
		} catch (CouponSystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println(company); 
		System.out.println(coupon);

	}

}
