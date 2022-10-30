package se.implementer.muaythaiservice.util;

import java.time.LocalDate;
import java.time.Period;

public class FighterUtil {

    public static int calculateAge(LocalDate birthDate) {
        return Period.between(birthDate, LocalDate.now()).getYears();
    }
}
