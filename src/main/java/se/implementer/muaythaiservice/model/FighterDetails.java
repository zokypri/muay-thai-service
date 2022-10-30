package se.implementer.muaythaiservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;

import java.time.LocalDate;
import java.time.Period;

@Value
@Builder
@AllArgsConstructor
public class FighterDetails {

    String firstName;

    String lastName;

    String showName;

    String height;

    String gender;

    int wins;

    int losses;

    int draws;

    int noContests;

    int winsKo;

    int winsDecision;

    int lossesKo;

    int lossesDecision;

    String countryOrigin;

    String countryLiving;

    String city;

    String club;

    String fightOrg;

    String ranking;

    String primaryWeightClass;

    int age;

    public static FighterDetails mapToFighterDetails(Fighter fighter) {

        return FighterDetails
                .builder()
                .firstName(fighter.getFirstName())
                .lastName(fighter.getLastName())
                .showName(fighter.getStageName())
                .height(fighter.getHeight())
                .gender(fighter.getGender())
                .wins(fighter.getWins())
                .losses(fighter.getLosses())
                .draws(fighter.getDraws())
                .noContests(fighter.getNoContests())
                .winsKo(fighter.getWinsKo())
                .winsDecision(fighter.getWinsDecision())
                .lossesKo(fighter.getLossesKo())
                .lossesDecision(fighter.getLossesDecision())
                .countryOrigin(fighter.getCountryOrigin())
                .countryLiving(fighter.getCountryLiving())
                .city(fighter.getCity())
                .club(fighter.getClub())
                .fightOrg(fighter.getFightOrg())
                .ranking(fighter.getRanking())
                .primaryWeightClass(fighter.getPrimaryWeightClass())
                .age(FighterDetails.calculateAge(fighter.getBirthDate()))
                .build();
    }

    private static int calculateAge(LocalDate birthDate) {
        return Period.between(birthDate, LocalDate.now()).getYears();
    }

}
