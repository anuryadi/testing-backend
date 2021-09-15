package ari.nuryadi.testingbackend.entity.repo;

import ari.nuryadi.testingbackend.entity.model.DetailChallenge;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface DetailChallengeRepo extends JpaRepository<DetailChallenge, Long> {
    @Query("SELECT c.id, dc.userId, c.point, case when c.kriteria = dc.kriteria then 'Done' else 'Failed' end from DetailChallenge dc inner join Challenge c on dc.challengerId = c.id where dc.userId = :userId and dc.status is null")
    List<String> findMatchByUser(@Param("userId") Long id);

    @Modifying
    @Transactional
    @Query(value = "update Detail_Challenge set status = :status where user_Id = :id", nativeQuery = true)
    void updateStatusByUserId(@Param("status") Integer status, @Param("id") Long id);
}
