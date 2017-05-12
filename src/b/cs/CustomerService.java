package b.cs;

import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import c.hlp.CouponResponse;
import core.beans.Coupon;
import core.beans.CouponType;
import core.cs.ClientType;
import core.cs.CouponSystem;
import core.exceptions.CouponSystemException;
import core.facade.CompanyFacade;
import core.facade.CustomerFacade;

@Path("/Customer")
public class CustomerService {
	private CouponResponse couponResponse;

	static {
		try {
			Class.forName("org.apache.derby.jdbc.ClientDriver");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	@Path("/purchaseCouponService")
	@GET
	@Produces(MediaType.APPLICATION_XML)
	public CouponResponse purchaseCouponService(@QueryParam("User") String user, @QueryParam("PW") String pw,
			@QueryParam("Title") String title) {

		Coupon coupon = new Coupon(title);
		couponResponse = new CouponResponse();
		try {
			CustomerFacade customerFacade = (CustomerFacade) CouponSystem.getInstance().login(user, pw,
					ClientType.CUSTOMER);
			customerFacade.purchaseCoupon(coupon);
		} catch (CouponSystemException e) {
			// TODO Auto-generated catch block
			couponResponse.setMessage("error: " + e.getMessage());
			return couponResponse;
		}

		couponResponse.setMessage("success");
		return couponResponse;
	}
	
	
	
	
	@Path("/getAllPurchasedCouponsService")
	@GET
	@Produces(MediaType.APPLICATION_XML)
	public CouponResponse getAllPurchasedCouponsService(@QueryParam("User") String user, @QueryParam("PW") String pw) {

		
		couponResponse = new CouponResponse();
		try {
			CustomerFacade customerFacade = (CustomerFacade) CouponSystem.getInstance().login(user, pw,
					ClientType.CUSTOMER);

			couponResponse.setCoupons((ArrayList<Coupon>) customerFacade.getAllPurchasedCoupons());
		} catch (CouponSystemException e) {
			// TODO Auto-generated catch block
			couponResponse.setMessage("error: " + e.getMessage());
			return couponResponse;
		}

		couponResponse.setMessage("success");
		return couponResponse;
	}
	
	
	

	@Path("/getAllPurchasedCouponsByTypeService")
	@GET
	@Produces(MediaType.APPLICATION_XML)
	public CouponResponse getAllPurchasedCouponsByTypeService(@QueryParam("User") String user, @QueryParam("PW") String pw, @QueryParam("Type") String type) {

		
		couponResponse = new CouponResponse();
		try {
			CustomerFacade customerFacade = (CustomerFacade) CouponSystem.getInstance().login(user, pw,
					ClientType.CUSTOMER);

			couponResponse.setCoupons((ArrayList<Coupon>) customerFacade.getAllPurchasedCouponsByType(CouponType.valueOf(type)));
		} catch (CouponSystemException e) {
			// TODO Auto-generated catch block
			couponResponse.setMessage("error: " + e.getMessage());
			return couponResponse;
		}

		couponResponse.setMessage("success");
		return couponResponse;
	}
	
	
	

	@Path("/getAllPurchasedCouponsByPriceService")
	@GET
	@Produces(MediaType.APPLICATION_XML)
	public CouponResponse getAllPurchasedCouponsByPriceService(@QueryParam("User") String user, @QueryParam("PW") String pw, @QueryParam("Price") String price) {

		
		couponResponse = new CouponResponse();
		try {
			CustomerFacade customerFacade = (CustomerFacade) CouponSystem.getInstance().login(user, pw,
					ClientType.CUSTOMER);

			couponResponse.setCoupons((ArrayList<Coupon>) customerFacade.getAllPurchasedCouponsByPrice(Double.valueOf(price)));
		} catch (CouponSystemException e) {
			// TODO Auto-generated catch block
			couponResponse.setMessage("error: " + e.getMessage());
			return couponResponse;
		}

		couponResponse.setMessage("success");
		return couponResponse;
	}



}
