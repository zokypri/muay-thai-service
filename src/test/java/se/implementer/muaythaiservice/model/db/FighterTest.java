package se.implementer.muaythaiservice.model.db;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import se.implementer.muaythaiservice.util.testdata.FighterTestData;
import static se.implementer.muaythaiservice.util.testdata.FighterTestData.mockFighterDto;

public class FighterTest {

    @Test
    void shouldMapToFighter() {

        var actualValue = Fighter.mapToFighter(mockFighterDto());

        var expectedValue = FighterTestData.mockFighterRawWithoutFighterIdAndFightIfo();

        assertEquals(expectedValue, actualValue);
    }
}
