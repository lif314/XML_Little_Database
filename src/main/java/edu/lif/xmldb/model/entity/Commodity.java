package edu.lif.xmldb.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 商品实体表
 */

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Commodity {

    private String commodityId;  // 商品Id

    // 店铺应该具有添加商品的功能，添加时将自动为商品的shipId进行初始化
    private String shopId;      // 店铺Id

    public String price;        // 价格

    public String category;     // 类别

    public String storeNum;     // 店铺存货量

    public String cname;        // 商品名称

    public String description;   // 商品描述
}
