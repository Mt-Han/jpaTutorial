package com.shop.app.model.user.dto;

import lombok.Data;

@Data
public class ResponseUser {
    private String loginId;
    private String password;
    private String name;
}
