package edu.lif.xmldb.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 优惠实体表
 *
 * 优惠券是满多少减多少
 */

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Coupon {

    private String couponId;  // 优惠券Id

    private String shopId;  // 店铺id

    public String startTime; // 起始时间

    public String endTime;   // 终止时间

    public String full;      // 满多少

    public String minus;     // 减多少
}
