package se.implementer.muaythaiservice.model.dto.response;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import se.implementer.muaythaiservice.util.testdata.FighterTestData;

public class FighterDetailsTest {

    @Test
    void shouldMapToFighterDetails() {

        var fighterId = 1L;

        var actualValue = FighterDetails.mapToFighterDetails(FighterTestData.mockFighterRaw(fighterId));

        var  expectedValue = FighterTestData.mockFighterDetails(fighterId);

        assertEquals(expectedValue, actualValue);
    }
}
