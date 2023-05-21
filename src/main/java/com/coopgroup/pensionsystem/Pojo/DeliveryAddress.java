package com.coopgroup.pensionsystem.Pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
@TableName("delivery_address")
public class DeliveryAddress {
    @TableId(value = "UUID",type = IdType.ASSIGN_ID)
    @JsonSerialize(using= ToStringSerializer.class)
    private Long UUID;
    @TableField("Elder_UUID")
    @JsonSerialize(using = ToStringSerializer.class)
    private Long elderUUID;
    @TableField("Location")
    private String location;
}
