package com.mci.commonerrors.nullvalue.pojonull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("pojonull")
@RestController
public class POJONullController {
    @Autowired
    private UserEntityRepository userEntityRepository;

    @Autowired
    private UserRepository userRepository;

    @PostMapping("wrong")
    public User wrong(@RequestBody UserDto user) {
        user.setName(String.format("guest%s", user.getName()));
        return userRepository.save(user);
    }

    @PostMapping("right")
    public UserEntity right(@RequestBody UserDto user) {
        if (user == null || user.getId() == null) {
            throw new IllegalArgumentException("User Id could not be empty");
        }

        UserEntity userEntity = userEntityRepository.findById(user.getId())
                .orElseThrow(() -> new IllegalArgumentException("User does not exist"));

        if (user.getName() != null) {
            userEntity.setName(user.getName().orElse(""));
        }

        userEntity.setNickname("guest" + userEntity.getName());

        if (user.getAge() != null) {
            userEntity.setAge(user.getAge().orElseThrow(() -> new IllegalArgumentException("User age could not be empty")));
        }

        return userEntityRepository.save(userEntity);
    }

}
