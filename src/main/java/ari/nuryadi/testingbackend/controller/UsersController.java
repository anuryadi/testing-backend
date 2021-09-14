package ari.nuryadi.testingbackend.controller;

import ari.nuryadi.testingbackend.entity.dto.DetailChallengeDto;
import ari.nuryadi.testingbackend.entity.dto.UserDto;
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
@RequestMapping("/api/v1/user")
public class UsersController extends BaseRestController<UserDto> {
    @Autowired
    private UserService service;

    @Autowired
    private ChallengeService challengeService;

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
        User user = service.getEntityById(id);
        getSuccessResponseObject(user, RESPONSE_TYPE_READ);

        return new ResponseEntity(successResponse, HttpStatus.OK);
    }

    @Override
    public ResponseEntity delete(Long id) {
        return null;
    }

    @Override
    @PostMapping("/save")
    public ResponseEntity create(@RequestBody UserDto entity) {
        DetailChallengeDto detailChallengeDto = new DetailChallengeDto();

        service.saveEntity(entity);

        List<Challenge> resultChallenges = challengeService.getAllEntity();
        if (!resultChallenges.isEmpty()){
            for (Challenge challenge : resultChallenges) {
                detailChallengeDto.setUserId(entity.getId());
                detailChallengeDto.setChallengerId(challenge.getId());
                detailChallengeDto.setKriteria(challenge.getKriteria());

                detailChallengeService.saveEntity(detailChallengeDto);
            }
        }

        User user = service.getEntityById(entity.getId());


        getSuccessResponseObject(user, RESPONSE_TYPE_CREATE);
        return new ResponseEntity(successResponse, HttpStatus.OK);
    }

    @Override
    public ResponseEntity update(UserDto entity) {
        return null;
    }
}
