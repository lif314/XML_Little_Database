package edu.lif.xmldb.model.entityDao.daoImpl;

import edu.lif.xmldb.XMLRepository.ProxyXmlContext;
import edu.lif.xmldb.XMLRepository.XMLContext;
import edu.lif.xmldb.model.entity.Shop;
import edu.lif.xmldb.model.entityDao.daoInterface.ShopDao;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ShopDaoImpl implements ShopDao {

    private final XMLContext<Shop> shopXMLContext = new ProxyXmlContext<>(Shop.class);

    private Shop shop;

    /**
     * 创建店铺
     *
     * @param sellerId    卖家id
     * @param shopName    店铺名称
     * @param creditScore 信誉积分
     * @param category    店铺类别
     * @param description 店铺描述
     * @return a Shop
     */
    @Override
    public Shop create(String sellerId, String shopName, String creditScore, String category,String shopAddress, String description) {

        String shopId = UUID.randomUUID().toString();
        shop = new Shop(shopId, sellerId, shopName, creditScore, category, shopAddress, description);
        return shop;
    }

    /**
     * 存储到数据库中
     */
    @Override
    public void addToDb() {
        shopXMLContext.add(shop);
    }

    /**
     * 通过店铺id获取商铺
     *
     * @param shopId 店铺id
     * @return a Shop
     */
    @Override
    public Shop getById(String shopId) {
        return shopXMLContext.findById(shopId);
    }

    /**
     * 获取所有店铺
     *
     * @return list shop
     */
    @Override
    public List<Shop> getAll() {
        return shopXMLContext.init();
    }

    /**
     * 获取卖家所有店铺
     *
     * @param sellerId 卖家Id
     * @return list shop
     */
    @Override
    public List<Shop> getAllBySellerId(String sellerId) {

        List<Shop> init = shopXMLContext.init();
        List<Shop> res = new ArrayList<>();
        for (Shop shop1 : init) {
            if(shop1.getSellerId().equals(sellerId)){
                res.add(shop1);
            }
        }
        return res;
    }

    /**
     * 删除店铺
     *
     * @param shopId id
     */
    @Override
    public void deleteById(String shopId) {
        shopXMLContext.deleteById(shopId);
    }

    /**
     * 注销卖家所有店铺
     *
     * @param sellerId id
     */
    @Override
    public void deleteAllSellerShops(String sellerId) {
        List<Shop> init = shopXMLContext.init();
        for (Shop s : init) {
            if(s.getSellerId().equals(sellerId)){
                shopXMLContext.deleteById(s.getShopId());
            }
        }
    }
}
