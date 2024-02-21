package com.Testpurpose.Annotation;

import com.Testpurpose.Validator.EvenNumberOrZeroValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = EvenNumberOrZeroValidator.class)
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface EvenNumberOrZero {
    String message() default "Field value must be an even number or zero";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}