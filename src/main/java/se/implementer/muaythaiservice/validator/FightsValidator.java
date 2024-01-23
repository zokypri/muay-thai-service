package se.implementer.muaythaiservice.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import se.implementer.muaythaiservice.model.dto.request.FighterDto;
import se.implementer.muaythaiservice.validation.FightsValidation;

public class FightsValidator implements ConstraintValidator<FightsValidation, FighterDto> {
    @Override
    public boolean isValid(FighterDto fighterDto, ConstraintValidatorContext constraintValidatorContext) {

        return isNumberOfFightsCorrect(fighterDto);
    }

    // This function could be removed but for the sake of readability I added it
    private boolean isNumberOfFightsCorrect(FighterDto fighterDto) {
        return fighterDto.getTotalFights() == (fighterDto.getWins() + fighterDto.getDraws() + fighterDto.getLosses());
    }
}
