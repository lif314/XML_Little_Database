package edu.lif.xmldb.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 店铺实体表
 */
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Shop {

    private String shopId;   // 店铺Id

    private String sellerId; // 卖家Id

    public String shopName;     // 店铺名称

    public String creditScore;  // 店铺积分

    public String category;     // 店铺类别

    public String shopAddress;  // 店铺发货地址

    public String description;   // 店铺描述
}
