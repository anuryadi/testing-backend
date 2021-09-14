package ari.nuryadi.testingbackend.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public interface TestingBackendService<E, T> {
    E getDTOFromModel(T model);

    T getModelFromDTO(E dto, T model) throws FileNotFoundException;

    List<T> getAllEntity();


    T getEntityById(Long id);

    void saveEntity(E dto);

    void updateEntity(E dto);

    void deleteEntity(Long id);

}
