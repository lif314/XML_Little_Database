package edu.lif.xmldb.model.entityDao.daoImpl;


import edu.lif.xmldb.XMLRepository.ProxyXmlContext;
import edu.lif.xmldb.XMLRepository.XMLContext;
import edu.lif.xmldb.model.entity.Coupon;
import edu.lif.xmldb.model.entityDao.daoInterface.CouponDao;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class CouponDaoImpl implements CouponDao {

    private final XMLContext<Coupon> couponXMLContext = new ProxyXmlContext<>(Coupon.class);

    private static  Coupon coupon;

    /**
     * 发布优惠券
     *
     * @param startTime 开始时间
     * @param endTime   结束时间
     * @param full      满多少
     * @param minus     减多少
     * @return a coupon
     */
    @Override
    public Coupon create(String shopId , String startTime, String endTime, String full, String minus) {
        String couponId = UUID.randomUUID().toString();
        coupon = new Coupon(couponId, shopId, startTime, endTime, full, minus);
        return coupon;
    }

    /**
     * 存储到数据库中
     */
    @Override
    public void addToDb() {
        couponXMLContext.add(coupon);
    }

    /**
     * 查找优惠券
     *
     * @param couponId 优惠券id
     * @return a coupon
     */
    @Override
    public Coupon getById(String couponId) {
        return couponXMLContext.findById(couponId);
    }

    /**
     * 获取所有优惠券
     *
     * @return list coupon
     */
    @Override
    public List<Coupon> getAll() {
        return couponXMLContext.init();
    }

    /**
     * 删除优惠券
     *
     * @param couponId id
     */
    @Override
    public void deleteById(String couponId) {
        couponXMLContext.deleteById(couponId);
    }

    /**
     * 获取店铺所有优惠券
     *
     * @param shopId id
     */
    @Override
    public List<Coupon> getAllByShopId(String shopId) {
        List<Coupon> init = couponXMLContext.init();
        List<Coupon> couponList = new ArrayList<>();
        for (Coupon c : init) {
            if(c.getShopId().equals(shopId))
                couponList.add(c);
        }
        return couponList;
    }

    /**
     * 删除店铺所有优惠券
     *
     * @param shopId id
     */
    @Override
    public void deleteByShopId(String shopId) {
        List<Coupon> init = couponXMLContext.init();
        couponXMLContext.deleteAll();
        for (Coupon c : init) {
            if(! c.getShopId().equals(shopId)){
                couponXMLContext.add(c);
            }
        }
    }
}
