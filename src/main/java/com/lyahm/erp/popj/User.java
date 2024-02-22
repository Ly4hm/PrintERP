package com.lyahm.erp.popj;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class User {
    private Integer id;
    private String username;
    private String password;
    private String phone;
    private LocalDateTime create_time;
    private LocalDateTime update_time;
}
