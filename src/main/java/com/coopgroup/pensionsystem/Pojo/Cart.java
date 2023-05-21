package com.coopgroup.pensionsystem.Pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import com.github.jeffreyning.mybatisplus.anno.MppMultiId;
import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
@TableName("cart")
public class Cart {
    @MppMultiId(value = "Elder_UUID")
    @JsonSerialize(using= ToStringSerializer.class)
    private Long elderUUID;
    @MppMultiId(value = "Good_UUID")
    @JsonSerialize(using= ToStringSerializer.class)
    private Long goodUUID;
    @TableField("Quantity")
    private Integer quantity;
}
