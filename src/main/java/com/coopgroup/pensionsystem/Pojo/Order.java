package com.coopgroup.pensionsystem.Pojo;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@Data
@TableName("Order")
public class Order {
    @TableId(value = "UUID",type = IdType.ASSIGN_ID)
    @JsonSerialize(using = ToStringSerializer.class)
    private Long UUID;
    @TableField("Elder_UUID")
    @JsonSerialize(using = ToStringSerializer.class)
    private Long elderUUID;
    @TableField("Location_UUID")
    @JsonSerialize(using= ToStringSerializer.class)
    private Long locationUUID;
    @TableField("Status")
    private String status;
    @TableField(value = "create_time",fill = FieldFill.INSERT)
    private LocalDateTime create_time;
    @TableField(value = "update_time",fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime update_time;
}
