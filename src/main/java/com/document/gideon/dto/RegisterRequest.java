package com.document.gideon.dto;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class RegisterRequest {

    private String username;
    private String password;
}
