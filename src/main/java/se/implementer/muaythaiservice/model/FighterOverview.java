package se.implementer.muaythaiservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;
import se.implementer.muaythaiservice.util.FighterUtil;

import static se.implementer.muaythaiservice.model.FighterStatus.mapToFighterStatus;
import static se.implementer.muaythaiservice.model.Gender.mapToGender;

@Value
@Builder
@AllArgsConstructor
public class FighterOverview {

    int fighterId;

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
