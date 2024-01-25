package se.implementer.muaythaiservice.model.dto;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class GenderTest {

    @Test
    void shouldMapToMale() {

        var actualValue = Gender.mapToGender("MALE");

        assertEquals(Gender.MALE, actualValue);
    }

    @Test
    void shouldMapToFemale() {

        var actualValue = Gender.mapToGender("FEMALE");

        assertEquals(Gender.FEMALE, actualValue);
    }

    @Test
    void shouldThrowEnumNotFoundException() {

        assertThatThrownBy( () -> Gender.mapToGender("Wrong")
        ).isInstanceOf(EnumConstantNotPresentException.class);
    }
}
