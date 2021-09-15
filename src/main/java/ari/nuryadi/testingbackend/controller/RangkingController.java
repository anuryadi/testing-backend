package ari.nuryadi.testingbackend.controller;

import ari.nuryadi.testingbackend.entity.dto.RangkingDto;
import ari.nuryadi.testingbackend.service.RangkingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/api/rangking")
public class RangkingController extends BaseRestController<RangkingDto> {
    @Autowired
    private RangkingService service;

    @Override
    @GetMapping("/")
    public ResponseEntity retrieveAll() {
        getSuccessResponseList(service.getAllEntity(), RESPONSE_TYPE_ALL);

        return new ResponseEntity(successResponseList, HttpStatus.OK);
    }

    @Override
    public ResponseEntity retrieveById(Long id) {
        return null;
    }

    @Override
    public ResponseEntity delete(Long id) {
        return null;
    }

    @Override
    public ResponseEntity create(RangkingDto entity) {
        return null;
    }

    @Override
    public ResponseEntity update(RangkingDto entity) {
        return null;
    }
}
