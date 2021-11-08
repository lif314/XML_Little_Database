package edu.lif.xmldb.model.entityDao.daoImpl;


import edu.lif.xmldb.XMLRepository.ProxyXmlContext;
import edu.lif.xmldb.XMLRepository.XMLContext;
import edu.lif.xmldb.model.entity.Commodity;
import edu.lif.xmldb.model.entity.Order;
import edu.lif.xmldb.model.entity.OrderCommodity;
import edu.lif.xmldb.model.entityDao.daoInterface.OrderDao;
import edu.lif.xmldb.model.logicalEntity.OrderLogic;

import java.util.ArrayList;
import java.util.List;

public class OrderDaoImpl implements OrderDao {

    // 订单上下文
    private final XMLContext<Order> orderXMLContext = new ProxyXmlContext<>(Order.class);

    /**
     * 更改订单状态
     *
     * @param orderId   订单Id
     * @param newStatus 最新状态
     */
    @Override
    public void updateOrderStatus(String orderId, String newStatus) {
        List<Order> init = orderXMLContext.init();
        orderXMLContext.deleteAll();
        for (Order order : init) {
            if(order.getOrderId().equals(orderId)){
                order.setStatus(newStatus);
                orderXMLContext.add(order);
            }
            orderXMLContext.add(order);
        }
    }

    /**
     * 获取买家所有订单
     *
     * @param buyerId id
     * @return list buyer's orders
     */
    @Override
    public List<Order> getAllByBuyerId(String buyerId) {
        List<Order> orderList = new ArrayList<>();
        List<Order> init = orderXMLContext.init();
        for (Order order : init) {
            if(order.getBuyerId().equals(buyerId))
                orderList.add(order);
        }
        return orderList;
    }

    /**
     * 获取订单实体信息
     *
     * @param orderId id
     * @return order
     */
    @Override
    public Order getOrderConcise(String orderId) {
        return orderXMLContext.findById(orderId);
    }

    /**
     * 获取订单详情
     *
     * @param orderId id
     * @return 订单详情
     */
    @Override
    public OrderLogic getOrderDetail(String orderId) {
        return OrderLogicBuilder
                .getOrderBuilderInstance()    // 单例模式，获取示例
                .initOrderLogicBuilder(orderId)  // 初始订单
                .setOrderCommodities()        // 添加商品
                .setOrderPromotions()         // 促销信息
                .setOrderAddress()            // 地址信息
                .setOrderPayment()            // 支付方式
                .display();                   // 集成
    }

    /**
     * 获取店铺所有订单
     * @param shopId id
     * @return list order
     */
    @Override
    public List<Order> getAllByShopId(String shopId) {
        XMLContext<OrderCommodity> orderCommodityXMLContext = new ProxyXmlContext<>(OrderCommodity.class);
        List<OrderCommodity> orderCommodityList = orderCommodityXMLContext.init();

        List<OrderCommodity> newOrder = new ArrayList<>();
        for (OrderCommodity orderCommodity : orderCommodityList) {
            XMLContext<Commodity> commodityXMLContext = new ProxyXmlContext<>(Commodity.class);
            Commodity comm = commodityXMLContext.findById(orderCommodity.getCommodityId());
            if(comm.getShopId().equals(shopId)){
                newOrder.add(orderCommodity);
            }
        }

        List<Order> orderList = new ArrayList<>();
        for (OrderCommodity o : newOrder) {
            XMLContext<Order> orderXMLContext = new ProxyXmlContext<>(Order.class);
            Order byId = orderXMLContext.findById(o.getOrderId());
            orderList.add(byId);
        }

        return orderList;
    }
}
