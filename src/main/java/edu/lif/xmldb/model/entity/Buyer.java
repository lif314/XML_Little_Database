package edu.lif.xmldb.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 买家实体表
 */

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Buyer {

    private String buyerId;  // 买家Id

    private String passwd;   // 密码

    private String idNumber;  // 身份证号

    public String phone;      // 电话号码

    public String nickname;   // 昵称

    public String gender;     // 性别

    public String birthday;   // 生日
}
