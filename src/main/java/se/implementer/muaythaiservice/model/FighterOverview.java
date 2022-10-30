package se.implementer.muaythaiservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;
import se.implementer.muaythaiservice.util.FighterUtil;

@Value
@Builder
@AllArgsConstructor
public class FighterOverview {

    int fighterId;

    String firstName;

    String lastName;

    String showName;

    String gender;

    int totalFights;

    int wins;

    int losses;

    String countryOrigin;

    int age;

    String fighterStatus;

    public static FighterOverview mapToFighterOverview(Fighter fighter) {

        return FighterOverview
                .builder()
                .fighterId(fighter.getFighterId())
                .firstName(fighter.getFirstName())
                .lastName(fighter.getLastName())
                .showName(fighter.getStageName())
                .gender(fighter.getGender())
                .totalFights(fighter.getTotalFights())
                .wins(fighter.getWins())
                .losses(fighter.getLosses())
                .countryOrigin(fighter.getCountryOrigin())
                .age(FighterUtil.calculateAge(fighter.getBirthDate()))
                .fighterStatus(fighter.getFighterStatus())
                .build();
    }
}
