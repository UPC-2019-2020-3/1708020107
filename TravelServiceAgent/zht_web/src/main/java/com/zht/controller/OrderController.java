package com.zht.controller;


import com.github.pagehelper.PageInfo;
import com.zht.domain.*;
import com.zht.service.iOrdersService;
import com.zht.service.iRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private iOrdersService ordersService;

    @RequestMapping("/findAll.do")
    public ModelAndView findAll(@RequestParam(name = "page", defaultValue = "1") int pageNum, @RequestParam(name = "size",defaultValue = "20") int pageSize) throws Exception {
        ModelAndView mv = new ModelAndView();
        List<Orders> ordersList = ordersService.findAll(pageNum, pageSize);
        PageInfo pageInfo = new PageInfo(ordersList);
        mv.addObject("pageInfo", pageInfo);
        mv.setViewName("orders-list");
        return mv;
    }

    @RequestMapping("/findById.do")
    public ModelAndView findById(@RequestParam(name = "id", required = true) int ordersId) throws Exception
    {
        ModelAndView mv = new ModelAndView();
        Orders orders = ordersService.findById(ordersId);
        mv.addObject("orders",orders);
        mv.setViewName("orders-show");
        return mv;
    }

    @RequestMapping("/save.do")
    public String save(Orders orders) throws Exception{
        ordersService.save(orders);
        return "redirect:findAll.do";
    }

    @RequestMapping("/findSpecific.do")
    public ModelAndView findSpecific(@RequestParam(name = "id") int ordersId) throws Exception {
        ModelAndView mv = new ModelAndView();
        Orders orders = ordersService.findById(ordersId);
        List<Traveller> otherTravellers = ordersService.findOtherTravellers(ordersId);
        mv.addObject("orders", orders);
        mv.addObject("travellerList", otherTravellers);
        mv.setViewName("orders-traveller-add");
        return mv;
    }

    @RequestMapping("/addTraveller.do")
    public String addTraveller(@RequestParam(name = "ordersId", required = true) int ordersId, @RequestParam(name = "ids", required = true) int[] travellerIds) throws Exception {
        ordersService.addTraveller(ordersId, travellerIds);
        return "redirect:findAll.do";
    }

    @RequestMapping("/auditOrder.do")
    public String auditOrder(@RequestParam(name = "id") int ordersId) throws Exception{
        ordersService.auditOrder(ordersId);
        return "redirect:findAll.do";
    }

    @RequestMapping("/closeOrder.do")
    public String closeOrder(@RequestParam(name = "id") int ordersId) throws Exception{
        ordersService.closeOrder(ordersId);
        return "redirect:findAll.do";
    }

}
