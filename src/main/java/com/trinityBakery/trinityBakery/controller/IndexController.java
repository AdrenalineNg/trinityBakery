package com.trinityBakery.trinityBakery.controller;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.ServletInputStream;
import java.io.IOException;
import java.util.Map;

@Controller
@RequestMapping(value = {"/", "/login"})
public class IndexController {
    @RequestMapping(method = RequestMethod.GET)
    String get() {
        return "login";
    }

    @RequestMapping(method = RequestMethod.POST)
    String post(HttpServletRequest request, Map<String, Object> map) {
        String password = request.getParameter("password");
        String account = request.getParameter("account");
        System.out.println("password is:" + password);
        if (!StringUtils.isEmpty(account)) {
            //登陆成功
            if ("user".equals(password)) {
                return "redirect:/shopping";
            } else if ("sale".equals(password)) {
                return "redirect:/sale";
            } else if ("account".equals(password)) {
                return "redirect:/finance-account";
            } else if ("cashier".equals(password)) {
                return "redirect:/finance-cashier";
            } else if ("pps".equals(password)) {
                return "redirect:pps";
            } else if ("fpl".equals(password)) {
                return "redirect:/finishedProducLibrary";
            } else if ("boss".equals(password)) {
                return "redirect:/boss/boss";
            } else if ("admin".equals(password)) {
                return "redirect:/admin/index";
            } else if ("production".equals(password)) {
                return "redirect:/production/work";
            } else return "login";
        } else {
            //登陆失败
            map.put("msg", "用户名密码错误");
            return "login";
        }

    }
}