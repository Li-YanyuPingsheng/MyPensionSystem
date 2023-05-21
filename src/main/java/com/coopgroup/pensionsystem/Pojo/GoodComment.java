package com.coopgroup.pensionsystem.Pojo;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@Data
@TableName("good_comment")
public class GoodComment {
    @TableId(value = "UUID",type = IdType.ASSIGN_ID)
    @JsonSerialize(using = ToStringSerializer.class)
    private Long UUID;
    @TableField("Good_UUID")
    private Long goodUUID;
    @TableField("Elder_UUID")
    private Long elderUUID;
    @TableField("Content")
    private String content;
    @TableField("ReplyContent")
    private String replyContent;
    @TableField(value = "create_time",fill = FieldFill.INSERT)
    private LocalDateTime create_time;
    @TableField(value = "update_time",fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime update_time;
}
