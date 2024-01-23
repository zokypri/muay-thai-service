package se.implementer.muaythaiservice.model.dto;

import java.util.Arrays;

public enum Gender {
    MALE,
    FEMALE;

    public static Gender mapToGender(String gender) {
        return Arrays
                .stream(Gender.values())
                .filter(value -> value.name().equals(gender))
                .findFirst().orElseThrow(() -> new EnumConstantNotPresentException(Gender.class, gender));
    }
}
