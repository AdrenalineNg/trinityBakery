package com.trinityBakery.trinityBakery.controller;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.trinityBakery.trinityBakery.dao.orderRepository;
import com.trinityBakery.trinityBakery.dao.refundRepository;
import com.trinityBakery.trinityBakery.dao.tihuoRepository;
import com.trinityBakery.trinityBakery.model.order;
import com.trinityBakery.trinityBakery.model.refund;
import com.trinityBakery.trinityBakery.model.shoppingcart;
import com.trinityBakery.trinityBakery.model.tihuo;


@Controller
public class financeController {
	@Autowired
	private orderRepository orepository;
	@Autowired
	private refundRepository rrepository;
	@Autowired
	private tihuoRepository trepository;
	
    @RequestMapping("finance-account-billofloading")
    public String finance_account_billofloading() {
        return "finance-account-billofloading";
    }
    
    @RequestMapping(value = "/finance-cashier",method = RequestMethod.GET) 
    public String finance_cashier(Map<String, Object> map) {
        //出纳看见的订单
    	List<order> list = new ArrayList<order>();
        list = orepository.findAll();
        map.put("order", list);
        return "finance-cashier";
    }


    @RequestMapping(value = "/finance-account",method = RequestMethod.GET) 
    public String finance_account(Map<String, Object> map) {
        //会计能看见的订单
    	List<order> list = new ArrayList<order>();
        list = orepository.findAll();
        map.put("order", list);
        return "finance-account";
    }

    
    @RequestMapping("/account-confirm/{id}")
    public String accountConfirm(@PathVariable("id") String id){
        //会计确认id为id的生成提货单
    	order od=new order();
    	od = orepository.getOne(id);
    	od.setTihuo("已生成提货单");
    	tihuo th=new tihuo();
    	th.setTihuo_id(id);
    	th.setAddress(od.getAddress());
    	th.setTihuo("未提货");
    	th.setTotalprice(od.getTotalprice());
    	orepository.save(od);
    	trepository.save(th);
        return "redirect:/finance-account";
    }

    //这个不要了
    @RequestMapping("/account-confirm-refound/{id}")
    public String accountConfirmRefound(@PathVariable("id") Integer id){
        //会计确认id为id的退款单
        return "redirect:/finance-account-refund";
    }
    
    @RequestMapping(value = "/finance-account-refund",method = RequestMethod.GET) 
    public String finance_account_refund(Map<String, Object> map) {
        //会计的退款单
    	List<refund> list = new ArrayList<refund>();
        list = rrepository.findAll();
        map.put("refund", list);
        return "finance-account-refund";
    }
    
    @RequestMapping(value = "/finance-cashier-refund",method = RequestMethod.GET) 
    public String finance_cashier_refund(Map<String, Object> map) {
        //出纳的退款单
    	List<refund> list = new ArrayList<refund>();
        list = rrepository.findAll();
        map.put("refund", list);
        return "finance-cashier-refund";
    }




}
