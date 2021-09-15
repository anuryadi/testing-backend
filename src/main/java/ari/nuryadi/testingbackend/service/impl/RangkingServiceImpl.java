package ari.nuryadi.testingbackend.service.impl;

import ari.nuryadi.testingbackend.entity.dto.RangkingDto;
import ari.nuryadi.testingbackend.entity.model.Rangking;
import ari.nuryadi.testingbackend.entity.repo.RangkingRepo;
import ari.nuryadi.testingbackend.service.RangkingService;
import ari.nuryadi.testingbackend.utils.exception.RowNotFoundDetailNullException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
@Service
public class RangkingServiceImpl implements RangkingService {
    @Autowired
    private RangkingRepo repo;

    @Override
    public RangkingDto getDTOFromModel(Rangking model) {
        return null;
    }

    @Override
    public Rangking getModelFromDTO(RangkingDto dto, Rangking model) throws FileNotFoundException {
        return null;
    }

    @Override
    public List<Rangking> getAllEntity() {
        List<Rangking> result = new ArrayList<>(repo.findAll());
        if (result.isEmpty())
            throw new RowNotFoundDetailNullException("Empty Result Set");

        return result;
    }

    @Override
    public Rangking getEntityById(Long id) {
        return null;
    }

    @Override
    public void saveEntity(RangkingDto dto) {

    }

    @Override
    public void updateEntity(RangkingDto dto) {

    }

    @Override
    public void deleteEntity(Long id) {

    }
}

