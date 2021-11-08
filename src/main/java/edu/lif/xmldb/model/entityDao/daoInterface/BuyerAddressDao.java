package edu.lif.xmldb.model.entityDao.daoInterface;


import edu.lif.xmldb.model.entity.BuyerAddress;

import java.util.List;

public interface BuyerAddressDao {

    /**
     * 买家添加收获地址
     * @param buyerId id
     * @param receiveName 收货人姓名
     * @param receivePhone 收货人电话
     * @param receiveAddress 收货人地址
     * @return 地址信息
     */
    BuyerAddress create(String buyerId, String receiveName, String receivePhone, String receiveAddress);

    /**
     * 存储到数据库中
     */
    void addToDb();

    /**
     * 删除收获地址
     * @param buyerAddressId id
     */
    void deleteById(String buyerAddressId);

    /**
     * 删除买家所有收获地址信息
     * @param buyerId id
     */
    void deleteByBuyerId(String buyerId);

    List<BuyerAddress> getBuyerAddresses(String buyerId);

    BuyerAddress getById(String buyerAddressId);
}
