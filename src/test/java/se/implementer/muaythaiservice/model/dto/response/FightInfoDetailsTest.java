package se.implementer.muaythaiservice.model.dto.response;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import se.implementer.muaythaiservice.util.testdata.FightsTestData;

public class FightInfoDetailsTest {

    @Test
    void shouldMapToFightInfoDetails() {

        var fighterId = 1L;

        var actualValue = FightInfoDetails.mapToFightInfoDetails(FightsTestData.mockFightsInfo(fighterId).get(0));

        var  expectedValue = FightsTestData.mockFightInfoDetails(fighterId).get(0);

        assertEquals(expectedValue, actualValue);
    }

    @Test
    void shouldMapToFightsInfoDetails() {

        var fighterId = 1L;

        var actualValue = FightInfoDetails.mapToFightsInfoDetails(FightsTestData.mockFightsInfo(fighterId));

        var  expectedValue = FightsTestData.mockFightInfoDetails(fighterId );

        assertEquals(expectedValue, actualValue);
    }
}
