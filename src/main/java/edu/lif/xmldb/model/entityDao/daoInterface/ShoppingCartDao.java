package edu.lif.xmldb.model.entityDao.daoInterface;


import edu.lif.xmldb.model.entity.ShoppingCart;
import edu.lif.xmldb.model.logicalEntity.ShoppingCartLogic;

import java.util.List;

/**
 * 购物车
 */
public interface ShoppingCartDao {

    /**
     * 添加商品到购物车
     * @param buyerId 买家id
     * @param commodityId 商品id
     * @return 购物车简介
     */
    ShoppingCart create(String buyerId, String commodityId, String amount);

    /**
     * 存储到数据库中
     */
    void addToDb();

    /**
     * 获取用户的购物车详情
     * @param buyerId 买家id
     * @return list ShoppingCartLogic
     */
    List<ShoppingCartLogic> getCartByBuyerId(String buyerId);

    /**
     * 清空购物车
     */
    void deleteAll();

    /**
     * 清除购物车中一件商品
     * @param commodityId id
     */
    void deleteOne(String buyerId ,String commodityId);

    /**
     * 更改购物车中商品数量
     * @param commodityId 商品id
     * @param newAmount 商品数量
     */
    void updateCommodityAmount(String buyerId, String commodityId ,String newAmount);

}