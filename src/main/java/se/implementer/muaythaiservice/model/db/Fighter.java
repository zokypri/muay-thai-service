package se.implementer.muaythaiservice.model.db;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

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
    int fighterId;

    //TODO change to Lazy if fightsInfo data is not needed in the REST response
    @OneToMany(mappedBy = "fighter", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    List<FightInfo> fightsInfo;

    @Column(name = "FIRST_NAME")
    String firstName;

    @Column(name = "LAST_NAME")
    String lastName;

    @Column(name = "STAGE_NAME")
    String stageName;

    @Column(name = "HEIGHT_CM")
    String height;

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

    @Column(name = "COUNTRY_ORIGIN")
    String countryOrigin;

    @Column(name = "COUNTRY_LIVING")
    String countryLiving;

    @Column(name = "CITY")
    String city;

    @Column(name = "CLUB")
    String club;

    @Column(name = "FIGHT_ORG")
    String fightOrg;

    @Column(name = "RANKING")
    String ranking;

    @Column(name = "PRIMARY_WEIGHT")
    String primaryWeightClass;

    @Column(name = "BIRTH_DATE")
    LocalDate birthDate;

    @Column(name = "FIGHTER_STATUS")
    String fighterStatus;

}
