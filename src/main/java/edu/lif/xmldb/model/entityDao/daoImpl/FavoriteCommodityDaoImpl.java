package edu.lif.xmldb.model.entityDao.daoImpl;


import edu.lif.xmldb.XMLRepository.ProxyXmlContext;
import edu.lif.xmldb.XMLRepository.XMLContext;
import edu.lif.xmldb.model.entity.Commodity;
import edu.lif.xmldb.model.entity.FollowCommodity;
import edu.lif.xmldb.model.entityDao.daoInterface.FavoriteCommodityDao;
import edu.lif.xmldb.model.logicalEntity.FollowCommodityLogic;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class FavoriteCommodityDaoImpl implements FavoriteCommodityDao {

    private final XMLContext<FollowCommodity> followCommodityXMLContext = new ProxyXmlContext<>(FollowCommodity.class);

    private static FollowCommodity followCommodity;

    /**
     * 关注商品
     *
     * @param buyerId     买家id
     * @param commodityId 商品id
     * @return a follow commodity
     */
    @Override
    public FollowCommodity create(String buyerId, String commodityId) {
        // get the current date and time
        LocalDateTime dateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyy-MM-dd HH:mm:ss");
        followCommodity = new FollowCommodity(buyerId, commodityId, dateTime.format(formatter));
        return followCommodity;
    }

    /**
     * 存储到数据库中
     */
    @Override
    public void addToDb() {
        followCommodityXMLContext.add(followCommodity);
    }

    /**
     * 获取买家收藏夹的详细信息
     *
     * @param buyerId 买家id
     * @return list commodity details
     */
    @Override
    public List<FollowCommodityLogic> getByBuyerId(String buyerId) {
        List<FollowCommodityLogic> followCommodityLogicList = new ArrayList<>();

        List<FollowCommodity> init = followCommodityXMLContext.init();
        for (FollowCommodity fc : init) {
            if(fc.getBuyerId().equals(buyerId)){
                XMLContext<Commodity> commodityXMLContext = new ProxyXmlContext<>(Commodity.class);
                Commodity c = commodityXMLContext.findById(fc.getCommodityId());
                FollowCommodityLogic followCommodityLogic = new FollowCommodityLogic(c.getCommodityId(), c.getCname(), c.getPrice(), c.getCategory(), c.getDescription(), fc.getFollowDate());
                followCommodityLogicList.add(followCommodityLogic);
            }
        }
        return followCommodityLogicList;
    }

    /**
     * 从收藏夹中移除
     *
     * @param commodityId id
     */
    @Override
    public void cancelFollow(String buyerId , String commodityId) {
        List<FollowCommodity> init = followCommodityXMLContext.init();
        followCommodityXMLContext.deleteAll();
        for (FollowCommodity fc : init) {
            if(!(fc.getCommodityId().equals(commodityId) && fc.getBuyerId().equals(buyerId)) ){
                followCommodityXMLContext.add(fc);
            }
        }
    }

    /**
     * 清除收藏夹
     */
    @Override
    public void deleteByBuyerId(String buyerId) {
        List<FollowCommodity> init = followCommodityXMLContext.init();
        followCommodityXMLContext.deleteAll();
        for (FollowCommodity c : init) {
            if(!c.getBuyerId().equals(buyerId)){
                followCommodityXMLContext.add(c);
            }
        }
    }
}
