package com.trinityBakery.trinityBakery.controller;

import java.util.ArrayList;
import java.util.List;

import com.trinityBakery.trinityBakery.dao.*;
import com.trinityBakery.trinityBakery.model.*;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value = "/ajax")
public class AjaxController {

	@Autowired
    private adminRepository aRepository;
	@Autowired
    private goodRepository gRepository;
	@Autowired
    private shoppingcartRepository rRepository;
	@Autowired
    private orderRepository oRepository;
	@Autowired
    private detailRepository dRepository;
    @Autowired
    private refundRepository rrepository;

    @RequestMapping(value = "/createAdmin", method = RequestMethod.POST)
    @ResponseBody
    public String createAdmin(HttpServletRequest request){
        //从前端获取数据 名字，电话，邮箱，部门
        String name = request.getParameter("name");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String pro = request.getParameter("pro");
        String re = " <tr>\n" +
                "                    <td>"+ name +"</td>\n" +
                "                    <td>"+phone+"</td>\n" +
                "                    <td>"+ pro +"</td>\n" +
                "                    <td>"+ phone +"</td>\n" +
                "                    <td>"+ email +"</td>\n" +
                "                    <td>\n" +
                "                        <a href=\"#\" data-toggle=\"modal\" data-target=\"#changeAdmin\" onclick=\"showAdmin(this)\">修改</a>\n" +
                "                        <a href=\"#\" onclick=\"delAdmin(this)\">删除</a>\n" +
                "                    </td>\n" +
                "                </tr>";

        admin a = new admin();
        a.setA_name(name);
        a.setA_email(email);
        a.setA_id(phone);
        a.setA_department(pro);
        a.setA_tel(phone);
        aRepository.save(a);
        return re;
    }


    @PostMapping("/delAdmin")
    public String delAdmin(HttpServletRequest request){
        String account = request.getParameter("account");
        //根据账户删除admin
        //成功返回 success，失败返回error
        try {
            aRepository.deleteById(account);
        }
        catch(Exception e) {
       	return "error";
        }
        return "success";
    }

    @PostMapping("/changeAdmin")
    public String changeAdmin(HttpServletRequest request){
        String account = request.getParameter("account");
        String name = request.getParameter("name");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String pro = request.getParameter("pro");
        //根据账户修改admin
        //成功返回 success，失败返回error
        admin a = new admin();
        a.setA_name(name);
        a.setA_email(email);
        a.setA_id(account);
        a.setA_department(pro);
        a.setA_tel(phone);
        try {
        	 aRepository.save(a);
        }
        catch(Exception e) {
        	return "error";
        }
        return "success";
    }

    @PostMapping("/addNumber")
    public String addNmber(HttpServletRequest request){
        String id = request.getParameter("id");
        // 购物车商品id为id的 数量加一
        shoppingcart sc=new shoppingcart();
        sc=rRepository.getOne(id);
        int num=sc.getC_num();
        float money=sc.getC_money();
        float price=sc.getC_price();
        num++;
        money=price*num;
        sc.setC_num(num);
        sc.setC_money(money);
        try {
        	rRepository.save(sc);
        }
        catch(Exception e) {
       	return "error";
        }
        return "success";
    }

    @PostMapping("/reduceNumber")
    public String reduceNumber(HttpServletRequest request){
        String id = request.getParameter("id");
        // 购物车商品id为id的 数量减一
        //数量为零时删除购物车内该商品
        shoppingcart sc=new shoppingcart();
        sc=rRepository.getOne(id);
        int num=sc.getC_num();
        float money=sc.getC_money();
        float price=sc.getC_price();
        num--;

        money=price*num;
        sc.setC_num(num);
        sc.setC_money(money);
        try {
        	rRepository.save(sc);
            if(num==0) {
            	rRepository.delete(sc);
            }
        }
        catch(Exception e) {
       	return "error";
        }
        return "success";
    }
    
    
    @PostMapping("/confirmCart")
    public String confirmCart(HttpServletRequest request){
        String money = request.getParameter("money");
        String address = request.getParameter("address");
        //将购物车id为id的表改为订单
        //删除购物车表单       
        order od=new order();
        od.setOrder_id("20180003");
        od.setAddress(address);
        od.setChuku_fahuo("未出库");
        od.setIs_confirm("未审核");
        od.setIs_paid("未付款");
        float total=Float.parseFloat(money);
        od.setTotalprice(total);
        oRepository.save(od);
    	List<shoppingcart> sc=new ArrayList<shoppingcart>();
    	sc = rRepository.findAll();
    	List<detail>dt =new ArrayList<detail>();
        try {
        	for(shoppingcart eachsc:sc) {
        		detail d=new detail();
        		BeanUtils.copyProperties(eachsc,d);
        		dt.add(d);
        	}
        	dRepository.saveAll(dt);
        	rRepository.deleteAll();
        	
        }
        catch(Exception e) {
        	return "error";
        }
        return "success";
    }
    
    @PostMapping("/addCart")
    public String addCart(HttpServletRequest request){
        String id = request.getParameter("id");
        String number = request.getParameter("number");
        int num=Integer.parseInt(number);
        //将商品id为id的加入购物车
        //数量为number
        shoppingcart sc=new shoppingcart();
        good gd=new good();
        gd=gRepository.getOne(id);
        sc.setC_id(id);
        sc.setC_img(gd.getG_img());
        sc.setC_name(gd.getG_name());
        sc.setC_price(gd.getG_price());
        sc.setC_weight(gd.getG_weight());
        sc.setC_num(num);
        float price=sc.getC_price();
        float money=num*price;
        sc.setC_money(money);
        try {
        	rRepository.save(sc);
        }
        catch(Exception e) {
       	return "error";
        }
        return "success";
    }

    @PostMapping("/cashier-confirm-order")
    public String cashierConfirmOrder(HttpServletRequest request){
        String id = request.getParameter("id");
        System.out.println(id);
        //出纳改变订单付款状态
        order od=new order();
        od=oRepository.getOne(id);
        od.setIs_paid("已付款");
        oRepository.save(od);
        return "success";
    }

    @RequestMapping("/cashier-confirm-refound")
    public String cashierConfirmRefound(HttpServletRequest request){
        String id = request.getParameter("id");
        System.out.println(id);
        //出纳更改订单的退款状态
        refund rf=new refund();
        rf=rrepository.getOne(id);
        rf.setIs_paid("已退款");
        rrepository.save(rf);

        return "success";
    }

}
