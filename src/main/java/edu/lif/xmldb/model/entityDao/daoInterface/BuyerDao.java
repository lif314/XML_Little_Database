package edu.lif.xmldb.model.entityDao.daoInterface;

import edu.lif.xmldb.model.entity.Buyer;

import java.util.List;

public interface BuyerDao {


    /**
     * 买家注册
     * @param passwd 密码
     * @param idNumber 身份证号
     * @param phone 电话号码
     * @param nickname 昵称
     * @param gender 性别
     * @param birthday 生日
     * @return a Buyer
     */
    Buyer create(String passwd, String idNumber, String phone, String nickname, String gender, String birthday);

    /**
     * 存储到数据库中
     */
    void addToDb();

    /**
     * 买家登录
     * @param phone 电话号码
     * @param password 密码
     * @return 登录成功与否
     */
    Buyer login(String phone, String password);

    /**
     * 获取所有买家
     * @return list buyers
     */
    List<Buyer> getAll();

    /**
     * 修改买家密码
     * @param buyerId 买家id
     * @param newPasswd 新密码
     */
    void updatePassword(String buyerId, String newPasswd);

    /**
     * 通过id删除用户
     * @param buyerId id
     */
    void deleteByBuyerId(String buyerId);
}
