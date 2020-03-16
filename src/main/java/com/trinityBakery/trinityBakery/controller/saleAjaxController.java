package com.trinityBakery.trinityBakery.controller;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.trinityBakery.trinityBakery.dao.orderRepository;
import com.trinityBakery.trinityBakery.dao.refundRepository;
import com.trinityBakery.trinityBakery.dao.userRepository;
import com.trinityBakery.trinityBakery.model.order;
import com.trinityBakery.trinityBakery.model.refund;

@RestController
@RequestMapping(value = "/saleAjax")
public class saleAjaxController {
	@Autowired
	private userRepository urepository;
	@Autowired
	private orderRepository orepository;
	@Autowired
	private refundRepository rrepository;
	

    @PostMapping("/salesConfirmOrder")
    public String salesConfirmOrder(HttpServletRequest request){
        String id = request.getParameter("id");
        //根据id更改订单的销售确认状态
        order od=new order();
        od=orepository.getOne("20180003");
        od.setIs_confirm("已审核");
        orepository.save(od);
        return "success";
    }
    
    
    @PostMapping("/salesConfirmRefound")
    public String salesConfirmRefound(HttpServletRequest request){
        String id = request.getParameter("id");
        //更具id更改退款单的销售确认状态
        refund rf=new refund();
        rf=rrepository.getOne("20181001");
        rf.setIs_confirm("已审核");
        rrepository.save(rf);
        return "success";
    }
    
    
    @PostMapping("/delUser")
    public String delUser(HttpServletRequest request){
        String id = request.getParameter("id");
        //根据id删除用户
        urepository.deleteById(id);
        return "success";
    }
}
