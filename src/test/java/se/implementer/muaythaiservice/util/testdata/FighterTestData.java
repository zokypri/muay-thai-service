package se.implementer.muaythaiservice.util.testdata;

import java.time.LocalDate;
import se.implementer.muaythaiservice.model.db.Fighter;
import se.implementer.muaythaiservice.model.dto.FighterStatus;
import se.implementer.muaythaiservice.model.dto.Gender;
import se.implementer.muaythaiservice.model.dto.request.FighterDto;
import se.implementer.muaythaiservice.model.dto.response.FighterDetails;
import se.implementer.muaythaiservice.model.dto.response.FighterOverview;
import static se.implementer.muaythaiservice.util.testdata.FightsTestData.mockFightsInfo;

public class FighterTestData {

    public static FighterDto mockFighterDto() {
        return FighterDto
                .builder()
                .firstName("Jan")
                .lastName("Banan")
                .showName("Banane")
                .height("177")
                .gender(Gender.MALE)
                .totalFights(10)
                .wins(7)
                .losses(2)
                .draws(1)
                .countryOrigin("Sweden")
                .countryLiving("Thailand")
                .club("Fairtex")
                .status(FighterStatus.ACTIVE)
                .birthDate(LocalDate.now().minusYears(20))
                .build();
    }

    public static FighterOverview mockFighterOverview(long fighterId) {
        return FighterOverview
                .builder()
                .fighterId(fighterId)
                .firstName("Jan")
                .lastName("Banan")
                .showName("Banane")
                .gender(Gender.MALE)
                .totalFights(10)
                .wins(7)
                .losses(2)
                .age(20)
                .countryOrigin("Sweden")
                .status(FighterStatus.ACTIVE)
                .build();
    }

    public static FighterDetails mockFighterDetails(long fighterId) {
        return FighterDetails
                .builder()
                .fighterId(fighterId)
                .fightsInfo(FightsTestData.mockFightInfoDetails(fighterId))
                .firstName("Jan")
                .lastName("Banan")
                .showName("Banane")
                .height("177")
                .gender(Gender.MALE)
                .totalFights(10)
                .wins(7)
                .losses(2)
                .draws(1)
                .age(20)
                .countryOrigin("Sweden")
                .countryLiving("Thailand")
                .club("Fairtex")
                .status(FighterStatus.ACTIVE)
                .birthDate(LocalDate.now().minusYears(20))
                .build();
    }

    public static Fighter mockFighterRaw(long fighterId) {
        return Fighter
                .builder()
                .fighterId(fighterId)
                .fightsInfo(mockFightsInfo(fighterId))
                .firstName("Jan")
                .lastName("Banan")
                .stageName("Banane")
                .height("177")
                .gender("MALE")
                .totalFights(10)
                .wins(7)
                .losses(2)
                .draws(1)
                .countryOrigin("Sweden")
                .countryLiving("Thailand")
                .club("Fairtex")
                .birthDate(LocalDate.now().minusYears(20))
                .fighterStatus("ACTIVE")
                .build();
    }

    public static Fighter mockFighterRawWithoutFighterIdAndFightIfo() {
        return Fighter
                .builder()
                .firstName("Jan")
                .lastName("Banan")
                .stageName("Banane")
                .height("177")
                .gender("MALE")
                .totalFights(10)
                .wins(7)
                .losses(2)
                .draws(1)
                .countryOrigin("Sweden")
                .countryLiving("Thailand")
                .club("Fairtex")
                .birthDate(LocalDate.now().minusYears(20))
                .fighterStatus("ACTIVE")
                .build();
    }
}
