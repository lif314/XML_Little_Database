package edu.lif.xmldb.model.entityDao.daoInterface;


import edu.lif.xmldb.model.entity.Coupon;

import java.util.List;

public interface CouponDao {

    /**
     * 店铺发布优惠券
     * @param shopId 店铺id
     * @param startTime 开始时间
     * @param endTime 结束时间
     * @param full 满多少
     * @param minus 减多少
     * @return a coupon
     */
    Coupon create(String shopId, String startTime, String endTime, String full, String minus);

    /**
     * 存储到数据库中
     */
    void addToDb();

    /**
     * 查找优惠券
     * @param couponId 优惠券id
     * @return a coupon
     */
    Coupon getById(String couponId);

    /**
     * 获取所有优惠券
     * @return list coupon
     */
    List<Coupon> getAll();

    /**
     * 删除优惠券
     * @param couponId id
     */
    void deleteById(String couponId);

    /**
     * 获取店铺所有优惠券
     * @param shopId id
     */
    List<Coupon> getAllByShopId(String shopId);

    /**
     * 删除店铺所有优惠券
     * @param shopId id
     */
    void deleteByShopId(String shopId);
}
