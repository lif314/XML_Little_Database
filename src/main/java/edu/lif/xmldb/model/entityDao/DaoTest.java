package edu.lif.xmldb.model.entityDao;



import edu.lif.xmldb.model.entity.Commodity;
import edu.lif.xmldb.model.entityDao.daoImpl.CommodityDaoImpl;
import edu.lif.xmldb.model.entityDao.daoImpl.OrderDaoImpl;
import edu.lif.xmldb.model.entityDao.daoInterface.CommodityDao;
import edu.lif.xmldb.model.entityDao.daoInterface.OrderDao;
import edu.lif.xmldb.model.logicalEntity.OrderLogic;

import java.util.List;

public class DaoTest {
    public static void main(String[] args) {

//        SellerDao sellerDao = new SellerDaoImpl();
//        Seller seller = sellerDao.create("123456", "lza", "12131433232", "Strange", "15678900876");
//        sellerDao.addToDb();
//
//        ShopDao shopDao = new ShopDaoImpl();
//        Shop shop = shopDao.create(seller.getSellerId(), "LzaShop", "10", "电子", "同济大学嘉定小区", "哈皮");
//        shopDao.addToDb();
//
//        CommodityDao commodityDao = new CommodityDaoImpl();
//        List<Commodity> all = commodityDao.getAll();
//        System.out.println(all);

        OrderDao orderDao = new OrderDaoImpl();
        OrderLogic orderDetail = orderDao.getOrderDetail("900d5849-64a0-4fde-9e06-173fd437ee31");
        System.out.println(orderDetail);
//        Commodity commodity = commodityDao.create(shop.getShopId(), "100", CommodityCategory.SHIRT.name(), "56", "七匹狼", "爱你所爱！");
//        commodityDao.addToDb();
//
//        List<Commodity> all = commodityDao.getAll();
//        for (Commodity commodity1 : all) {
//            System.out.println(commodity1);
//        }
//
//        commodityDao.deleteById(commodity.getCommodityId());
//
//        ActivityDao activityDao = new ActivityDaoImpl();
//        activityDao.create("2021-10-30", "2021-11-11", "双十一", "0.90");
//        activityDao.addToDb();

//        CouponDao couponDao = new CouponDaoImpl();
//        couponDao.create("b3388015-b394-4cae-ab2c-154edd8ab8ea", "2021-10-30","2021-11-11", "100", "10");
//        couponDao.addToDb();
//         SellerDao sellerDao = new SellerDaoImpl();
//         sellerDao.create("123456", "llf", "123234454365645", "XiaoJi", "12345678909");
//         sellerDao.addToDb();

//        Order order = OrderBuilder.newOrderBuilder()
//                .initOrder("buyerId")
//                .setOrderAddress("receiveId")
//                .setPromotion()
//                .setPromotion()
//                .setOrderCommodities()
//                .setOrderPayment()
//                .build();

//
//        FavoriteCommodityDao favoriteCommodityDao = new FavoriteCommodityDaoImpl();
//        favoriteCommodityDao.create("11212", "121212");
//        favoriteCommodityDao.addToDb();

//        OrderDao orderDao = new OrderDaoImpl();
//        List<Order> allByShopId = orderDao.getAllByShopId("b3388015-b394-4cae-ab2c-154edd8ab8ea");
//        System.out.println(allByShopId);

//        BuyerAddressDao buyerAddressDao = new BuyerAddressDaoImpl();
//        buyerAddressDao.create("c481e837-3461-4e11-b68e-361e40b7233a", "llf", "18387400236", "同济大学 嘉定校区");
//        buyerAddressDao.addToDb();
    }
}
