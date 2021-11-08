package edu.lif.xmldb.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 商品关注实体表
 */

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class FollowCommodity {

    private String buyerId;   // 买家Id

    private String commodityId;  // 商品Id

    public String followDate;    // 关注时间
}
