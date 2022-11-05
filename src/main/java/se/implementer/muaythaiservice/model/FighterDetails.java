package se.implementer.muaythaiservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;
import se.implementer.muaythaiservice.model.db.Fighter;
import se.implementer.muaythaiservice.util.FighterUtil;

import java.time.LocalDate;
import java.util.List;

import static se.implementer.muaythaiservice.model.FighterStatus.mapToFighterStatus;
import static se.implementer.muaythaiservice.model.Gender.mapToGender;

@Value
@Builder
@AllArgsConstructor
public class FighterDetails {

    int fighterId;

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
