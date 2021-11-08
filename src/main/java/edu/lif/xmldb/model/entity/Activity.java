package edu.lif.xmldb.model.entity;

import jdk.jfr.DataAmount;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 活动实体表：全场打折
 * 说明：活动以打折的形式出现，优惠券以满多少减多少的形式出现
 */

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Activity {

    public String activityId;  // 活动Id

    public String startTime;   // 起始时间

    public String endTime;     // 终止时间

    public String activityName;      // 活动名称

    public String discount;   // 打折
}
