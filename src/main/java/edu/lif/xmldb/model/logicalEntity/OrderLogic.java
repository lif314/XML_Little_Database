package edu.lif.xmldb.model.logicalEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class OrderLogic {

    /**
     * 订单自身性质
     */
    private String orderId;     // 订单Id

    public String createTime;   // 下单时间

    public String status;       // 订单状态


    /**
     * 店铺提供信息
     */
    private String shopId;    // 店铺Id

    public String shopName;   // 店铺名称

    public String shopAddress; // 发货地址

    /**
     * 买家提供信息
     */
    private String buyerId;  // 买家id

    /**
     * 买家收获信息
     */
    public String buyerAddressId;

    public String receiveName;  // 收获人姓名

    public String receivePhone; // 收货人联系方式

    public String receiveAddress; // 收获地址

    /**
     * 优惠信息
     */
    public String activityId;   // 活动券id

    public String couponId;     // 优惠券id

    public String promotionMoney; // 优惠金额

    /**
     * 支付信息
     */
    private String orderPaymentId;   // 支付信息id

    public String payMethod;   // 支付方式

    public String payStatus;   // 支付状态

    public String totalMoney;   // 不使用优惠券后应支付费用

    public String paidMoney;    // 买家实际支付费用

    public String paidTime;     // 支付时间

    /**
     * 订单商品集
     */
    public List<OrderCommodityLogic> commodityList; // 订单商品集
}
