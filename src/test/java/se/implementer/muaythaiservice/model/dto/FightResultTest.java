package se.implementer.muaythaiservice.model.dto;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class FightResultTest {

    @Test
    void shouldMapToFightResultWIN() {

        var actualValue = FightResult.mapToFightResult("WIN");

        assertEquals(FightResult.WIN, actualValue);
    }

    @Test
    void shouldMapToFightResultLOSS() {

        var actualValue = FightResult.mapToFightResult("LOSS");

        assertEquals(FightResult.LOSS, actualValue);
    }

    @Test
    void shouldMapToFightResultDRAW() {

        var actualValue = FightResult.mapToFightResult("DRAW");

        assertEquals(FightResult.DRAW, actualValue);
    }

    @Test
    void shouldMapToFightResultFUTURE_FIGHT() {

        var actualValue = FightResult.mapToFightResult("FUTURE_FIGHT");

        assertEquals(FightResult.FUTURE_FIGHT, actualValue);
    }

    @Test
    void shouldMapToFightResultNO_CONTEST() {

        var actualValue = FightResult.mapToFightResult("NO_CONTEST");

        assertEquals(FightResult.NO_CONTEST, actualValue);
    }

    @Test
    void shouldThrowEnumNotFound() {

        assertThatThrownBy( () -> FightResult.mapToFightResult("Wrong")
        ).isInstanceOf(EnumConstantNotPresentException.class);
    }
}
