package edu.lif.xmldb.model.entityDao.daoImpl;

import edu.lif.xmldb.XMLRepository.ProxyXmlContext;
import edu.lif.xmldb.XMLRepository.XMLContext;
import edu.lif.xmldb.model.entity.Commodity;
import edu.lif.xmldb.model.entityDao.daoInterface.CommodityDao;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class CommodityDaoImpl  implements CommodityDao {

    // 商品数据库上下文
    private final XMLContext<Commodity> commodityXMLContext = new ProxyXmlContext<>(Commodity.class);

    // 商品
    private static Commodity commodity;

    /**
     * 创建商品
     *
     * @param shopId      所属店铺
     * @param price       商品价格
     * @param category    商品类别
     * @param storeNum    商品库存
     * @param cname       商品名称
     * @param description 商品描述
     * @return 商品详情
     */
    @Override
    public Commodity create(String shopId, String price, String category, String storeNum, String cname, String description) {
        UUID commodityId = UUID.randomUUID();
        commodity = new Commodity(commodityId.toString(), shopId, price, category, storeNum, cname, description);
        return commodity;
    }

    /**
     * 存储到数据库中
     */
    @Override
    public void addToDb() {
        commodityXMLContext.add(commodity);
    }

    @Override
    public Commodity getByCommodityId(String commodityId) {
        return commodityXMLContext.findById(commodityId);
    }

    /**
     * 根据商品Id删除商品
     *
     * @param commodityId 商品Id
     */
    @Override
    public void deleteById(String commodityId) {
        commodityXMLContext.deleteById(commodityId);
    }

    /**
     * 获取所有商品
     *
     * @return 数据库中商品集
     */
    @Override
    public List<Commodity> getAll() {
        return commodityXMLContext.init();
    }

    /**
     * 根据类别获取所有商品
     *
     * @param category 商品类别，需要约定类别，一般不要使用中文名字
     * @return 该类别的所有商品
     */
    @Override
    public List<Commodity> getAllByCategory(String category) {

        List<Commodity> all = getAll();
        List<Commodity> commodityListResult = new ArrayList<>();
        for (Commodity c : all) {
            if(c.getCategory().equals(category)){
                commodityListResult.add(c);
            }
        }
        return commodityListResult;
    }

    /**
     * 获取商铺的所有商品
     *
     * @param shopId 店铺Id
     * @return 该商铺的所有商品
     */
    @Override
    public List<Commodity> getAllByShopId(String shopId) {
        List<Commodity> all = commodityXMLContext.init();
        List<Commodity> commodityListResult = new ArrayList<>();
        for (Commodity c : all) {
            if(c.getShopId().equals(shopId)){
                commodityListResult.add(c);
            }
        }
        return commodityListResult;
    }

    /**
     * 获取店铺中该类别的所有商品
     *
     * @param shopId   店铺id
     * @param category 商品类别
     * @return 店铺类别商品集
     */
    @Override
    public List<Commodity> getAllByShopIdAndCategory(String shopId, String category) {
        List<Commodity> all = getAll();
        List<Commodity> commodityListResult = new ArrayList<>();
        for (Commodity c : all) {
            if(c.getShopId().equals(shopId) && c.getCategory().equals(category)){
                commodityListResult.add(c);
            }
        }
        return commodityListResult;
    }
}
