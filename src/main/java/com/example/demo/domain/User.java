package com.example.demo.domain;

import com.example.demo.domain.base.InvalidatableEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
public class User extends InvalidatableEntity {
    private String username;
    private String password;
    private String email;
}
