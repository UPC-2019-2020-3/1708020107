package com.zht.domain;

import com.zht.utils.DateUtils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Orders {

    private String id;
    private String orderNum;    // 订单编号
    private Date orderTime;     // 下单时间
    private String orderTimeStr;
    private int orderStatus;
    private String orderStatusStr;
    private int peopleCount;
    private Product product;
    private int ProductId;
    private List<Traveller> travellers;
    private Member member;
    private Integer payType;
    private String payTypeStr;
    private String orderDesc;
    private int auditStatus;
    private String auditStr;
    private double orderPrice;
    private String startCity;
    private int finalStatus;
    private String finalStatusStr;
    private int writtenStatus;
    private String writtenStatusStr;

    public int getFinalStatus() {
        return finalStatus;
    }

    public void setFinalStatus(int finalStatus) {
        this.finalStatus = finalStatus;
    }

    public String getFinalStatusStr() {
        if(finalStatus==0)
        {
            finalStatusStr = "未开始";
        }
        else if(finalStatus==1)
        {
            finalStatusStr = "正在进行";
        }
        else if(finalStatus==2)
        {
            finalStatusStr = "已结束";
        }
        else if(finalStatus==3)
        {
            finalStatusStr = "/";
        }
        return finalStatusStr;
    }

    public void setFinalStatusStr(String finalStatusStr) {
        this.finalStatusStr = finalStatusStr;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(String orderNum) {
        this.orderNum = orderNum;
    }

    public Date getOrderTime()
    {
        return orderTime;
    }

    public void setOrderTime(Date orderTime)
    {
        this.orderTime = orderTime;
    }

    public String getOrderTimeStr() {
        if(orderTime!=null)
        {
            orderTimeStr = DateUtils.date2String(orderTime,"yyyy-MM-dd HH:mm:ss");
        }
        return orderTimeStr;
    }

    public void setOrderTimeStr(String orderTimeStr) {
        this.orderTimeStr = orderTimeStr;
    }

    public int getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(int orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getOrderStatusStr() {
        if(orderStatus==0)
        {
            orderStatusStr = "未支付";
        }
        else if(orderStatus==1)
        {
            orderStatusStr = "已支付";
        }
        else if(orderStatus==2)
        {
            orderStatusStr = "关闭";
        }
        return orderStatusStr;
    }

    public void setOrderStatusStr(String orderStatusStr) {
        this.orderStatusStr = orderStatusStr;
    }

    public int getPeopleCount() {
        return peopleCount;
    }

    public void setPeopleCount(int peopleCount) {
        this.peopleCount = peopleCount;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getProductId() {
        return ProductId;
    }

    public void setProductId(int productId) {
        ProductId = productId;
    }

    public List<Traveller> getTravellers() {
        return travellers;
    }

    public void setTravellers(List<Traveller> travellers) {
        this.travellers = travellers;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public Integer getPayType() {
        return payType;
    }

    public void setPayType(Integer payType) {
        this.payType = payType;
    }

    public String getPayTypeStr() {
        if(payType==0)
        {
            payTypeStr = "支付宝";
        }
        else if(payType==1)
        {
            payTypeStr = "微信";
        }
        else if(payType==2)
        {
            payTypeStr = "未支付";
        }
        return payTypeStr;
    }

    public void setPayTypeStr(String payTypeStr) {
        this.payTypeStr = payTypeStr;
    }

    public String getOrderDesc() {
        return orderDesc;
    }

    public void setOrderDesc(String orderDesc) {
        this.orderDesc = orderDesc;
    }

    public int getAuditStatus() {
        return auditStatus;
    }

    public void setAuditStatus(int auditStatus) {
        this.auditStatus = auditStatus;
    }

    public String getAuditStr() {
        if(auditStatus==0)
        {
            auditStr = "未审核";
        }
        else if(auditStatus==1)
        {
            auditStr = "已审核";
        }
        else
        {
            auditStr = "/";
        }
        return auditStr;
    }

    public void setAuditStr(String auditStr) {
        this.auditStr = auditStr;
    }

    public double getOrderPrice() {
        return orderPrice;
    }

    public void setOrderPrice(double orderPrice) {
        this.orderPrice = orderPrice;
    }

    public String getStartCity() {
        return startCity;
    }

    public void setStartCity(String startCity) {
        this.startCity = startCity;
    }

    public int getWrittenStatus() {
        return writtenStatus;
    }

    public void setWrittenStatus(int writtenStatus) {
        this.writtenStatus = writtenStatus;
    }

    public String getWrittenStatusStr() {
        if(writtenStatus==0)
        {
            writtenStatusStr = "未填写";
        }
        else if(writtenStatus==1)
        {
            writtenStatusStr = "已填写";
        }
        return writtenStatusStr;
    }

    public void setWrittenStatusStr(String writtenStatusStr) {
        this.writtenStatusStr = writtenStatusStr;
    }
}
