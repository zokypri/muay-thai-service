package se.implementer.muaythaiservice.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import se.implementer.muaythaiservice.model.db.FightInfo;

import java.util.List;

@Repository
public interface FightInfoRepository extends CrudRepository<FightInfo, Integer> {

    List<FightInfo> findAllByFighterId(int fighterId);
}
