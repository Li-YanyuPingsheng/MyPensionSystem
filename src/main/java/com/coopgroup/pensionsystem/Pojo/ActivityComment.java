package com.coopgroup.pensionsystem.Pojo;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@Data
@TableName("activity_comment")
public class ActivityComment {
    @TableId(value = "UUID",type = IdType.ASSIGN_ID)
    @JsonSerialize(using = ToStringSerializer.class)
    private Long UUID;
    @TableField("Activity_UUID")
    @JsonSerialize(using= ToStringSerializer.class)
    private Long activityUUID;
    @TableField("Elder_UUID")
    @JsonSerialize(using= ToStringSerializer.class)
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
