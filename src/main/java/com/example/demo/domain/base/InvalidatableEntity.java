package com.example.demo.domain.base;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Data
@EqualsAndHashCode(callSuper = true)
@MappedSuperclass
public abstract class InvalidatableEntity extends BaseEntity {
    private boolean invalid;
    private LocalDateTime invalidAt;

    public void setInvalid(boolean invalid) {
        this.invalid = invalid;
        if(invalid) {
            invalidAt = LocalDateTime.now();
        } else {
            invalidAt = null;
        }
    }
}
