package com.coopgroup.pensionsystem.Pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
@TableName("merchant")
public class Merchant {
    @JsonSerialize(using = ToStringSerializer.class)
    @TableId("UUID")
    private Long UUID;
    @TableField("Merchant_Name")
    private String merchantName;
    @TableField("Score")
    private Float score;
    @TableField("Payment_URL")
    private String paymentURL;
}
