package com.trinityBakery.trinityBakery.controller;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.trinityBakery.trinityBakery.dao.adminRepository;
import com.trinityBakery.trinityBakery.model.admin;



@Controller
@RequestMapping(value = "/admin")
public class adminController {

	@Autowired
    private adminRepository aRepository;
    @RequestMapping(value = "/index",method = RequestMethod.GET)
    public String finishedProducLibrary(Map<String, Object> map) {
        List<admin> list = new ArrayList<admin>();
        list = aRepository.findAll();
        map.put("admin", list);
        return "Admin";
    }



}