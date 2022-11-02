package se.implementer.muaythaiservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;
import se.implementer.muaythaiservice.model.db.FightInfo;

import java.time.LocalDate;
import java.util.List;

@Value
@Builder
@AllArgsConstructor
public class FightInfoDetails {

    int fightId;

    int fighterId;

    String result;

    int opponentId;

    int roundKo;

    int fightNumber;

    String koTime;

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
                .result(fightInfo.getResult())
                .opponentId(fightInfo.getOpponentId())
                .roundKo(fightInfo.getRoundKo())
                .fightNumber(fightInfo.getFightNumber())
                .koTime(fightInfo.getKoTime())
                .fightDay(fightInfo.getFightDay())
                .location(fightInfo.getLocation())
                .arena(fightInfo.getArena())
                .weight(fightInfo.getWeight())
                .fightOrg(fightInfo.getFightOrg())
                .build();
    }
}