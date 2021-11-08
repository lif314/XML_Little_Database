package edu.lif.xmldb.model.entityDao.daoInterface;


import edu.lif.xmldb.model.entity.FollowShop;
import edu.lif.xmldb.model.logicalEntity.FollowShopLogic;

import java.util.List;

/**
 * 关注店铺
 */
public interface FollowShopDao {

    /**
     * 关注店铺
     * @param shopId 店铺id
     * @param buyerId 买家id
     * @return 一个简单的关注信息
     */
    FollowShop create(String shopId, String buyerId);

    /**
     * 存储到数据库中
     */
    void addToDb();

    /**
     * 获取买家关注店铺的详细信息
     * @param buyerId 买家id
     * @return list shop details
     */
    List<FollowShopLogic> getByBuyerId(String buyerId);

    /**
     * 清空店铺关注
     */
    void deleteAll();

    /**
     * 取消关注
     * @param shopId id
     */
    void cancelShopFollow(String shopId, String buyerId);

    /**
     * 获取店铺的关注数据
     * @param shopId id
     * @return list
     */
    List<FollowShop> getAllByShopId(String shopId);
}
