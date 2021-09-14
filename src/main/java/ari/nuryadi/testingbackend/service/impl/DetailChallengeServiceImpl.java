package ari.nuryadi.testingbackend.service.impl;

import ari.nuryadi.testingbackend.entity.dto.DetailChallengeDto;
import ari.nuryadi.testingbackend.entity.model.DetailChallenge;
import ari.nuryadi.testingbackend.entity.repo.DetailChallengeRepo;
import ari.nuryadi.testingbackend.entity.repo.UserRepo;
import ari.nuryadi.testingbackend.service.DetailChallengeService;
import ari.nuryadi.testingbackend.utils.exception.RowNotFoundDetailNullException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DetailChallengeServiceImpl implements DetailChallengeService {
    private static final String ENTITY_ID_LABEL = "Detail Challenge ID";

    @Autowired
    private UserRepo userRepo;



    @Autowired
    private DetailChallengeRepo repo;

    @Override
    public DetailChallengeDto getDTOFromModel(DetailChallenge model) {
        return null;
    }

    @Override
    public DetailChallenge getModelFromDTO(DetailChallengeDto dto, DetailChallenge model) {
        model.setId(dto.getId());
        model.setUserId(dto.getUserId());
        model.setChallengerId(dto.getChallengerId());
        model.setKriteria(dto.getKriteria());
        model.setStatus(dto.getStatus());

        return model;
    }

    @Override
    public List<DetailChallenge> getAllEntity() {
        List<DetailChallenge> result = new ArrayList<>(repo.findAll());
        if (result.isEmpty())
            throw new RowNotFoundDetailNullException("Empty Result Set");

        return result;
    }

    @Override
    public DetailChallenge getEntityById(Long id) {
        Optional<DetailChallenge> opt = repo.findById(id);
        if (!opt.isPresent())
            throw new RowNotFoundDetailNullException("Row Cannot be Found for " + ENTITY_ID_LABEL + " : " + id);

        return opt.get();
    }

    @Override
    public void saveEntity(DetailChallengeDto dto) {
        repo.save(getModelFromDTO(dto, new DetailChallenge()));
    }

    @Override
    public void updateEntity(DetailChallengeDto dto) {

    }

    @Override
    public void deleteEntity(Long id) {

    }
}
