package se.implementer.muaythaiservice.model.dto;

import java.util.Arrays;

public enum FightResult {
    WIN,
    LOSS,
    DRAW,
    FUTURE_FIGHT,
    NO_CONTEST;

    public static FightResult mapToFightResult(String result) {

        return Arrays.stream(FightResult.values())
                .filter(value -> value.name().equals(result))
                .findFirst()
                .orElseThrow(() -> new EnumConstantNotPresentException(FightResult.class, result));

    }
}
