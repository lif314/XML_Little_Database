package edu.lif.xmldb.model.entityDao.daoInterface;


import edu.lif.xmldb.model.entity.Shop;

import java.util.List;

public interface ShopDao {

    /**
     * 创建店铺
     * @param sellerId 卖家id
     * @param shopName 店铺名称
     * @param creditScore 信誉积分
     * @param category 店铺类别
     * @param shopAddress 店铺发货地址
     * @param description 店铺描述
     * @return a Shop
     */
    Shop create(String sellerId, String shopName, String creditScore, String category, String shopAddress, String description);

    /**
     * 存储到数据库中
     */
    void addToDb();

    /**
     * 通过店铺id获取商铺
     * @param shopId 店铺id
     * @return a Shop
     */
    Shop getById(String shopId);

    /**
     * 获取所有店铺
     * @return list shop
     */
    List<Shop> getAll();

    /**
     * 获取卖家所有店铺
     * @param sellerId 卖家Id
     * @return list shop
     */
    List<Shop> getAllBySellerId(String sellerId);

    /**
     * 删除店铺
     * @param shopId id
     */
    void deleteById(String shopId);

    /**
     * 注销卖家所有店铺
     * @param sellerId id
     */
    void deleteAllSellerShops(String sellerId);

}
