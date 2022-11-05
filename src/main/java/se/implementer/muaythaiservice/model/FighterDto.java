package se.implementer.muaythaiservice.model;

import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

import java.time.LocalDate;

@Value
@Jacksonized
@Builder
public class FighterDto {

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

    FighterStatus status;

    LocalDate birthDate;

}
