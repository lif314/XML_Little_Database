package edu.lif.xmldb.model.entityDao.daoInterface;

import edu.lif.xmldb.model.entity.Activity;

import java.util.List;

public interface ActivityDao {

    /**
     * 发布活动
     * @param startTime 开始时间
     * @param endTime 结束时间
     * @param activityName 活动名称
     * @param discount 折扣
     * @return an Activity
     */
    Activity create(String startTime, String endTime, String activityName, String discount);

    /**
     * 存储到数据库中
     */
    void addToDb();

    /**
     * 获取活动详情
     * @param activityId 活动id
     * @return an activity
     */
    Activity getById(String activityId);

    /**
     * 通过id删除活动
     * @param activityId id
     */
    void deleteByActivityId(String activityId);

    /**
     * 获取所有活动
     * @return list activity
     */
    List<Activity> getAll();
}
