package se.implementer.muaythaiservice.repository;

import org.springframework.data.repository.CrudRepository;
import se.implementer.muaythaiservice.model.Fighter;

import java.util.Optional;

public interface FighterRepository extends CrudRepository <Fighter, Integer> {

    Optional<Fighter> findByFighterId(int fighterId);
}
