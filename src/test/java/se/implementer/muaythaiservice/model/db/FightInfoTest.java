package se.implementer.muaythaiservice.model.db;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import se.implementer.muaythaiservice.util.testdata.FightsTestData;

public class FightInfoTest {

    @Test
    void shouldMapToFightInfo() {
        var fighterId = 10L;

        var actualValue = FightInfo.mapToFightInfo(FightsTestData.mockFightInfoDto(fighterId));

        var expectedValue = FightsTestData.mockFightInfoWithoutFightId(fighterId);

        assertEquals(expectedValue, actualValue);
    }


}
