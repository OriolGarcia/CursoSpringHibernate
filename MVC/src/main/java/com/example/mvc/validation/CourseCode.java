package com.example.mvc.validation;


import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = CourseCodeConstraintValidator.class)
@Target({ElementType.METHOD,ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface CourseCode {

    //define defuld cuourse code
    public String value() default "LUV";
    //define default error message
    public String message() default " must start with LUV";
    //define defult groups
    public Class<?>[] groups() default {};
    // define defuld payloads
    public Class<? extends Payload>[] payload() default {};
}
