package se.implementer.muaythaiservice.model;

import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

import java.time.LocalDate;

@Value
@Builder
@Jacksonized
public class FightInfoDto {

    Long fighterId;

    FightResult result;

    int opponentId;

    LocalDate fightDay;

    String location;

    String arena;

    String weight;

    String fightOrg;
}
