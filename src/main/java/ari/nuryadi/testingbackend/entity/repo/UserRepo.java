package ari.nuryadi.testingbackend.entity.repo;

import ari.nuryadi.testingbackend.entity.model.User;
import io.swagger.models.auth.In;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);

    @Modifying
    @Transactional
    @Query(value = "update Users set poin = poin + :poin WHERE id = :id", nativeQuery = true)
    void updatePointById(@Param("poin") Integer Point, @Param("id") Long id);

    @Modifying
    @Transactional
    @Query(value = "update Users set rangking = :rangking WHERE id = :id", nativeQuery = true)
    void updateRangkingById(@Param("rangking") Integer rangking, @Param("id") Integer id);

    @Query(value = "SELECT * FROM public.get_rangking()", nativeQuery = true)
    List<String> rangking();
}
