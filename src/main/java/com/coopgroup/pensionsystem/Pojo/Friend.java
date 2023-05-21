package com.coopgroup.pensionsystem.Pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import com.github.jeffreyning.mybatisplus.anno.MppMultiId;
import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
@TableName("friend")
public class Friend {
    @MppMultiId(value = "Account_UUID")
    @JsonSerialize(using= ToStringSerializer.class)
    private Long accountUUID;
    @MppMultiId(value = "Friend_UUID")
    @JsonSerialize(using= ToStringSerializer.class)
    private Long friendUUID;
}
