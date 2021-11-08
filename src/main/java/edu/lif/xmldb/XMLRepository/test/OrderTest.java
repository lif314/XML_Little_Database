package edu.lif.xmldb.XMLRepository.test;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 订单简化：每个订单内只能包含不同数量的同一个商品，不能包含不同商品
 *
 * 为了在订单构建中使用建造者模式，可以为订单设置多个商品ID，比如默认一个订单内最多只能有三件不同商品，
 * 此时也就需要为每种商品添加数量属性
 */

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class OrderTest {

    private String orderTestId;

    private String buyerId;

    private String addressId;

    private String shopId;

    public String createDate;

    public String status;

    public String orderAmount;
}
