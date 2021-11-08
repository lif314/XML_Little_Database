package edu.lif.xmldb.model.entityDao.daoImpl;



import edu.lif.xmldb.XMLRepository.ProxyXmlContext;
import edu.lif.xmldb.XMLRepository.XMLContext;
import edu.lif.xmldb.model.entity.*;
import edu.lif.xmldb.model.logicalEntity.OrderCommodityLogic;
import edu.lif.xmldb.model.logicalEntity.OrderLogic;

import java.util.ArrayList;
import java.util.List;

public class OrderLogicBuilder {

    /**
     * 展示order详情
     */
    private static OrderLogic orderLogic;

    private static String orderId;

    private static String shopId;

    /**
     * 单例模式：
     * 不让使用者使用new创建构造器
     */
    private OrderLogicBuilder(){
    }

    /**
     * 建造者模式的入口
     * @return orderBuilder, 提供链式调用
     */
    public static OrderLogicBuilder getOrderBuilderInstance(){
        return new OrderLogicBuilder();
    }

    /**
     * 初始订单信息
     * @param oId 订单id
     * @return this
     */
    public OrderLogicBuilder initOrderLogicBuilder(String oId){
        XMLContext<Order> orderXMLContext = new ProxyXmlContext<>(Order.class);
        orderId = oId;
        orderLogic = new OrderLogic();
        Order order = orderXMLContext.findById(oId);
        orderLogic.setOrderId(order.getOrderId());
        orderLogic.setBuyerId(order.getBuyerId());
        orderLogic.setOrderPaymentId(order.getOrderPaymentId());
        orderLogic.setBuyerAddressId(order.getBuyerAddressId());
        orderLogic.setCreateTime(order.getCreateTime());
        orderLogic.setStatus(order.getStatus());
        return this;
    }

    /**
     * 添加商品集
     * @return this
     */
    public OrderLogicBuilder setOrderCommodities(){


        XMLContext<OrderCommodity> orderCommodityXMLContext = new ProxyXmlContext<>(OrderCommodity.class);
        List<OrderCommodity> init = orderCommodityXMLContext.init();
        // 获取店铺信息
        XMLContext<Commodity> commodityXMLContext = new ProxyXmlContext<>(Commodity.class);
        shopId = commodityXMLContext.findById(init.get(0).getCommodityId()).getShopId();

        List<OrderCommodityLogic> orderCommodityLogics = new ArrayList<>();
        for (OrderCommodity oc : init) {
            if(oc.getOrderId().equals(orderId)){
                Commodity c = commodityXMLContext.findById(oc.getCommodityId());
                OrderCommodityLogic orderCommodityLogic = new OrderCommodityLogic(oc.getCommodityId(),c.getCname(), c.getPrice(), oc.getAmount());
                orderCommodityLogics.add(orderCommodityLogic);
            }
        }
        orderLogic.setCommodityList(orderCommodityLogics);
        return this;
    }

    /**
     * 查询订单店铺信息
     * @return this
     */
    public OrderLogicBuilder setShopInfo(){
        XMLContext<Shop> shopXMLContext = new ProxyXmlContext<>(Shop.class);
        Shop shop = shopXMLContext.findById(shopId);
        orderLogic.setShopId(shopId);
        orderLogic.setShopName(shop.getShopName());
        orderLogic.setShopAddress(shop.getShopAddress());
        return this;
    }

    /**
     * 添加订单促销信息
     * @return this
     */
    public OrderLogicBuilder setOrderPromotions(){
        XMLContext<OrderPromotion> orderPromotionXMLContext = new ProxyXmlContext<>(OrderPromotion.class);
        List<OrderPromotion> init = orderPromotionXMLContext.init();
        for (OrderPromotion promotion : init) {
            if(promotion.getOrderId().equals(orderId)){
                if(promotion.getType().equals("activity")){
                    orderLogic.setActivityId(promotion.getPromotionId());
                }
                if(promotion.getType().equals("coupon")){
                    orderLogic.setCouponId(promotion.getPromotionId());
                }
            }
        }
        return this;
    }


    /**
     * 添加收获信息
     * @return this
     */
    public OrderLogicBuilder setOrderAddress(){
        XMLContext<BuyerAddress> buyerAddressXMLContext = new ProxyXmlContext<>(BuyerAddress.class);
        BuyerAddress buyerAddress = buyerAddressXMLContext.findById(orderLogic.getBuyerAddressId());
        orderLogic.setReceiveName(buyerAddress.getReceiveName());
        orderLogic.setReceivePhone(buyerAddress.getReceivePhone());
        orderLogic.setReceiveAddress(buyerAddress.getReceiveAddress());
        return this;
    }

    /**
     * 设置订单支付信息
     * @return orderLogicBuilder 链式调用
     */
    public OrderLogicBuilder setOrderPayment(){
        XMLContext<OrderPayment> orderPaymentXMLContext = new ProxyXmlContext<>(OrderPayment.class);
        OrderPayment orderPayment = orderPaymentXMLContext.findById(orderLogic.getOrderPaymentId());

        orderLogic.setPayMethod(orderPayment.getPayMethod());

        orderLogic.setPayStatus(orderPayment.getPayStatus());
        orderLogic.setTotalMoney(orderPayment.getTotalMoney());
        orderLogic.setPaidMoney(orderPayment.getPaidMoney());
        orderLogic.setPaidTime(orderPayment.getPaidTime());
        double promotionMoney = Double.parseDouble(orderPayment.getTotalMoney()) - Double.parseDouble(orderPayment.getPaidMoney());
        orderLogic.setPromotionMoney(promotionMoney + "");
        return this;
    }

    /**
     * 返回最终构建完成的订单对象的详细信息
     * @return logic order
     */
    public OrderLogic display(){
        // 返回订单逻辑实体
        return orderLogic;
    }
}
