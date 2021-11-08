package edu.lif.xmldb.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 订单支付信息
 */

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class OrderPayment {

    private String orderPaymentId;   // 支付Id

    public String payMethod;   // 支付方式

    public String payStatus;   // 支付状态

    public String totalMoney;  // 未优惠价格

    public String paidMoney; // 实际支付费用

    public String paidTime;   // 支付时间
}
