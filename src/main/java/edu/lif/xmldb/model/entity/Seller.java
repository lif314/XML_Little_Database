package edu.lif.xmldb.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 卖家实体表
 */

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Seller{

    private String sellerId;  // 卖家Id

    private String password;  // 密码

    private String name;      // 真实姓名

    private String idNumber;  // 身份证号

    public String nickname;   // 昵称

    public String phone;      // 电话号码
}
