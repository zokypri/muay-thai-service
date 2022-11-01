package se.implementer.muaythaiservice.model.db;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
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

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fighter_id")
    Fighter fighter;

    String result;

    int opponentId;

    int roundKo;

    int fightNumber;

    String koTime;

    LocalDate fightDay;

    String location;

    String arena;

    String weight;

    String fightOrg;

}
