package se.implementer.muaythaiservice.model.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;
import se.implementer.muaythaiservice.model.db.Fighter;
import se.implementer.muaythaiservice.model.dto.FighterStatus;
import se.implementer.muaythaiservice.model.dto.Gender;
import se.implementer.muaythaiservice.util.FighterUtil;

import java.time.LocalDate;
import java.util.List;

import static se.implementer.muaythaiservice.model.dto.FighterStatus.mapToFighterStatus;
import static se.implementer.muaythaiservice.model.dto.Gender.mapToGender;

@Value
@Builder
@AllArgsConstructor
public class FighterDetails {

    Long fighterId;

    List<FightInfoDetails> fightsInfo;

    String firstName;

    String lastName;

    String showName;

    String height;

    Gender gender;

    int totalFights;

    int wins;

    int losses;

    int draws;

    String countryOrigin;

    String countryLiving;

    String club;

    int age;

    FighterStatus status;

    LocalDate birthDate;

    public static FighterDetails mapToFighterDetails(Fighter fighter) {

        return FighterDetails
                .builder()
                .fighterId(fighter.getFighterId())
                .fightsInfo(FightInfoDetails.mapToFightsInfoDetails(fighter.getFightsInfo()))
                .firstName(fighter.getFirstName())
                .lastName(fighter.getLastName())
                .showName(fighter.getStageName())
                .height(fighter.getHeight())
                .gender(mapToGender(fighter.getGender()))
                .totalFights(fighter.getTotalFights())
                .wins(fighter.getWins())
                .losses(fighter.getLosses())
                .draws(fighter.getDraws())
                .countryOrigin(fighter.getCountryOrigin())
                .countryLiving(fighter.getCountryLiving())
                .club(fighter.getClub())
                .age(FighterUtil.calculateAge(fighter.getBirthDate()))
                .status(mapToFighterStatus(fighter.getFighterStatus()))
                .birthDate(fighter.getBirthDate())
                .build();
    }
}
