package com.trinityBakery.trinityBakery.controller;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.trinityBakery.trinityBakery.dao.detailRepository;
import com.trinityBakery.trinityBakery.dao.orderRepository;
import com.trinityBakery.trinityBakery.dao.produceplanRepository;
import com.trinityBakery.trinityBakery.dao.refundRepository;
import com.trinityBakery.trinityBakery.dao.storageRepository;
import com.trinityBakery.trinityBakery.model.order;
import com.trinityBakery.trinityBakery.model.produceplan;
import com.trinityBakery.trinityBakery.model.refund;
import com.trinityBakery.trinityBakery.model.storage;


@Controller
@RequestMapping("/boss")
public class bossController {
	@Autowired
	private orderRepository orepository;
	@Autowired
	private refundRepository rrepository;
	@Autowired
	private storageRepository srepository;
	@Autowired
	private produceplanRepository prepository;

    @GetMapping("/boss")
    public String boss(Map<String, Object> map) {
    	List<order> list = new ArrayList<order>();
        list = orepository.findAll();
        map.put("order", list);
        return "boss";
    }
    
    @GetMapping("/plan")
    public String plan(Map<String, Object> map) {
    	List<produceplan> list = new ArrayList<produceplan>();
        list = prepository.findAll();
        map.put("plan", list);
        return "boss-plan";
    }
    
    @GetMapping("/refund")
    public String refund(Map<String, Object> map) {
    	List<refund> list = new ArrayList<refund>();
        list = rrepository.findAll();
        map.put("refund", list);
        return "boss-refund";
    }
    
    @GetMapping("/restorhouse")
    public String restorhouse(Map<String, Object> map) {
    	List<storage> list = new ArrayList<storage>();
        list = srepository.findAll();
        map.put("storage", list);
        return "boss-restorhouse";
    }


}
