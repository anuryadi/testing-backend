package ari.nuryadi.testingbackend.entity.repo;

import ari.nuryadi.testingbackend.entity.model.Challenge;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChallengeRepo extends JpaRepository<Challenge, Long> {

}
