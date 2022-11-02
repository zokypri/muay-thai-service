package se.implementer.muaythaiservice.model.db;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "FIGHT_INFO")
@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class FightInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "FIGHT_ID")
    int fightId;

    //TODO change to Eager if response does not have all data when using history URL
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "FIGHTER_ID")
    Fighter fighter;

    @Column(name = "FIGHTER_ID", insertable = false, updatable = false)
    int fighterId;

    @Column(name = "RESULT")
    String result;

    @Column(name = "OPPONENT_ID")
    int opponentId;

    @Column(name = "ROUND_KO")
    int roundKo;

    @Column(name = "FIGHT_NUMBER")
    int fightNumber;

    @Column(name = "KO_TIME")
    String koTime;

    @Column(name = "FIGHT_DAY")
    LocalDate fightDay;

    @Column(name = "LOCATION")
    String location;

    @Column(name = "ARENA")
    String arena;

    @Column(name = "WEIGHT")
    String weight;

    @Column(name = "FIGHT_ORG")
    String fightOrg;

}
