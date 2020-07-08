package com.zht.controller;

import com.github.pagehelper.PageInfo;
import com.zht.domain.Orders;
import com.zht.domain.Product;
import com.zht.domain.Traveller;
import com.zht.service.iProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.security.RolesAllowed;
import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private iProductService productService;

    //查询全部产品
    @RequestMapping("/findAll.do")
    //@RolesAllowed("ADMIN")
    public ModelAndView findAll() throws Exception {
        ModelAndView mv = new ModelAndView();
        List<Product> products = productService.findAll();
        mv.addObject("productList", products);
        mv.setViewName("product-list");
        return mv;
    }

    @RequestMapping("/findById.do")
    public ModelAndView findById(@RequestParam(name = "id", required = true) int productId) throws Exception
    {
        ModelAndView mv = new ModelAndView();
        Product product = productService.findById(productId);
        mv.addObject("product",product);
        mv.setViewName("product-show");
        return mv;
    }

    //添加产品
    @RequestMapping("/save.do")
    public String save(Product product) throws Exception{
        productService.save(product);
        return "redirect:findAll.do";
    }

    @RequestMapping("/deleteProduct.do")
    public String deleteProduct(@RequestParam(name="id",required = true) int productId) throws Exception {
        productService.deleteProductById(productId);
        return "redirect:findAll.do";
    }

    @RequestMapping("/deleteProducts.do")
    public String deleteProducts(@RequestParam(name = "ids", required = true) int[] productIds) throws Exception {
        productService.deleteProducts(productIds);
        return "redirect:findAll.do";
    }

    @RequestMapping("/addReturnPage.do")
    public ModelAndView addReturnPage(@RequestParam(name = "id", required = true) int ordersId) throws Exception {
        ModelAndView mv = new ModelAndView();
        mv.addObject("ordersId", ordersId);
        mv.setViewName("product-return-add");
        return mv;
    }

    @RequestMapping("/addReturn.do")
    public String addReturn(@RequestParam(name = "ordersId", required = true) int orderId,@RequestParam(name = "productReturn", required = true) String productReturn) throws Exception {
        productService.addReturn(orderId,productReturn);
        return "redirect:findAll.do";
    }

    @RequestMapping("/openProduct.do")
    public String openProduct(@RequestParam(name="id",required = true) int productId) throws Exception {
        productService.openProductById(productId);
        return "redirect:findAll.do";
    }

}
