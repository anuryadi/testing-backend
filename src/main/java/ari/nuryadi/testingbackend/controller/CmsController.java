package ari.nuryadi.testingbackend.controller;

import ari.nuryadi.testingbackend.entity.dto.CmsDto;
import ari.nuryadi.testingbackend.entity.model.Cms;
import ari.nuryadi.testingbackend.service.CmsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/cms")
public class CmsController extends BaseRestController<CmsDto> {
    @Autowired
    private CmsService service;

    @Override
    @GetMapping("/")
    public ResponseEntity retrieveAll() {
        getSuccessResponseList(service.getAllEntity(), RESPONSE_TYPE_ALL);
        return new ResponseEntity(successResponseList, HttpStatus.OK);
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity retrieveById(@PathVariable("id") Long id) {
        Cms cms = service.getEntityById(id);
        getSuccessResponseObject(cms, RESPONSE_TYPE_READ);
        return new ResponseEntity(successResponse, HttpStatus.OK);
    }


    @GetMapping("/{kata-kunci}/kata-kunci")
    public ResponseEntity retrieveByKataKunci(@PathVariable("kata-kunci") String kataKunci) {;
        getSuccessResponseList(service.getEntityByKataKunci(kataKunci), RESPONSE_TYPE_READ);
        return new ResponseEntity(successResponseList, HttpStatus.OK);
    }

    @GetMapping("/{status}/status")
    public ResponseEntity retrieveByStatus(@PathVariable("status") Integer status) {;
        getSuccessResponseList(service.getEntityByStatus(status), RESPONSE_TYPE_READ);
        return new ResponseEntity(successResponseList, HttpStatus.OK);
    }

    @GetMapping("/{type}/type")
    public ResponseEntity retrieveByType(@PathVariable("type") Integer type) {;
        getSuccessResponseList(service.getEntityByType(type), RESPONSE_TYPE_READ);
        return new ResponseEntity(successResponseList, HttpStatus.OK);
    }

    @Override
    @DeleteMapping("/{id}/delete")
    public ResponseEntity delete(@PathVariable("id") Long id) {
        Cms cms = service.getEntityById(id);

        service.deleteEntity(id);

        getSuccessResponseObject(cms, RESPONSE_TYPE_DELETE);
        return new ResponseEntity(successResponse, HttpStatus.OK);
    }

    @Override
    @PostMapping("/save")
    public ResponseEntity create(@RequestBody CmsDto entity) {
        service.saveEntity(entity);

        Cms cms = service.getEntityById(entity.getId());
        getSuccessResponseObject(cms, RESPONSE_TYPE_CREATE);
        return new ResponseEntity(successResponse, HttpStatus.OK);
    }

    @Override
    public ResponseEntity update(CmsDto entity) {
        return null;
    }
}
