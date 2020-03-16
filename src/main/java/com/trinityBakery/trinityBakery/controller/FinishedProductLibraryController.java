package com.trinityBakery.trinityBakery.controller;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.trinityBakery.trinityBakery.dao.goodRepository;
import com.trinityBakery.trinityBakery.dao.storageRepository;
import com.trinityBakery.trinityBakery.dao.tihuoRepository;
import com.trinityBakery.trinityBakery.model.detail;
import com.trinityBakery.trinityBakery.model.order;
import com.trinityBakery.trinityBakery.model.storage;
import com.trinityBakery.trinityBakery.model.tihuo;


@Controller
public class FinishedProductLibraryController {
	@Autowired
	private tihuoRepository trepository;
	@Autowired
	private storageRepository srepository;

	@RequestMapping(value = "/finishedProducLibrary",method = RequestMethod.GET) 
    public String finishedProducLibrary(Map<String, Object> map) {
		List<tihuo> list = new ArrayList<tihuo>();
        list = trepository.findAll();
        map.put("tihuo", list);
        return "finishedProducLibrary";
    }
    

    @GetMapping("storehouse")
    public String storehouse(Map<String, Object> map) {
    	List<storage> list = new ArrayList<storage>();
        list = srepository.findAll();
        map.put("storage", list);
        return "storehouse";
    }

    @RequestMapping("/fpl-change/{id}")
    public String fplChange(@PathVariable("id") String id){
    	tihuo th=new tihuo();
    	th=trepository.getOne(id);
    	th.setTihuo("已提货");
        try {
        	trepository.save(th);
        }
        catch(Exception e) {
       	    return "error";
        }
        return "redirect:/finishedProducLibrary";
    }

    @RequestMapping("/fpl-del/{id}")
    public String fplDel(@PathVariable("id") String id){
        System.out.print(id);
        //删除id为id的库存
        storage st=new storage();
        st=srepository.getOne(id);
        srepository.delete(st);
        return "redirect:/storehouse";
    }
}