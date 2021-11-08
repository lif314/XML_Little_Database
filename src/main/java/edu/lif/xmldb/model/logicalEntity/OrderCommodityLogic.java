package edu.lif.xmldb.model.logicalEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 订单商品联系集的逻辑实体
 *
 * 主要是在订单id已知的情况下商品的信息
 */

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class OrderCommodityLogic {

    // 同一建商品
    private String commodityId; // 商品id

    public String cname;        // 商品名称

    public String price;        // 价格

    public String amount;      // 商品的数量
}
