package se.implementer.muaythaiservice.model.dto;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class FighterStatusTest {

    @Test
    void shouldMapToFighterStatusActive() {

        var actualValue = FighterStatus.mapToFighterStatus("ACTIVE");

        assertEquals(FighterStatus.ACTIVE, actualValue);
    }

    @Test
    void shouldMapToFighterStatusINACTIVE() {

        var actualValue = FighterStatus.mapToFighterStatus("INACTIVE");

        assertEquals(FighterStatus.INACTIVE, actualValue);
    }

    @Test
    void shouldMapToFighterStatusRETIRED() {

        var actualValue = FighterStatus.mapToFighterStatus("RETIRED");

        assertEquals(FighterStatus.RETIRED, actualValue);
    }

    @Test
    void shouldMapToFighterStatusINJURED() {

        var actualValue = FighterStatus.mapToFighterStatus("INJURED");

        assertEquals(FighterStatus.INJURED, actualValue);
    }

    @Test
    void shouldMapToFighterStatusRECOVERING() {

        var actualValue = FighterStatus.mapToFighterStatus("RECOVERING");

        assertEquals(FighterStatus.RECOVERING, actualValue);
    }

    @Test
    void shouldTThrowNotFoundException() {

        assertThatThrownBy( () -> FighterStatus.mapToFighterStatus("Wrong")
        ).isInstanceOf(EnumConstantNotPresentException.class);
    }
}
