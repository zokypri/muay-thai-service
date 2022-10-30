package se.implementer.muaythaiservice.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
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
}
