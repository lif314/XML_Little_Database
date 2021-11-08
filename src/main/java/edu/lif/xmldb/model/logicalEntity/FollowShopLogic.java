package edu.lif.xmldb.model.logicalEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class FollowShopLogic {

    private String shopId;  // 店铺Id

    public String shopName;     // 店铺名称

    public String creditScore;  // 店铺积分

    public String category;     // 店铺类别

    public String description;   // 店铺描述

    public String followDate;  // 关注时间
}
