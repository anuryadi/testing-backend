package ari.nuryadi.testingbackend.entity.repo;

import ari.nuryadi.testingbackend.entity.model.Rangking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RangkingRepo extends JpaRepository<Rangking, Long> {
}
