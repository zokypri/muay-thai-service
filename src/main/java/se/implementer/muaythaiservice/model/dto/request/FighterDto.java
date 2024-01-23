package se.implementer.muaythaiservice.model.dto.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

import java.time.LocalDate;
import se.implementer.muaythaiservice.model.dto.FighterStatus;
import se.implementer.muaythaiservice.model.dto.Gender;
import se.implementer.muaythaiservice.validation.FightsValidation;

@Value
@Jacksonized
@Builder
@FightsValidation
public class FighterDto {

    @NotBlank
    String firstName;

    String lastName;

    String showName;

    @NotBlank
    String height;

    @NotNull
    Gender gender;

    int totalFights;

    int wins;

    int losses;

    int draws;

    @NotBlank
    String countryOrigin;

    String countryLiving;

    String club;

    @NotNull
    FighterStatus status;

    LocalDate birthDate;

}
