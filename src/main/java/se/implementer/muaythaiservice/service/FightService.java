package se.implementer.muaythaiservice.service;

import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import se.implementer.muaythaiservice.model.dto.request.FightInfoDto;
import se.implementer.muaythaiservice.model.dto.FightResult;
import se.implementer.muaythaiservice.model.db.FightInfo;
import se.implementer.muaythaiservice.model.dto.response.Responses;
import se.implementer.muaythaiservice.repository.FightInfoRepository;

@Service
@Slf4j
public class FightService {

    private final FightInfoRepository fightInfoRepository;

    public FightService(FightInfoRepository fightInfoRepository) {

        this.fightInfoRepository = fightInfoRepository;
    }

    public List<FightInfo> getFighterHistory(long fighterId) {
        log.info("Fetching all fight history for fighter with id: {}", fighterId);
        var fights = fightInfoRepository.findAllByFighterId(fighterId);
        return fights
                .stream()
                .filter(fight -> !FightResult.FUTURE_FIGHT.name().equals(fight.getResult()))
                .toList();
    }

    @Transactional
    public Responses.AddFight addFight(FightInfoDto fightInfoDto) {
        log.info("Adding new fight for fighter with id: {}", fightInfoDto.getFighterId());
        var fightInfo = fightInfoRepository.save(FightInfo.mapToFightInfo(fightInfoDto));
        //TODO when a fight is added the fighters stats must also be updated
        //TODO handle exception
        log.info("added new fight with fight id: {} for fighter with fighter id: {}", fightInfo.getFightId(), fightInfo.getFighterId());
        return new Responses.AddFight(fightInfo.getFightId(), fightInfo.getFighterId());
    }
}
