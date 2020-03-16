package com.trinityBakery.trinityBakery.controller;



import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.trinityBakery.trinityBakery.dao.detailRepository;
import com.trinityBakery.trinityBakery.dao.goodRepository;
import com.trinityBakery.trinityBakery.dao.orderRepository;
import com.trinityBakery.trinityBakery.dao.refundRepository;
import com.trinityBakery.trinityBakery.dao.shoppingcartRepository;
import com.trinityBakery.trinityBakery.model.detail;
import com.trinityBakery.trinityBakery.model.good;
import com.trinityBakery.trinityBakery.model.order;
import com.trinityBakery.trinityBakery.model.refund;
import com.trinityBakery.trinityBakery.model.shoppingcart;



@Controller
public class userController {
	@Autowired
	private goodRepository goodrepository;
	@Autowired
	private shoppingcartRepository srepository;
	@Autowired
	private orderRepository orepository;
	@Autowired
	private refundRepository rrepository;
	@Autowired
	private detailRepository drepository;

    @RequestMapping(value = "/shopping",method = RequestMethod.GET)
    public String shoppingxianshi(Map<String, Object> map) {
        List<good> list = new ArrayList<good>();
        list = goodrepository.findAll();
        map.put("production", list);
        return "shopping";
    }
    
//    @RequestMapping(value = "/shoppingcart",method = RequestMethod.GET)    
//    public List<shoppingcart> shoppingcart(Map<String, Object> map) {
//    	List<shoppingcart> list = new ArrayList<shoppingcart>();
//        list = srepository.findAll();
//        map.put("shoppingcart", list);
//        return list;
//    }
    @RequestMapping(value = "/shoppingcart",method = RequestMethod.GET)    
    public String shoppingcart(Map<String, Object> map) {
    	List<shoppingcart> list = new ArrayList<shoppingcart>();
        list = srepository.findAll();
        map.put("shoppingcart", list);
        return "shoppingcart";
    }
    
    @RequestMapping(value = "/user-order",method = RequestMethod.GET)    
    public String user_order(Map<String, Object> map) {
    	List<order> list = new ArrayList<order>();
        list = orepository.findAll();
        map.put("order", list);
        return "user-order";
    }
//  @RequestMapping(value = "/user-order",method = RequestMethod.GET)    
//  public List<order>order(Map<String, Object> map) {
//  	List<order> list = new ArrayList<order>();
//      list = orepository.findAll();
//      map.put("order", list);
//      return list;
//  }
 
    @RequestMapping(value = "/user-order-detail/{id}",method = RequestMethod.GET)    
    public String user_order_detail(Map<String, Object> map) {
        //通过id 查询订单详情
    	List<detail> list = new ArrayList<detail>();
        list = drepository.findAll();
        map.put("detail", list);
        return "user-order-detail";
    }
    
    @RequestMapping(value = "/user-refund",method = RequestMethod.GET)    
    public String user_refund(Map<String, Object> map) {
    	List<refund> list = new ArrayList<refund>();
        list = rrepository.findAll();
        map.put("refund", list);
        return "user-refund";
    }
    
    @GetMapping("user-refund-detail/{id}")
    public String user_refund_detail(Map<String, Object> map) {
        //通过id 查询退款单详情
    	List<detail> list = new ArrayList<detail>();
        list = drepository.findAll();
        map.put("detail", list);
        return "user-refund-detail";
    }

}