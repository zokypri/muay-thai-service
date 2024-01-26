package se.implementer.muaythaiservice.util.testdata;

import java.time.LocalDate;
import java.util.List;
import se.implementer.muaythaiservice.model.db.FightInfo;
import se.implementer.muaythaiservice.model.dto.FightResult;
import se.implementer.muaythaiservice.model.dto.request.FightInfoDto;
import se.implementer.muaythaiservice.model.dto.response.FightInfoDetails;

public class FightsTestData {

    private static final String BKK = "BKK";
    private static final String RAJA = "RAJA";
    private static final String MAX = "MAX";
    private static final String PATT = "Pattaya";

    private static LocalDate FIGHT_DATE = LocalDate.of(2024, 1, 23);

    public static FightInfoDto mockFightInfoDto(long fighterId) {
        return FightInfoDto
                .builder()
                .fighterId(fighterId)
                .fightOrg(RAJA)
                .fightDay(FIGHT_DATE)
                .result(FightResult.WIN)
                .arena(RAJA)
                .location(BKK)
                .weight("65")
                .build();
    }

    public static List<FightInfo> mockFightsInfo(long fighterId) {
        return List.of(
                FightInfo
                        .builder()
                        .fighterId(fighterId)
                        .fightId(1L)
                        .fightOrg(RAJA)
                        .fightDay(FIGHT_DATE)
                        .result("WIN")
                        .arena(RAJA)
                        .location(BKK)
                        .weight("65")
                        .build(),
                FightInfo
                        .builder()
                        .fighterId(fighterId)
                        .fightId(2L)
                        .fightOrg(MAX)
                        .fightDay(FIGHT_DATE.minusDays(5))
                        .result("DRAW")
                        .arena(MAX)
                        .location(PATT)
                        .weight("65")
                        .build()
        );
    }

    public static List<FightInfoDetails> mockFightInfoDetails(long fighterId) {
        return List.of(
                FightInfoDetails
                        .builder()
                        .fighterId(fighterId)
                        .fightId(1L)
                        .fightOrg(RAJA)
                        .fightDay(FIGHT_DATE)
                        .result(FightResult.WIN)
                        .arena(RAJA)
                        .location(BKK)
                        .weight("65")
                        .build(),
                FightInfoDetails
                        .builder()
                        .fighterId(fighterId)
                        .fightId(2L)
                        .fightOrg(MAX)
                        .fightDay(FIGHT_DATE.minusDays(5))
                        .result(FightResult.DRAW)
                        .arena(MAX)
                        .location(PATT)
                        .weight("65")
                        .build()
        );
    }

    public static List<FightInfoDetails> mockFightInfoDetailsFixedDate(long fighterId) {
        return List.of(
                FightInfoDetails
                        .builder()
                        .fighterId(fighterId)
                        .fightId(1L)
                        .fightOrg(RAJA)
                        .fightDay(FIGHT_DATE)
                        .result(FightResult.WIN)
                        .arena(RAJA)
                        .location(BKK)
                        .weight("65")
                        .build(),
                FightInfoDetails
                        .builder()
                        .fighterId(fighterId)
                        .fightId(2L)
                        .fightOrg(MAX)
                        .fightDay(FIGHT_DATE)
                        .result(FightResult.DRAW)
                        .arena(MAX)
                        .location(PATT)
                        .weight("65")
                        .build()
        );
    }

    public static FightInfo mockFightInfoWithoutFightId(long fighterId) {
        return FightInfo
                .builder()
                .fighterId(fighterId)
                .fightOrg(RAJA)
                .fightDay(FIGHT_DATE)
                .result("WIN")
                .arena(RAJA)
                .location(BKK)
                .weight("65")
                .build();
    }


}
