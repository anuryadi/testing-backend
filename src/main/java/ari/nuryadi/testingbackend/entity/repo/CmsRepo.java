package ari.nuryadi.testingbackend.entity.repo;

import ari.nuryadi.testingbackend.entity.model.Cms;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CmsRepo extends JpaRepository<Cms, Long> {

    List<Cms> findByKataKunciLike(String kataKunci);

    List<Cms> findByStatus(Integer status);

    List<Cms> findByType(Integer type);

}
