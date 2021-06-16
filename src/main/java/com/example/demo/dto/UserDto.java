package com.example.demo.dto;

import com.example.demo.domain.User;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;

import java.util.Map;

@Data
public class UserDto {

    private Long id;
    private String username;
    private String name;
    private String email;
    private boolean invalid;

    public UserDto(User user) {
        this.id = user.getId();
        this.username = user.getUsername();
        this.name = user.getName();
        this.email = user.getEmail();
        this.invalid = user.isInvalid();
    }

    public Map<String, Object> toMap() {
        TypeReference<Map<String, Object>> typeRef = new TypeReference<Map<String, Object>>() {};
        ObjectMapper oMapper = new ObjectMapper();
        return oMapper.convertValue(this, typeRef);
    }
}
