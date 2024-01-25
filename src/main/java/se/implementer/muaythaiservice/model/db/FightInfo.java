package se.implementer.muaythaiservice.model.db;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import se.implementer.muaythaiservice.model.dto.request.FightInfoDto;

import java.time.LocalDate;

@Entity
@Table(name = "FIGHT_INFO")
@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class FightInfo {

    @Id
    @Column(name = "FIGHT_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long fightId;

    // TODO change to LAZY if response does not have all data when using history URL
    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "FIGHTER_ID", insertable = false, updatable = false)
    Fighter fighter;

    @NotNull
    @Column(name = "FIGHTER_ID")
    Long fighterId;

    @NotNull
    @Column(name = "RESULT")
    String result;

    @Column(name = "OPPONENT_ID")
    int opponentId;

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

    public static FightInfo mapToFightInfo(FightInfoDto fightInfoDto) {
        return FightInfo
                .builder()
                .fighterId(fightInfoDto.getFighterId())
                .result(fightInfoDto.getResult().name())
                .opponentId(fightInfoDto.getOpponentId())
                .fightDay(fightInfoDto.getFightDay())
                .location(fightInfoDto.getLocation())
                .arena(fightInfoDto.getArena())
                .weight(fightInfoDto.getWeight())
                .fightOrg(fightInfoDto.getFightOrg())
                .build();
    }

}
