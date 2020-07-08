package com.zht.controller;

import com.zht.domain.Guide;
import com.zht.domain.Hotel;
import com.zht.service.iGuideService;
import com.zht.service.iHotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/hotel")
public class HotelController {

    @Autowired
    private iHotelService hotelService;

    @RequestMapping("/findAll.do")
    public ModelAndView findAll() throws Exception {
        ModelAndView mv = new ModelAndView();
        List<Hotel> hotels = hotelService.findAll();
        mv.addObject("hotelList", hotels);
        mv.setViewName("hotel-list");
        return mv;
    }

}
