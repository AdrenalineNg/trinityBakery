package com.trinityBakery.trinityBakery.controller;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.trinityBakery.trinityBakery.dao.detailRepository;
import com.trinityBakery.trinityBakery.dao.orderRepository;
import com.trinityBakery.trinityBakery.dao.produceplanRepository;
import com.trinityBakery.trinityBakery.dao.storageRepository;
import com.trinityBakery.trinityBakery.model.detail;
import com.trinityBakery.trinityBakery.model.order;
import com.trinityBakery.trinityBakery.model.produceplan;
import com.trinityBakery.trinityBakery.model.storage;

@Controller
public class ProductionPlanningSectionController {
	
	@Autowired
	private orderRepository orepository;
	@Autowired
	private detailRepository drepository;
	@Autowired
	private storageRepository srepository;
	@Autowired
	private produceplanRepository prepository;
	
    @GetMapping("pps")
    public String ProductionPlanningSection(Map<String, Object> map) {
        //返回生产计划科订单列表
    	List<order> list = new ArrayList<order>();
        list = orepository.findAll();
        map.put("order", list);
        return "ProductionPlanningSection";
    }


    @GetMapping("/pps-order-view/{id}")
    public String ppsOrderDetail(Map<String, Object> map){
        //订单详情
        List<detail> list = new ArrayList<detail>();
        list = drepository.findAll();
        map.put("detail", list);
        return "pps-order-detail";
    }
    
    @GetMapping("pps-plan")
    public String pps_plan(Map<String, Object> map) {
        //显示计划列表
    	List<produceplan> list = new ArrayList<produceplan>();
        list = prepository.findAll();
        map.put("plan", list);
        return "pps-plan";
    }
    
    @RequestMapping("/create-plan")
    public String createPlan(HttpServletRequest request){
        String name = request.getParameter("name");
        String num = request.getParameter("num");
        String date = request.getParameter("date");
        //创建生产计划
        int quantity= Integer.parseInt(num);
        produceplan plan=new produceplan();
        plan.setP_id("4");
        plan.setP_name(name);
        plan.setQuantity(quantity);
        plan.setP_date(date);
        prepository.save(plan);
        return "redirect:/pps-plan";
    }
    
    //有问题
    @RequestMapping("/change-plan")
    public String changePlan(HttpServletRequest request){
        String name = request.getParameter("c-name");
        String num = request.getParameter("c-num");
        String date = request.getParameter("c-date");
        String id = request.getParameter("p-id");
        //修改生产计划
        int quantity= Integer.parseInt(num);
        produceplan plan=new produceplan();
        plan =prepository.getOne(id);
        plan.setP_name(name);
        plan.setQuantity(quantity);
        plan.setP_date(date);
        prepository.save(plan);
        
        return "redirect:/pps-plan";
    }

    @RequestMapping("/del-plan/{id}")
    public String delPlan(@PathVariable("id") String id){
        //删除编号为id的plan
        prepository.deleteById(id);
        return "redirect:/pps-plan";
    }
    

    @RequestMapping("pps-restorhous")
    public String pps_restorhous(Map<String, Object> map) {
    	List<storage> list = new ArrayList<storage>();
        list = srepository.findAll();
        map.put("storage", list);
        return "pps-restorhous";
    }
    
}