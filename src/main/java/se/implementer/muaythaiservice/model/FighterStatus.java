package se.implementer.muaythaiservice.model;

import java.util.Arrays;

public enum FighterStatus {

    ACTIVE("Fighter is active"),
    INACTIVE("Fighter is inactive due to other reasons"),
    RETIRED("Fighter is retired"),
    INJURED("Fighter is injured"),
    RECOVERING("Fighter is recovering after recent fight");

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
