package com.coopgroup.pensionsystem.Pojo;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class ElderAccount {
    private Elder elder;
    private User user;
}
