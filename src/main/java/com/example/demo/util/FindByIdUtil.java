package com.example.demo.util;

import com.example.demo.domain.base.InvalidatableEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.security.InvalidParameterException;

public class FindByIdUtil {
    public static <T> T findTarget(JpaRepository<T, Long> repo, Long id) {
        if(id == null) return null;
        return repo.findById(id).orElse(null);
    }

    public static <T> T findTargetOrThrow(JpaRepository<T, Long> repo, Long id) {
        return findTargetOrThrow(repo, id, false);
    }

    public static <T> T findTargetOrThrow(JpaRepository<T, Long> repo, Long id, boolean ignoreInvalidated) {
        if(id == null) System.out.println("에러");
        T t = repo.findById(id).orElseThrow(InvalidParameterException::new);
        if(t instanceof InvalidatableEntity && ((InvalidatableEntity)t).isInvalid()) {
            if(!ignoreInvalidated) System.out.println("에러");
        }
        return t;
    }
}
