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
@TableName("activity")
public class Activity {
    @JsonSerialize(using= ToStringSerializer.class)
    @TableId(value = "UUID",type= IdType.ASSIGN_ID)
    private Long UUID;
    @TableField("Content")
    private String content;
    @TableField("Fee")
    private Double fee;
    @TableField("Location")
    private String location;
    @TableField("Date")
    private String date;
    @TableField("Status")
    private String status;
    @TableField("Picture_ID")
    private String picture_ID;
}
