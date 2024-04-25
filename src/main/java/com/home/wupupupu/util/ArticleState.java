package com.home.wupupupu.util;

import com.auth0.jwt.interfaces.Payload;
import jakarta.validation.Constraint;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = StateValidation.class)
public @interface ArticleState {
    String message() default "文章状态只能是已发布，草稿";
    Class[] groups() default {};
    Class<? extends Payload>[] payload() default{ };
}
