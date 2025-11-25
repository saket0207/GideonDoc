package com.document.gideon.dto;

import lombok.*;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Getter
@Setter
@ToString
public class LoginRequest {

    private String username;
    private String password;
}
