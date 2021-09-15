package ari.nuryadi.testingbackend.service.impl;

import ari.nuryadi.testingbackend.entity.dto.UserDto;
import ari.nuryadi.testingbackend.entity.model.User;
import ari.nuryadi.testingbackend.entity.repo.DetailChallengeRepo;
import ari.nuryadi.testingbackend.entity.repo.UserRepo;
import ari.nuryadi.testingbackend.service.UserService;
import ari.nuryadi.testingbackend.utils.exception.RowNotFoundDetailNullException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private static final String ENTITY_ID_LABEL = "User ID";
    private static final String ENTITY_ID_LABEL_EMAIL = "User Email";

    @Autowired
    private UserRepo repo;

    @Autowired
    private DetailChallengeRepo detailChallengeRepo;

    @Override
    public UserDto getDTOFromModel(User model) {
        return null;
    }

    @Override
    public User getModelFromDTO(UserDto dto, User model) {
        model.setId(dto.getId());
        Optional<User> opt = repo.findById(dto.getId());
        if (opt.isPresent()) {
            model.setName(dto.getName());
            model.setEmail(opt.get().getEmail());
            model.setPassword(dto.getPassword());
            model.setPhone(opt.get().getPhone());
            model.setPoin(opt.get().getPoin());
        } else {
            model.setName(dto.getName());
            model.setEmail(dto.getEmail());
            model.setPassword(dto.getPassword());
            model.setPhone(dto.getPhone());
            model.setPoin(0);
        }

        return model;
    }

    @Override
    public List<User> getAllEntity() {
        List<User> result = new ArrayList<>(repo.findAll());
        if (result.isEmpty())
            throw new RowNotFoundDetailNullException("Empty Result Set");
        return result;
    }

    @Override
    public User getEntityById(Long id) {
        Optional<User> opt = repo.findById(id);
        if (!opt.isPresent())
            throw new RowNotFoundDetailNullException("Row Cannot be Found for " + ENTITY_ID_LABEL + " : " + id);

        return opt.get();
    }

    @Override
    public User getEntityByEmail(String email) {
        Optional<User> opt = repo.findByEmail(email);
        if (!opt.isPresent())
            throw new RowNotFoundDetailNullException("Row Cannot be Found for " + ENTITY_ID_LABEL_EMAIL + " : " + email);

        return opt.get();
    }

    @Override
    public void sumPoint() {
        List<String> temp = new ArrayList<>();

        List<User> result = new ArrayList<>(repo.findAll());
        for (User user : result) {
            temp = detailChallengeRepo.findMatchByUser(user.getId());
            for (String tempData : temp) {
                System.out.println(tempData);
                String[] arrOfStr = tempData.split(",");
                Integer point;
                point = Integer.parseInt(arrOfStr[2]);

                repo.updatePointById(point, user.getId());
                if (arrOfStr[3] == "Done")
                    detailChallengeRepo.updateStatusByUserId(0, user.getId());
                else
                    detailChallengeRepo.updateStatusByUserId(1, user.getId());
            }
        }

        getRangking();
    }

    @Override
    public void getRangking() {
        List<String> list = repo.rangking();
        Integer rank, id;
        for (String data : list) {
            String[] arrOfStr = data.split(",");
            rank = Integer.parseInt(arrOfStr[2]);
            id = Integer.parseInt(arrOfStr[0]);
            repo.updateRangkingById(rank, id);
        }
    }

    @Override
    public void saveEntity(UserDto dto) {
        repo.save(getModelFromDTO(dto, new User()));
    }

    @Override
    public void updateEntity(UserDto dto) {

    }

    @Override
    public void deleteEntity(Long id) {
        Optional<User> opt = repo.findById(id);
        if (!opt.isPresent())
            throw new RowNotFoundDetailNullException("Row Cannot be Found for " + ENTITY_ID_LABEL + " : " + id);

        repo.delete(opt.get());
    }
}
