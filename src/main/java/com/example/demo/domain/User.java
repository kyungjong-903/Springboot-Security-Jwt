package com.example.demo.domain;

import com.example.demo.domain.base.InvalidatableEntity;
import com.example.demo.repository.StringCryptoConverter;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Convert;
import javax.persistence.Entity;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
public class User extends InvalidatableEntity {

    @Convert(converter = StringCryptoConverter.class)
    private String username;

    private String password;

    @Convert(converter = StringCryptoConverter.class)
    private String email;
}
