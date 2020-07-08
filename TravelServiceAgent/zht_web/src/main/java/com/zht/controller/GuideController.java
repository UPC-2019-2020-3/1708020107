package com.zht.controller;

import com.zht.domain.Guide;
import com.zht.domain.Product;
import com.zht.service.iGuideService;
import com.zht.service.iProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/guide")
public class GuideController {

    @Autowired
    private iGuideService guideService;

    @RequestMapping("/findAll.do")
    public ModelAndView findAll() throws Exception {
        ModelAndView mv = new ModelAndView();
        List<Guide> guides = guideService.findAll();
        mv.addObject("guideList", guides);
        mv.setViewName("guide-list");
        return mv;
    }

}
