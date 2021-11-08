package edu.lif.xmldb.XMLRepository.test;



public class XMLContextTest {

    public static void main(String[] args) {

        // 订单XML数据库上下文，你可以通过对订单数据进行操作
//        XMLContext<OrderTest> xmlContext = new ProxyXmlContext<>(OrderTest.class);
//
//        OrderTest order1 = new OrderTest();
//        order1.setOrderTestId("00001");
//        order1.setAddressId("00001");
//        order1.setBuyerId("00001");
//        order1.setShopId("00001");
//        order1.setOrderAmount("3");
//        order1.setCreateDate("2021-10-21");
//        order1.setStatus("已签收");
//
//        OrderTest order2 = new OrderTest("00002", "00002", "00002", "00002", "2021-10-22", "已发送", "2");
//
//        // add test
//        xmlContext.add(order1, order2);
//
//        // findById test
//        System.out.println("============ findById Test ============");
//        OrderTest orderFindById = xmlContext.findById("00002");
//        System.out.println(orderFindById.toString());
//
//
//        // init test
//        System.out.println("============ init Test ============");
//        List<OrderTest> orderList = xmlContext.init();
//        for (OrderTest orderTest : orderList) {
//            System.out.println(orderTest.toString());
//        }
//
//
//        // deleteById test
//        System.out.println("============ deleteById Test ============");
//        xmlContext.deleteById("00001");
//        List<OrderTest> orderListAfterDelete = xmlContext.init();
//        for (OrderTest order : orderListAfterDelete) {
//            System.out.println(order.toString());
//        }
//
//        // sava test
//        xmlContext.save(order1, order2);

        // deleteAll test
//        xmlContext.deleteAll();

//        XMLContext<BuyerAddress> buyerAddressXMLContext = new ProxyXmlContext<>(BuyerAddress.class);
//        String id = UUID.randomUUID().toString();
//        BuyerAddress buyerAddress = new BuyerAddress(id, "c481e837-3461-4e11-b68e-361e40b7233a", "李林飞", "1343554231212", "同济大学 嘉定校区");
//        buyerAddressXMLContext.add(buyerAddress);


//        XMLContext<Commodity> commodityXMLContext = new ProxyXmlContext<>(Commodity.class);
//        Commodity byId = commodityXMLContext.findById("1f7c3228-0daf-45fd-ab8b-777583c3a8b7");
//        System.out.println(byId);
    }

}
