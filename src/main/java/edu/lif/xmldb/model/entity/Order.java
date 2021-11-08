package edu.lif.xmldb.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 订单实体表
 */

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Order {

    private String orderId;          // 订单Id

    private String buyerId;          // 买家Id --- 订单用户信息

    private String orderPaymentId;     // 订单支付信息

    private String buyerAddressId;     // 订单收获信息

    public String createTime;          // 创建时间

    public String status;              // 订单状态d
}

