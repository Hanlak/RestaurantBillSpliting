package com;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class PaymentHandler {
	@Autowired
    BillSplitDao bsd;
	@Autowired
	ShareBillDao sb;
	@RequestMapping(value="/payment" ,method =RequestMethod.POST)
	protected ModelAndView payment( @RequestParam("tableno") String tableno,@RequestParam("amount") String amount,
			 @RequestParam("cardnumber") String cardnumber,  @RequestParam("cvv") String cvv){
		
	return new ModelAndView("success","suc","SuccessfullyPaid");
	}
	@RequestMapping(value="/showpayments",method =RequestMethod.GET)
	protected ModelAndView showpayments(){
		ModelAndView checkpay =new ModelAndView("showpayments");
		List<Map<String,Object>> list = sb.selectAllTables();
		System.out.println(list);
		checkpay.addObject("map",list);
		return checkpay;
	}
	
	@RequestMapping(value="/payByCash", method=RequestMethod.POST)
	protected ModelAndView payByCash(@RequestParam("bill") String bill,HttpSession session) {
		String tableno = (String)session.getAttribute("tableno");
		String totalamount = sb.getBill(tableno);
		ModelAndView success = new ModelAndView("success","suc","Thank You Visit Again");
		ModelAndView cash = new ModelAndView("payamount");
		float fee = Float.parseFloat(totalamount)-Float.parseFloat(bill);
		if(fee>0 ||fee>0.0) {
		int updated = bsd.billCheck(tableno, Float.toString(fee));
		
		if(updated==1) {
			String showbill = sb.getBill(tableno);
			if(Float.parseFloat(showbill) == 0.0) {
				return success;
			}
			cash.addObject("amount",showbill);
			return cash;
		}
		else {
		cash.addObject("fail","Unable to update the data to db");
		return cash;
		}
		}
		
		return success;
	}
	
	@RequestMapping(value="/payByCard", method=RequestMethod.POST)
	protected ModelAndView payByCard(@RequestParam("amount") String bill,@RequestParam("cardnumber") String cardnumber,@RequestParam("cvv") String cvv,HttpSession session) {
		String tableno = (String)session.getAttribute("tableno");
		String totalamount = sb.getBill(tableno);
		ModelAndView cash = new ModelAndView("payamount");
		float fee = Float.parseFloat(totalamount)-Float.parseFloat(bill);
		ModelAndView success = new ModelAndView("success","suc","Thank You Visit Again");
		if(fee>0 ||fee>0.0) {
		int updated = bsd.billCheck(tableno, Float.toString(fee));
		
		if(updated==1) {
			String showbill = sb.getBill(tableno);
			if(Float.parseFloat(showbill) == 0.0) {
				return success;
			}
			cash.addObject("amount",showbill);
			return cash;
		}
		else {
			cash.addObject("fail","Amount not proccessed in db,plz check again");
			return cash;
		}
		}
		
		return success;
	}
}


