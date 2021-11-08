package edu.lif.xmldb.model.entityDao.daoInterface;


import edu.lif.xmldb.model.entity.Commodity;

import java.util.List;

public interface CommodityDao {

    /**
     * 创建商品
     * @param shopId 所属店铺
     * @param price 商品价格
     * @param category 商品类别
     * @param storeNum 商品库存
     * @param cname 商品名称
     * @param description 商品描述
     * @return 商品详情
     */
    Commodity create(String shopId, String price, String category, String storeNum, String cname, String description);

    /**
     * 存储到数据库中
     */
    void addToDb();

    /**
     * 根据Id回去商品信息
     * @param commodityId id
     */
    Commodity getByCommodityId(String commodityId);

    /**
     * 根据商品Id删除商品
     * @param commodityId 商品Id
     */
    void deleteById(String commodityId);

    /**
     * 获取所有商品
     * @return 数据库中商品集
     */
    List<Commodity> getAll();

    /**
     * 根据类别获取所有商品
     * @param category 商品类别，需要约定类别，一般不要使用中文名字
     * @return 该类别的所有商品
     */
    List<Commodity> getAllByCategory(String category);

    /**
     * 获取商铺的所有商品
     * @param shopId 店铺Id
     * @return 该商铺的所有商品
     */
    List<Commodity> getAllByShopId(String shopId);

    /**
     * 获取店铺中该类别的所有商品
     * @param shopId 店铺id
     * @param category 商品类别
     * @return 店铺类别商品集
     */
    List<Commodity> getAllByShopIdAndCategory(String shopId, String category);
}
