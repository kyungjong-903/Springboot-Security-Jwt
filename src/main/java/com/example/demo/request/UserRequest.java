package com.example.demo.request;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class UserRequest extends LoginRequest {
    private String email;
}
