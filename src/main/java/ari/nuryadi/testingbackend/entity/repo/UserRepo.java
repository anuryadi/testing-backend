package ari.nuryadi.testingbackend.entity.repo;

import ari.nuryadi.testingbackend.entity.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);

    @Query("SELECT u, c FROM User u INNER JOIN DetailChallenge dc on u.id = dc.userId INNER JOIN Challenge c on c.id = dc.challengerId")
    List<User> findAllJoin();
}
