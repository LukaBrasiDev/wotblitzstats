package pl.lukabrasi.wotblitzstats.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.lukabrasi.wotblitzstats.entities.PlayerLogEntity;

import java.util.Optional;

@Repository
public interface PlayerLogRepository extends JpaRepository<PlayerLogEntity,Integer> {

  //  Optional<PlayerLogEntity> findByAccountExists(int account); //todo

}
