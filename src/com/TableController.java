package com;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TableController {
	@Autowired
    BillSplitDao bsd;
	@Autowired
	ShareBillDao sb;
	
	
	@RequestMapping(value="/getTable" ,method =RequestMethod.POST)
	protected ModelAndView getTable(@RequestParam("tableno") String tableno, HttpSession session){
		ModelAndView model;
		session.setAttribute("tableno", tableno);
	   String bill = sb.getBill(tableno);
	   	if(!bill.isEmpty()){
		 model = new ModelAndView("payamount","amount",bill);
		return model;
	   }
	   return new ModelAndView("tablefindform","fail","Cannot able to process the payment try again");
	}
	
	
	
	@RequestMapping(value="/updateBill" ,method =RequestMethod.POST)
	protected ModelAndView updateBill(@RequestParam("tableno") String tableno,
			@RequestParam("billamount") String billamount
			
			){
		ModelAndView model;
		BillSplit bs = new BillSplit();
		bs.setTableno(tableno);
		bs.setBillamount(billamount);
		int pass = bsd.billInsert(bs);
		if(pass ==1){
		 model=new ModelAndView("success");
		model.addObject("suc","BILL SUCCESSFULLY UPDATED");
		return model;
		}
		
		return new ModelAndView("tableform","fail","BILL NOT UPDATED TRY AGAIN");
	}
	
	
	
}

