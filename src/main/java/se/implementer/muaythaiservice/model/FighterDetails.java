package se.implementer.muaythaiservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;
import se.implementer.muaythaiservice.util.FighterUtil;

import static se.implementer.muaythaiservice.model.FighterStatus.mapToFighterStatus;

@Value
@Builder
@AllArgsConstructor
public class FighterDetails {

    int fighterId;

    String firstName;

    String lastName;

    String showName;

    String height;

    String gender;

    int totalFights;

    int wins;

    int losses;

    int draws;

    int noContest;

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

    FighterStatus status;

    public static FighterDetails mapToFighterDetails(Fighter fighter) {

        return FighterDetails
                .builder()
                .fighterId(fighter.getFighterId())
                .firstName(fighter.getFirstName())
                .lastName(fighter.getLastName())
                .showName(fighter.getStageName())
                .height(fighter.getHeight())
                .gender(fighter.getGender())
                .totalFights(fighter.getTotalFights())
                .wins(fighter.getWins())
                .losses(fighter.getLosses())
                .draws(fighter.getDraws())
                .noContest(fighter.getNoContests())
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
                .age(FighterUtil.calculateAge(fighter.getBirthDate()))
                .status(mapToFighterStatus(fighter.getFighterStatus()))
                .build();
    }
}
