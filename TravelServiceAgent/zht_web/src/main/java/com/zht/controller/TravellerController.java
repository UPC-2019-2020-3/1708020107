package com.zht.controller;

import com.zht.domain.*;
import com.zht.service.iProductService;
import com.zht.service.iTravellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/traveller")
public class TravellerController {

    @Autowired
    private iTravellerService travellerService;

    @RequestMapping("/findAll.do")
    //@RolesAllowed("ADMIN")
    public ModelAndView findAll() throws Exception {
        ModelAndView mv = new ModelAndView();
        List<Traveller> travellers = travellerService.findAll();
        mv.addObject("travellerList", travellers);
        mv.setViewName("traveller-list");
        return mv;
    }

    @RequestMapping("/save.do")
    public String save(Traveller traveller) throws Exception{
        travellerService.save(traveller);
        return "redirect:findAll.do";
    }

    @RequestMapping("/deleteTraveller.do")
    public String deleteProduct(@RequestParam(name="id",required = true) int travellerId) throws Exception {
        travellerService.deleteTravellerById(travellerId);
        return "redirect:findAll.do";
    }

}
