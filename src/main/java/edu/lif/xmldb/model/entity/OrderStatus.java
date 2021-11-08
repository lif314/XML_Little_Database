package edu.lif.xmldb.model.entity;

/**
 * 订单状态
 */
public enum OrderStatus {
    WAIT_PAYMENT, // 待支付
    WAIT_DELIVER, // 待发货
    WAIT_RECEIVE, // 待收获
    FINISH;       // 订单完成
}