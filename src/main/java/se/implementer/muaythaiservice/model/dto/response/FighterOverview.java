package se.implementer.muaythaiservice.model.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;
import se.implementer.muaythaiservice.model.db.Fighter;
import se.implementer.muaythaiservice.model.dto.FighterStatus;
import se.implementer.muaythaiservice.model.dto.Gender;
import se.implementer.muaythaiservice.util.FighterUtil;

import static se.implementer.muaythaiservice.model.dto.FighterStatus.mapToFighterStatus;
import static se.implementer.muaythaiservice.model.dto.Gender.mapToGender;

@Value
@Builder
@AllArgsConstructor
public class FighterOverview {

    Long fighterId;

    String firstName;

    String lastName;

    String showName;

    Gender gender;

    int totalFights;

    int wins;

    int losses;

    String countryOrigin;

    int age;

    FighterStatus status;

    public static FighterOverview mapToFighterOverview(Fighter fighter) {

        return FighterOverview
                .builder()
                .fighterId(fighter.getFighterId())
                .firstName(fighter.getFirstName())
                .lastName(fighter.getLastName())
                .showName(fighter.getStageName())
                .gender(mapToGender(fighter.getGender()))
                .totalFights(fighter.getTotalFights())
                .wins(fighter.getWins())
                .losses(fighter.getLosses())
                .countryOrigin(fighter.getCountryOrigin())
                .age(FighterUtil.calculateAge(fighter.getBirthDate()))
                .status(mapToFighterStatus(fighter.getFighterStatus()))
                .build();
    }
}
