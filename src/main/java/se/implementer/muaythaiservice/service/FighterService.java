package se.implementer.muaythaiservice.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;
import se.implementer.muaythaiservice.model.FighterDto;
import se.implementer.muaythaiservice.model.db.Fighter;
import se.implementer.muaythaiservice.model.FighterDetails;
import se.implementer.muaythaiservice.model.FighterOverview;
import se.implementer.muaythaiservice.model.FighterStatus;
import se.implementer.muaythaiservice.model.Gender;
import se.implementer.muaythaiservice.repository.FighterRepository;

import java.util.List;

@Service
@Slf4j
public class FighterService {

    private final FighterRepository fighterRepository;

    public FighterService(FighterRepository fighterRepository) {

        this.fighterRepository = fighterRepository;
    }

    private Fighter getFighterRaw(long fighterId) {
        log.info("Fetching raw data for fighter with id: {}", fighterId);
        var fighterOptional = fighterRepository.findByFighterId(fighterId);
        if (fighterOptional.isPresent()) {
            return fighterOptional.get();
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("Fighter with id %s not found", fighterId));
    }

    public FighterDetails getFighterDetails(long fighterId) {
        log.info("Fetching details for fighter with id: {}", fighterId);
        return FighterDetails.mapToFighterDetails(getFighterRaw(fighterId));
    }

    public FighterOverview getFighterOverview(long fighterId) {
        log.info("Fetching overview for fighter with id: {}", fighterId);
        return FighterOverview.mapToFighterOverview(getFighterRaw(fighterId));
    }

    public List<FighterOverview> getAllActiveFightersByGender(Gender gender) {
        log.info("Fetching all active fighters of the gender: {}", gender);
        var fighters = fighterRepository.findAllByFighterStatusAndGender(FighterStatus.ACTIVE.name(), gender.name());
        return fighters
                .stream()
                .map(FighterOverview::mapToFighterOverview)
                .toList();
    }

    @Transactional
    public void addFighter(FighterDto fighterDto) {
        log.info("adding new fighter {}", fighterDto.getFirstName());
        var fighter = fighterRepository.save(Fighter.mapToFighter(fighterDto));
        log.info("New fighter with id: {} added ", fighter.getFighterId());
        //TODO add a response object
    }
}
