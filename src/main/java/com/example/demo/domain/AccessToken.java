package com.example.demo.domain;

import com.example.demo.domain.base.InvalidatableEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
public class AccessToken extends InvalidatableEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    @Lob
    private String token;
}
