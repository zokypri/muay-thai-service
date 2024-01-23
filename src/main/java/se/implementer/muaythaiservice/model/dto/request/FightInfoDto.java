package se.implementer.muaythaiservice.model.dto.request;

import javax.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

import java.time.LocalDate;
import se.implementer.muaythaiservice.model.dto.FightResult;

@Value
@Builder
@Jacksonized
public class FightInfoDto {

    @NotNull
    Long fighterId;

    @NotNull
    FightResult result;

    int opponentId;

    LocalDate fightDay;

    String location;

    String arena;

    String weight;

    String fightOrg;
}
