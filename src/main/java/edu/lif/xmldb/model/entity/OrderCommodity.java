package edu.lif.xmldb.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 订单商品实体表
 *
 * 说明：通过该联系集可以实现一个订单多件商品
 */

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class OrderCommodity {

    private String orderId;

    private String commodityId;

    public String amount;   // 同一商品的数量
}
