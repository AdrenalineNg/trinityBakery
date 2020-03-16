package com.trinityBakery.trinityBakery.controller;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.trinityBakery.trinityBakery.dao.produceplanRepository;
import com.trinityBakery.trinityBakery.dao.tihuoRepository;
import com.trinityBakery.trinityBakery.model.produceplan;
import com.trinityBakery.trinityBakery.model.tihuo;

@Controller
@RequestMapping("/production")
public class ProductionController {
	@Autowired
	private produceplanRepository prepository;

	@RequestMapping(value = "/work",method = RequestMethod.GET) 
    public String productionwork(Map<String, Object> map) {
        //生产车间所能看见的生产计划
		List<produceplan> list = new ArrayList<produceplan>();
        list = prepository.findAll();
        map.put("plan", list);
        return "productionWork";
    }
	


}