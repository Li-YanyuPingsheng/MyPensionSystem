package com.coopgroup.pensionsystem.Pojo;

import com.baomidou.mybatisplus.annotation.IdType;
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
@TableName("elder")
public class Elder {
    @JsonSerialize(using = ToStringSerializer.class)
    @TableId(value = "Account_UUID",type = IdType.INPUT)
    private Long account_UUID;
    @TableField("ID")
    private String ID;
    @TableField("Location")
    private String location;
}
