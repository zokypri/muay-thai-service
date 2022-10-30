package se.implementer.muaythaiservice.model;

import java.util.Arrays;

public enum FighterStatus {

    ACTIVE("Figher is active"),
    INACTIVE("Figher is inactive due to other reasons"),
    RETIRED("Figher is retired"),
    INJURED("Figher is injured"),
    RECOVERING("Figher is recovering after recent fight");

    private String statusDescription;

    FighterStatus(String statusDescription) {
        this.statusDescription = statusDescription;
    }

    public static FighterStatus mapToFighterStatus(String status) {

        return Arrays.stream(FighterStatus.values())
                .filter(value -> value.name().equals(status))
                .findFirst()
                .orElseThrow(() -> new EnumConstantNotPresentException(FighterStatus.class, status));

    }
}
