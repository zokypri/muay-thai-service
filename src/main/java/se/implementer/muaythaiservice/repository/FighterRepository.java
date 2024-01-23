package se.implementer.muaythaiservice.repository;

import org.springframework.data.repository.CrudRepository;
import se.implementer.muaythaiservice.model.db.Fighter;

import java.util.List;
import java.util.Optional;

public interface FighterRepository extends CrudRepository <Fighter, Long> {

    Optional<Fighter> findByFighterId(long fighterId);

    List<Fighter> findAllByFighterStatusAndGender(String fighterStatus, String gender);
}
