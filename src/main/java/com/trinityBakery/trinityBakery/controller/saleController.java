package com.trinityBakery.trinityBakery.controller;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.hibernate.validator.constraints.pl.REGON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.trinityBakery.trinityBakery.dao.detailRepository;
import com.trinityBakery.trinityBakery.dao.orderRepository;
import com.trinityBakery.trinityBakery.dao.refundRepository;
import com.trinityBakery.trinityBakery.dao.userRepository;
import com.trinityBakery.trinityBakery.model.detail;
import com.trinityBakery.trinityBakery.model.good;
import com.trinityBakery.trinityBakery.model.order;
import com.trinityBakery.trinityBakery.model.refund;
import com.trinityBakery.trinityBakery.model.user;


@Controller

public class saleController {    
	
	@Autowired
	private orderRepository orepository;
	@Autowired
	private refundRepository rrepository;
	@Autowired
	private userRepository urepository;
	@Autowired
	private detailRepository drepository;
	

	@RequestMapping(value = "/sale",method = RequestMethod.GET)
    public String sale(Map<String, Object> map) {
		List<order> list = new ArrayList<order>();
        list = orepository.findAll();
        map.put("order", list);
        return "sale";
    }
    
	@RequestMapping(value = "/sale-user",method = RequestMethod.GET)
    public String sale_user(Map<String, Object> map) {
		List<user> list = new ArrayList<user>();
        list = urepository.findAll();
        map.put("user", list);
        return "sale-user";
    }
    
	@RequestMapping(value = "/sale-order-detail{id}",method = RequestMethod.GET)    
    public String sale_order_detail(Map<String, Object> map) {
        //根据id获取详情
		List<detail> list = new ArrayList<detail>();
        list = drepository.findAll();
        map.put("detail", list);
        return "sale-order-detail";
    }
    
	@RequestMapping(value = "/sale-refund",method = RequestMethod.GET)
    public String sale_refund(Map<String, Object> map) {
    	List<refund> list = new ArrayList<refund>();
        list = rrepository.findAll();
        map.put("refund", list);
        return "sale-refund";
    }
	
    
//	@RequestMapping(value = "/sale-refund",method = RequestMethod.GET)
//    public List<refund> sale_refund(Map<String, Object> map) {
//    	List<refund> list = new ArrayList<refund>();
//        list = rrepository.findAll();
//        map.put("refund", list);
//        return list;
//    }
    
    
	@RequestMapping(value = "/sale-refund-detail{id}",method = RequestMethod.GET)
    public String sale_refund_detail(Map<String, Object> map) {
        //更具id获取详情
		List<detail> list = new ArrayList<detail>();
        list = drepository.findAll();
        map.put("detail", list);
        return "sale-refund-detail";
    }
	
    @RequestMapping("/sale-create-user")
    public String saleCreateUser(HttpServletRequest request){
        String username =request.getParameter("c-username");
        String contact = request.getParameter("c-contect");
        String rank = request.getParameter("c-rank");
        String address = request.getParameter("c-address");
        String tel = request.getParameter("c-tel");
        String email = request.getParameter("c-email");
        //创建客户
        user us=new user();
        us.setU_name(username);
        us.setContact_name(contact);
        us.setU_level(rank);
        us.setAddress(address);
        us.setPhone(tel);
        us.setEmail(email);
        us.setU_id(tel);
        urepository.save(us);
        
        return "redirect:/sale-user";
    }
    
    @RequestMapping("/sale-change-user")
    public String saleChangeUser(HttpServletRequest request){
        String id = request.getParameter("ch-user-id");
        String username =request.getParameter("ch-username");
        String contact = request.getParameter("ch-contect");
        String rank = request.getParameter("ch-rank");
        String address = request.getParameter("ch-address");
        String tel = request.getParameter("ch-tel");
        String email = request.getParameter("ch-email");
        //更新客户信息
        System.out.println(id);
        System.out.println(username);
        System.out.println(contact);
        System.out.println(rank);
        System.out.println(address);
        System.out.println(tel);
        System.out.println(email);

        user us=new user();
        us=urepository.getOne(id);
        us.setU_name(username);
        us.setContact_name(contact);
        us.setU_level(rank);
        us.setAddress(address);
        us.setPhone(tel);
        us.setEmail(email);
        urepository.save(us);
        return "redirect:/sale-user";
    }

    @PostMapping("sale-search-user")
    public String saleSearchUser(HttpServletRequest request,Map<String, Object> map){
        String name = request.getParameter("search-name");
        System.out.println(name);
        //查询客户名称为name的客户
        user us=new user();
        us=urepository.getOne(name);
		List<user> list = new ArrayList<user>();
        list.add(us);
        map.put("user", list);
        return "sale-user";
    }
}
