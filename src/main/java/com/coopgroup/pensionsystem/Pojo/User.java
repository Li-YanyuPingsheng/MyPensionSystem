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
@TableName("account")
public class User {

    @JsonSerialize(using = ToStringSerializer.class)
    @TableId(value = "UUID",type = IdType.ASSIGN_ID)
    private Long UUID;
    @TableField("Username")
    private String username;
    @TableField("Password")
    private String password;
    @TableField("Role")
    private String role;
    @TableField("Name")
    private String name;
    @TableField("Phone")
    private String phone;
}
