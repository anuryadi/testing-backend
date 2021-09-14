package ari.nuryadi.testingbackend.controller;

import ari.nuryadi.testingbackend.entity.dto.ChallengeDto;
import ari.nuryadi.testingbackend.entity.dto.DetailChallengeDto;
import ari.nuryadi.testingbackend.entity.model.Challenge;
import ari.nuryadi.testingbackend.entity.model.User;
import ari.nuryadi.testingbackend.service.ChallengeService;
import ari.nuryadi.testingbackend.service.DetailChallengeService;
import ari.nuryadi.testingbackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/challenge")
public class ChallengeController extends BaseRestController<ChallengeDto> {
    @Autowired
    private ChallengeService service;

    @Autowired
    private UserService userService;

    @Autowired
    private DetailChallengeService detailChallengeService;

    @Override
    @GetMapping("/")
    public ResponseEntity retrieveAll() {
        getSuccessResponseList(service.getAllEntity(), RESPONSE_TYPE_ALL);

        return new ResponseEntity(successResponseList, HttpStatus.OK);
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity retrieveById(@PathVariable("id") Long id) {
        Challenge challenge = service.getEntityById(id);
        getSuccessResponseObject(challenge, RESPONSE_TYPE_READ);
        return new ResponseEntity(successResponse, HttpStatus.OK);
    }

    @Override
    public ResponseEntity delete(Long id) {
        return null;
    }

    @Override
    @PostMapping("/save")
    public ResponseEntity create(@RequestBody ChallengeDto entity) {
        DetailChallengeDto detailChallengeDto = new DetailChallengeDto();
        service.saveEntity(entity);

        List<User> resultUsers = userService.getAllEntity();
        if (!resultUsers.isEmpty()) {
            for (User user : resultUsers) {

                detailChallengeDto.setUserId(user.getId());
                detailChallengeDto.setChallengerId(entity.getId());
                detailChallengeDto.setKriteria(entity.getKriteria());

                detailChallengeService.saveEntity(detailChallengeDto);
            }
        }

        getSuccessResponseObject(entity, RESPONSE_TYPE_CREATE);
        return new ResponseEntity(successResponse, HttpStatus.OK);
    }

    @Override
    public ResponseEntity update(ChallengeDto entity) {
        return null;
    }
}
