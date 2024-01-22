package se.implementer.muaythaiservice.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;
import se.implementer.muaythaiservice.model.FightInfoDto;
import se.implementer.muaythaiservice.model.FightResult;
import se.implementer.muaythaiservice.model.FighterDto;
import se.implementer.muaythaiservice.model.db.Fighter;
import se.implementer.muaythaiservice.model.FighterDetails;
import se.implementer.muaythaiservice.model.FighterOverview;
import se.implementer.muaythaiservice.model.FighterStatus;
import se.implementer.muaythaiservice.model.Gender;
import se.implementer.muaythaiservice.model.db.FightInfo;
import se.implementer.muaythaiservice.repository.FightInfoRepository;
import se.implementer.muaythaiservice.repository.FighterRepository;

import java.util.List;

@Service
@Slf4j
public class FighterService {

    private final FighterRepository fighterRepository;

    private final FightInfoRepository fightInfoRepository;

    public FighterService(FighterRepository fighterRepository, FightInfoRepository fightInfoRepository) {

        this.fighterRepository = fighterRepository;
        this.fightInfoRepository = fightInfoRepository;
    }

    public FighterDetails getFighterDetails(int fighterId) {
        var fighterOptional = fighterRepository.findByFighterId(fighterId);
        if (fighterOptional.isPresent()) {
            return FighterDetails.mapToFighterDetails(fighterOptional.get());
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Fighter with id not found");
    }

    public FighterOverview getFighterOverview(int fighterId) {
        var fighterOptional = fighterRepository.findByFighterId(fighterId);
        if (fighterOptional.isPresent()) {
            return FighterOverview.mapToFighterOverview(fighterOptional.get());
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Fighter with id not found");
    }

    public List<FighterOverview> getAllActiveFightersByGender(Gender gender) {
        var fighters = fighterRepository.findAllByFighterStatusAndGender(FighterStatus.ACTIVE.name(), gender.name());
        return fighters
                .stream()
                .map(FighterOverview::mapToFighterOverview)
                .toList();
    }

    public List<FightInfo> getFighterHistory(int fighterId) {

        var fights = fightInfoRepository.findAllByFighterId(fighterId);
        return fights
                .stream()
                .filter(fight -> !FightResult.FUTURE_FIGHT.name().equals(fight.getResult()))
                .toList();
    }

    @Transactional
    public void addFighter(FighterDto fighterDto) {
        log.info("adding new fighter {}", fighterDto.getFirstName());
        var fighter = fighterRepository.save(Fighter.mapToFighter(fighterDto));
        log.info("New fighter with id: {} added ", fighter.getFighterId());
        //TODO add a response object
    }

    @Transactional
    public void addFight(FightInfoDto fightInfoDto) {
        log.info("adding new fight for fighter with id: {}", fightInfoDto.getFighterId());
        var fightInfo = fightInfoRepository.save(FightInfo.mapToFightInfo(fightInfoDto));
        //TODO when a fight is added the fighters stats must also be updated
        //TODO add a response object
        //TODO handle exception
        log.info("added new fight with fight id: {} for fighter with fighter id: {}", fightInfo.getFightId(), fightInfo.getFighterId());
    }
}
