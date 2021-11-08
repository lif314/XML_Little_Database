package edu.lif.xmldb.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class BuyerAddress {

    private String buyerAddressId;  // 地址id

    private String buyerId;  // 用户id

    public String receiveName; // 收货人姓名

    public String receivePhone; // 收货人联系方式

    public String receiveAddress; // 收货人地址
}