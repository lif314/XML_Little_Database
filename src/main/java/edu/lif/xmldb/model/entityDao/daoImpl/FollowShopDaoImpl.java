package edu.lif.xmldb.model.entityDao.daoImpl;

import edu.lif.xmldb.XMLRepository.ProxyXmlContext;
import edu.lif.xmldb.XMLRepository.XMLContext;
import edu.lif.xmldb.model.entity.FollowShop;
import edu.lif.xmldb.model.entity.Shop;
import edu.lif.xmldb.model.entityDao.daoInterface.FollowShopDao;
import edu.lif.xmldb.model.logicalEntity.FollowShopLogic;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class FollowShopDaoImpl implements FollowShopDao {

    // 店铺关注上下文
    private final XMLContext<FollowShop> followShopXMLContext = new ProxyXmlContext<>(FollowShop.class);

    private static FollowShop followShop;

    /**
     * 关注店铺
     *
     * @param shopId  店铺id
     * @param buyerId 买家id
     * @return 一个简单的关注信息
     */
    @Override
    public FollowShop create(String shopId, String buyerId) {
        // get the current date and time
        LocalDateTime dateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyy-MM-dd HH:mm:ss");
        followShop = new FollowShop(shopId, buyerId, dateTime.format(formatter));
        return followShop;
    }

    /**
     * 存储到数据库中
     */
    @Override
    public void addToDb() {
        followShopXMLContext.add(followShop);
    }

    /**
     * 获取买家关注店铺的详细信息
     *
     * @param buyerId 买家id
     * @return list shop details
     */
    @Override
    public List<FollowShopLogic> getByBuyerId(String buyerId) {

        List<FollowShopLogic> followShopLogicList = new ArrayList<>();
        // 获取购物车联系集所有数据
        List<FollowShop> init = followShopXMLContext.init();
        for (FollowShop fs : init) {
            if(fs.getBuyerId().equals(buyerId)){
                XMLContext<Shop> shopXMLContext = new ProxyXmlContext<>(Shop.class);
                Shop shop = shopXMLContext.findById(fs.getShopId());
                FollowShopLogic followShopLogic = new FollowShopLogic(shop.getShopId(), shop.getShopName(), shop.getCreditScore(), shop.getCategory(), shop.getDescription(), fs.getFollowDate());
                followShopLogicList.add(followShopLogic);
            }
        }
        return followShopLogicList;
    }

    /**
     * 清空店铺关注
     */
    @Override
    public void deleteAll() {
        followShopXMLContext.deleteAll();
    }

    /**
     * 取消关注
     *
     * @param shopId id
     */
    @Override
    public void cancelShopFollow(String shopId, String buyerId) {
        List<FollowShop> init = followShopXMLContext.init();
        followShopXMLContext.deleteAll();
        for (FollowShop shop : init) {
            if(!(shop.getShopId().equals(shopId) && shop.getBuyerId().equals(buyerId))){
                followShopXMLContext.add(shop);
            }
        }
    }


    @Override
    public List<FollowShop> getAllByShopId(String shopId) {
        List<FollowShop> followShopList = new ArrayList<>();
        List<FollowShop> init = followShopXMLContext.init();
        for (FollowShop fs : init) {
            if(fs.getShopId().equals(shopId))
                followShopList.add(fs);
        }
        return followShopList;
    }
}
