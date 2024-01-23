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

    String countryOrigin;

    String countryLiving;

    String club;

    FighterStatus status;

    LocalDate birthDate;

}
