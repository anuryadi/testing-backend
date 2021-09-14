package ari.nuryadi.testingbackend.service.impl;

import ari.nuryadi.testingbackend.entity.dto.CmsDto;
import ari.nuryadi.testingbackend.entity.model.Cms;
import ari.nuryadi.testingbackend.entity.repo.CmsRepo;
import ari.nuryadi.testingbackend.service.CmsService;
import ari.nuryadi.testingbackend.utils.CoreDate;
import ari.nuryadi.testingbackend.utils.exception.BadRequestException;
import ari.nuryadi.testingbackend.utils.exception.RowNotFoundDetailNullException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CmsServiceImpl implements CmsService {
    private static final String ENTITY_ID_LABEL = "Cms ID";

    @Autowired
    private CmsRepo repo;

    @Override
    public CmsDto getDTOFromModel(Cms model) {
        return null;
    }

    @Override
    public Cms getModelFromDTOMultiPart(MultipartFile file, CmsDto dto, Cms model) {

        model.setId(dto.getId());
        model.setJudul(dto.getJudul());
        model.setTanggal(CoreDate.DateNow());
        model.setDeskripsi(dto.getDeskripsi());
        model.setStatus(dto.getStatus());
        model.setKataKunci(dto.getKataKunci());
        model.setType(dto.getType());

        return model;
    }

    @Override
    public void saveEntityMultipart(MultipartFile file, CmsDto dto) {
        repo.save(getModelFromDTOMultiPart(file, dto, new Cms()));
    }

    @Override
    public Cms getModelFromDTO(CmsDto dto, Cms model) {
        model.setId(dto.getId());
        model.setJudul(dto.getJudul());
        model.setTanggal(CoreDate.DateNow());
        model.setDeskripsi(dto.getDeskripsi());
        if (dto.getStatus() != 0 && dto.getStatus() != 1)
            throw new BadRequestException("Wrong Input In Status (0 : Inactive, 1 : Active)");

        model.setStatus(dto.getStatus());
        model.setKataKunci(dto.getKataKunci());

        if (dto.getType() != 1 && dto.getType() != 2)
            throw new BadRequestException("Wrong Input In Type (1 : Promosi, 2 : Events)");
        model.setType(dto.getType());

        return model;
    }

    @Override
    public List<Cms> getAllEntity() {
        List<Cms> result = new ArrayList<>(repo.findAll());
        if (result.isEmpty())
            throw new RowNotFoundDetailNullException("Empty Result Set");

        return result;
    }

    @Override
    public Cms getEntityById(Long id) {
        Optional<Cms> opt = repo.findById(id);
        if (!opt.isPresent())
            throw new RowNotFoundDetailNullException("Row Cannot be Found for " + ENTITY_ID_LABEL + " : " + id);

        return opt.get();
    }

    @Override
    public void saveEntity(CmsDto dto) {
        repo.save(getModelFromDTO(dto, new Cms()));
    }

    @Override
    public void updateEntity(CmsDto dto) {

    }

    @Override
    public void deleteEntity(Long id) {
        Optional<Cms> opt = repo.findById(id);
        if (!opt.isPresent())
            throw new RowNotFoundDetailNullException("Row Cannot be Found for " + ENTITY_ID_LABEL + " : " + id);

        repo.delete(opt.get());
    }

    @Override
    public List<Cms> getEntityByKataKunci(String kataKunci) {
        List<Cms> result = repo.findByKataKunciLike("%" + kataKunci +"%");
        if (result.isEmpty())
            throw new RowNotFoundDetailNullException("Empty Result Set");

        return result;
    }

    @Override
    public List<Cms> getEntityByStatus(Integer status) {
        List<Cms> result = repo.findByStatus(status);
        if (result.isEmpty())
            throw new RowNotFoundDetailNullException("Empty Result Set");

        return result;
    }

    @Override
    public List<Cms> getEntityByType(Integer type) {
        List<Cms> result = repo.findByType(type);
        if (result.isEmpty())
            throw new RowNotFoundDetailNullException("Empty Result Set");

        return result;
    }
}
