package edu.lif.xmldb.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 购物车实体表
 */

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ShoppingCart {

    private String buyerId;  // 买家Id

    private String commodityId;  // 商品Id

    public String amount;  // 商品数量

    public String createDate;  // 创建时间
}
