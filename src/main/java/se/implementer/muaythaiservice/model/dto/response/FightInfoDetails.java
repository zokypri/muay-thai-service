package se.implementer.muaythaiservice.model.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;
import se.implementer.muaythaiservice.model.db.FightInfo;

import java.time.LocalDate;
import java.util.List;
import se.implementer.muaythaiservice.model.dto.FightResult;

@Value
@Builder
@AllArgsConstructor
public class FightInfoDetails {

    Long fightId;

    Long fighterId;

    FightResult result;

    int opponentId;

    LocalDate fightDay;

    String location;

    String arena;

    String weight;

    String fightOrg;

    public static List<FightInfoDetails> mapToFightsInfoDetails(List<FightInfo> fightsInfo) {

        return fightsInfo
                .stream()
                .map(FightInfoDetails::mapToFightInfoDetails)
                .toList();
    }
    public static FightInfoDetails mapToFightInfoDetails(FightInfo fightInfo) {
        return FightInfoDetails
                .builder()
                .fightId(fightInfo.getFightId())
                .fighterId(fightInfo.getFighterId())
                .result(FightResult.mapToFightResult(fightInfo.getResult()))
                .opponentId(fightInfo.getOpponentId())
                .fightDay(fightInfo.getFightDay())
                .location(fightInfo.getLocation())
                .arena(fightInfo.getArena())
                .weight(fightInfo.getWeight())
                .fightOrg(fightInfo.getFightOrg())
                .build();
    }
}
