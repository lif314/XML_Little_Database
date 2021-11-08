package edu.lif.xmldb.model.entityDao.daoImpl;

import edu.lif.xmldb.XMLRepository.ProxyXmlContext;
import edu.lif.xmldb.XMLRepository.XMLContext;
import edu.lif.xmldb.model.entity.BuyerAddress;
import edu.lif.xmldb.model.entityDao.daoInterface.BuyerAddressDao;

import java.util.ArrayList;

import java.util.List;
import java.util.UUID;

public class BuyerAddressDaoImpl implements BuyerAddressDao {

    private final XMLContext<BuyerAddress> buyerAddressXMLContext = new ProxyXmlContext<>(BuyerAddress.class);

    private static BuyerAddress buyerAddress;

    /**
     * 买家添加收获地址
     *
     * @param buyerId        id
     * @param receiveName    收货人姓名
     * @param receivePhone   收货人电话
     * @param receiveAddress 收货人地址
     * @return 地址信息
     */
    @Override
    public BuyerAddress create(String buyerId, String receiveName, String receivePhone, String receiveAddress) {
        String id = UUID.randomUUID().toString();
        buyerAddress = new BuyerAddress(id,buyerId, receiveName, receivePhone, receiveAddress);
        return buyerAddress;
    }

    /**
     * 存储到数据库中
     */
    @Override
    public void addToDb() {
        buyerAddressXMLContext.add(buyerAddress);
    }

    /**
     * 删除收获地址
     *
     * @param buyerAddressId id
     */
    @Override
    public void deleteById(String buyerAddressId) {
        buyerAddressXMLContext.deleteById(buyerAddressId);
    }

    /**
     * 删除买家所有收获地址信息
     *
     * @param buyerId id
     */
    @Override
    public void deleteByBuyerId(String buyerId) {
        List<BuyerAddress> init = buyerAddressXMLContext.init();
        buyerAddressXMLContext.deleteAll();
        for (BuyerAddress address : init) {
            if(! address.getBuyerId().equals(buyerId)){
                buyerAddressXMLContext.add(address);
            }
        }
    }

    @Override
    public List<BuyerAddress> getBuyerAddresses(String buyerId) {
        List<BuyerAddress> init = buyerAddressXMLContext.init();
        List<BuyerAddress> buyerAddresses = new ArrayList<>();
        for (BuyerAddress address : init) {
            if(address.getBuyerId().equals(buyerId)){
                buyerAddresses.add(address);
            }
        }
        return buyerAddresses;
    }

    @Override
    public BuyerAddress getById(String buyerAddressId) {
        return buyerAddressXMLContext.findById(buyerAddressId);
    }
}
