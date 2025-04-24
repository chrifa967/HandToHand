package repositories;

import entities.MessagePrive;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MessagePriveRepository extends JpaRepository<MessagePrive, Integer> {

    List<MessagePrive> findByRecepteurId(int id);
    List<MessagePrive> findByEnvoyeurId(int id);
    List<MessagePrive> findByEnvoyeurIdAndRecepteurId(int envoyeurId, int recepteurId);


}
