package edu.lif.xmldb.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 订单促销信息
 */

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class OrderPromotion {

    private String orderId;      // 订单id

    private String promotionId;  // 促销券id

    private String type;     // 类别：Activity/Coupon
}
