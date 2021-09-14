package ari.nuryadi.testingbackend.service.impl;

import ari.nuryadi.testingbackend.entity.dto.ChallengeDto;
import ari.nuryadi.testingbackend.entity.dto.DetailChallengeDto;
import ari.nuryadi.testingbackend.entity.model.Challenge;
import ari.nuryadi.testingbackend.entity.repo.ChallengeRepo;
import ari.nuryadi.testingbackend.service.ChallengeService;
import ari.nuryadi.testingbackend.utils.exception.RowNotFoundDetailNullException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ChallengeServiceImpl implements ChallengeService {
    private static final String ENTITY_ID_LABEL = "Challenge ID";

    @Autowired
    private ChallengeRepo repo;

    @Override
    public ChallengeDto getDTOFromModel(Challenge model) {
        return null;
    }

    @Override
    public Challenge getModelFromDTO(ChallengeDto dto, Challenge model) {
        model.setId(dto.getId());
        model.setJudul(dto.getJudul());
        model.setDeskripsi(dto.getDeskripsi());
        model.setPoint(dto.getPoint());
        model.setKriteria(dto.getKriteria());

        return model;
    }

    @Override
    public List<Challenge> getAllEntity() {
        List<Challenge> result = new ArrayList<>(repo.findAll());
        if (result.isEmpty())
            throw new RowNotFoundDetailNullException("Empty Result Set");

        return result;
    }

    @Override
    public Challenge getEntityById(Long id) {
        Optional<Challenge> opt = repo.findById(id);
        if (!opt.isPresent())
            throw new RowNotFoundDetailNullException("Row Cannot be Found for " + ENTITY_ID_LABEL + " : " + id);

        return opt.get();
    }

    @Override
    public void saveEntity(ChallengeDto dto) {
        DetailChallengeDto detailChallengeDto = new DetailChallengeDto();

        repo.save(getModelFromDTO(dto, new Challenge()));
    }

    @Override
    public void updateEntity(ChallengeDto dto) {

    }

    @Override
    public void deleteEntity(Long id) {

    }
}
