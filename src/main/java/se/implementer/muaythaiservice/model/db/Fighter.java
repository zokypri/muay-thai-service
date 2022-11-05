package se.implementer.muaythaiservice.model.db;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import se.implementer.muaythaiservice.model.FighterDto;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "FIGHTERS")
@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Fighter {

    @Id
    @Column(name = "FIGHTER_ID", unique = true)
    @GeneratedValue (strategy = GenerationType.SEQUENCE, generator = "FIGHTER_SEQ")
    @SequenceGenerator(name = "FIGHTER_SEQ", sequenceName = "FIGHTER_SEQ", allocationSize = 1)
    int fighterId;

    //TODO change to Lazy if fightsInfo data is not needed in the REST response
    @OneToMany(mappedBy = "fighter", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    List<FightInfo> fightsInfo;

    @NotNull
    @Column(name = "FIRST_NAME")
    String firstName;

    @NotNull
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

    @Column(name = "NO_CONTESTS")
    int noContests;

    @Column(name = "WINS_KO")
    int winsKo;

    @Column(name = "WINS_DECISION")
    int winsDecision;

    @Column(name = "LOSSES_KO")
    int lossesKo;

    @Column(name = "LOSSES_DECISION")
    int lossesDecision;

    @NotNull
    @Column(name = "COUNTRY_ORIGIN")
    String countryOrigin;

    @NotNull
    @Column(name = "COUNTRY_LIVING")
    String countryLiving;

    @NotNull
    @Column(name = "CITY")
    String city;

    @NotNull
    @Column(name = "CLUB")
    String club;

    @NotNull
    @Column(name = "FIGHT_ORG")
    String fightOrg;

    @Column(name = "RANKING")
    String ranking;

    @Column(name = "PRIMARY_WEIGHT")
    String primaryWeightClass;

    @Column(name = "BIRTH_DATE")
    @NotNull
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
                .noContests(fighter.getNoContest())
                .winsKo(fighter.getWinsKo())
                .winsDecision(fighter.getWinsDecision())
                .lossesKo(fighter.getLossesKo())
                .lossesDecision(fighter.getLossesDecision())
                .countryLiving(fighter.getCountryLiving())
                .countryOrigin(fighter.getCountryOrigin())
                .city(fighter.getCity())
                .club(fighter.getClub())
                .fightOrg(fighter.getFightOrg())
                .fighterStatus(fighter.getStatus().name())
                .birthDate(fighter.getBirthDate())
                .build();
    }
}
