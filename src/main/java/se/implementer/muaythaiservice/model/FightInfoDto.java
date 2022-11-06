package se.implementer.muaythaiservice.model;

import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

import java.time.LocalDate;

@Value
@Builder
@Jacksonized
public class FightInfoDto {

    int fighterId;

    FightResult result;

    int opponentId;

    String roundKo;

    int fightNumber;

    String koTime;

    LocalDate fightDay;

    String location;

    String arena;

    String weight;

    String fightOrg;
}
