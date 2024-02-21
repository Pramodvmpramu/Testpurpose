package com.Testpurpose.Validator;

import com.Testpurpose.Annotation.EvenNumberOrZero;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class EvenNumberOrZeroValidator implements ConstraintValidator<EvenNumberOrZero, Number> {
    @Override
    public void initialize(EvenNumberOrZero constraintAnnotation) {
    }

    @Override
    public boolean isValid(Number value, ConstraintValidatorContext context) {
        return value == null || value.longValue() == 0 || value.longValue() % 2 == 0;
    }
}

