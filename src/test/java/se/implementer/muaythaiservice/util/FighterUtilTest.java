package se.implementer.muaythaiservice.util;

import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class FighterUtilTest {

    @Test
    void shouldCalculateAge() {
        var birthDate = LocalDate.of(2000, 1, 1);

        var expectedAge = LocalDate.now().minusYears(birthDate.getYear()).getYear();

        var actualAge = FighterUtil.calculateAge(birthDate);

        assertEquals(expectedAge, actualAge);
    }
}
