package com.example.thuchanh3_lmh.validator.annotation;

import com.example.thuchanh3_lmh.validator.ValidCategoryIdValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;


@Target({ElementType.TYPE, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = ValidCategoryIdValidator.class)
@Documented
public @interface ValidCategoryId {
    String message() default "Invalid Category ID";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
