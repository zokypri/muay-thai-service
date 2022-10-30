package se.implementer.muaythaiservice.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import se.implementer.muaythaiservice.model.FighterDetails;
import se.implementer.muaythaiservice.repository.FighterRepository;

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

}
