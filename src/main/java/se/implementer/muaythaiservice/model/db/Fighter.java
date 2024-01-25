package se.implementer.muaythaiservice.model.db;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import se.implementer.muaythaiservice.model.dto.request.FighterDto;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "FIGHTER")
@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class Fighter {

    @Id
    @Column(name = "FIGHTER_ID", unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long fighterId;

    //TODO change to Lazy if fightsInfo data is not needed in the REST response
    @OneToMany(mappedBy = "fighter", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    List<FightInfo> fightsInfo;

    @NotNull
    @Column(name = "FIRST_NAME")
    String firstName;

    @Column(name = "LAST_NAME")
    String lastName;

    @Column(name = "STAGE_NAME")
    String stageName;

    @NotNull
    @Column(name = "HEIGHT_CM")
    String height;

    @NotNull
    @Column(name = "GENDER")
    String gender;

    @Column(name = "TOTAL_FIGHTS")
    int totalFights;

    @Column(name = "WINS")
    int wins;

    @Column(name = "LOSSES")
    int losses;

    @Column(name = "DRAWS")
    int draws;

    @NotNull
    @Column(name = "COUNTRY_ORIGIN")
    String countryOrigin;

    @Column(name = "COUNTRY_LIVING")
    String countryLiving;

    @Column(name = "CLUB")
    String club;

    @Column(name = "BIRTH_DATE")
    LocalDate birthDate;

    @NotNull
    @Column(name = "FIGHTER_STATUS")
    String fighterStatus;

    public static Fighter mapToFighter(FighterDto fighter) {
        return Fighter
                .builder()
                .firstName(fighter.getFirstName())
                .lastName(fighter.getLastName())
                .stageName(fighter.getShowName())
                .height(fighter.getHeight())
                .gender(fighter.getGender().name())
                .totalFights(fighter.getTotalFights())
                .wins(fighter.getWins())
                .losses(fighter.getLosses())
                .draws(fighter.getDraws())
                .countryLiving(fighter.getCountryLiving())
                .countryOrigin(fighter.getCountryOrigin())
                .club(fighter.getClub())
                .fighterStatus(fighter.getStatus().name())
                .birthDate(fighter.getBirthDate())
                .build();
    }
}
