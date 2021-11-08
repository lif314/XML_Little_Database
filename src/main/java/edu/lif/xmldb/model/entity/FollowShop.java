package edu.lif.xmldb.model.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 店铺关注实体表
 */

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class FollowShop {

    private String shopId;  // 店铺Id

    private String buyerId;  // 买家Id

    public String followDate;  // 关注时间
}
