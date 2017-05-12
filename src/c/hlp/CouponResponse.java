package c.hlp;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlRootElement;

import core.beans.Coupon;



@XmlRootElement
public class CouponResponse {
	
	private String message;
	private ArrayList<Coupon> coupons;
	public CouponResponse() {
		super();
	}
	public CouponResponse(String message) {
		super();
		this.message = message;
	}
	public CouponResponse(String message, ArrayList<Coupon> coupons) {
		super();
		this.message = message;
		this.coupons = coupons;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public ArrayList<Coupon> getCoupons() {
		return coupons;
	}
	public void setCoupons(ArrayList<Coupon> coupons) {
		this.coupons = coupons;
	}
	@Override
	public String toString() {
		return "CouponResponse [message=" + message + ", coupons=" + coupons + "]";
	}
	
	

}
