package se.implementer.muaythaiservice.model.dto.response;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import se.implementer.muaythaiservice.util.testdata.FighterTestData;

public class FighterOverviewTest {

    @Test
    void shouldMapToFighterOverview() {

        var fighterId = 1L;

        var actualValue = FighterOverview.mapToFighterOverview(FighterTestData.mockFighterRaw(fighterId));

        var expectedValue = FighterTestData.mockFighterOverview(fighterId);

        assertEquals(expectedValue, actualValue);
    }
}
