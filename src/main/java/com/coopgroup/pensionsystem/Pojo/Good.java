package com.coopgroup.pensionsystem.Pojo;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@Data
@TableName("Good")
public class Good {
    @JsonSerialize(using = ToStringSerializer.class)
    @TableId(value = "Good_UUID",type = IdType.ASSIGN_ID)
    private Long good_UUID;
    @TableField("Name")
    private String name;
    @TableField("Priced")
    private Double price;
    @TableField("Stock")
    private Integer stock;
    @TableField("Status")
    private String status;
    @TableField("Information")
    private String information;
    @TableField("Picture_ID")
    private String picture_ID;
    @JsonSerialize(using = ToStringSerializer.class)
    @TableField("Category_UUID")
    private Long category_UUID;
    @TableField("Merchant_UUID")
    @JsonSerialize(using = ToStringSerializer.class)
    private Long merchant_UUID;
    @TableField(value = "create_time",fill = FieldFill.INSERT)
    private LocalDateTime create_time;
    @TableField(value="update_time",fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime update_time;
}
