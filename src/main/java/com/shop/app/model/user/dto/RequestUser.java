package com.shop.app.model.user.dto;

import lombok.Builder;
import lombok.Data;

@Data
public class RequestUser {
    private String loginId;
    private String password;
    private String name;
}
