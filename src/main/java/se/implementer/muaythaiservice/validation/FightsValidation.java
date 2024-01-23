package se.implementer.muaythaiservice.validation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import se.implementer.muaythaiservice.validator.FightsValidator;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = FightsValidator.class)
public @interface FightsValidation {
    String message() default "Fights amount does not add up";
    Class<?>[] groups() default {};
    Class<?>[] payload() default {};
}