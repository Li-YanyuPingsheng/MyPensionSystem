package com.coopgroup.pensionsystem;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
@SpringBootApplication
@MapperScan("com.coopgroup.pensionsystem.Mapper")
public class PensionSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(PensionSystemApplication.class, args);
    }

}
