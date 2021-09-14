package ari.nuryadi.testingbackend.service;

import ari.nuryadi.testingbackend.entity.dto.CmsDto;
import ari.nuryadi.testingbackend.entity.model.Cms;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface CmsService extends TestingBackendService<CmsDto, Cms> {
    Cms getModelFromDTOMultiPart(MultipartFile file, CmsDto dto, Cms model);

    void saveEntityMultipart(MultipartFile file, CmsDto dto);

    List<Cms> getEntityByKataKunci(String kataKunci);

    List<Cms> getEntityByStatus(Integer status);

    List<Cms> getEntityByType(Integer type);
}
