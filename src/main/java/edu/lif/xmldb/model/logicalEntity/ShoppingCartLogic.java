package edu.lif.xmldb.model.logicalEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ShoppingCartLogic {

    private String commodityId;  // 商品Id

    public String cname;        // 商品名称

    public String price;        // 价格

    public String amount;       // 商品数量

    public String category;     // 类别

    public String description;   // 商品描述

    public String createDate;  // 添加时间时间
}
