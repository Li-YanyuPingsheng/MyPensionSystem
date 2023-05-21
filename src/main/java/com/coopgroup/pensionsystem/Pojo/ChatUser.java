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
@TableName("chat_user")
public class ChatUser {
    @MppMultiId(value = "User_UUID")
    @JsonSerialize(using= ToStringSerializer.class)
    private Long userUUID;
    @MppMultiId(value = "Chat_UUID")
    @JsonSerialize(using= ToStringSerializer.class)
    private Long chatUUID;
}
