package com.gotorscode.taskthree.service;

import com.gotorscode.taskthree.dto.UserDto;
import com.gotorscode.taskthree.model.UserEntity;
import com.gotorscode.taskthree.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public Long createUser(UserDto userDto) throws Exception {

        if (!StringUtils.hasText(userDto.getFirstName())
            || !StringUtils.hasText(userDto.getLastName())) {
            throw new Exception();
        }

        UserEntity userEntity = new UserEntity(userDto);
        userRepository.save(userEntity);

        return userEntity.getId();
    }

    public UserDto getUser(Long userId) throws Exception {

        UserEntity userEntity = userRepository.getById(userId);
        //UserEntity userEntity = (userRepository.getById(userId).getIsDeleted()) ? null : userRepository.getById(userId);

        if (userEntity == null) {
            throw new Exception();
        }

        return new UserDto(userEntity);
    }

    /*public void updateUser(Long userId, UserDto userDto) throws Exception {

        if (userId > id) {
            throw new Exception();
        }

        UserEntity userEntity = users.get(userId);

        if (!StringUtils.hasText(userDto.getFirstName())
            || !StringUtils.hasText(userDto.getLastName())) {
            throw new Exception();
        }

        userEntity.setFirstName(userDto.getFirstName());
        userEntity.setLastName(userDto.getLastName());
    }

    public void deleteUser(Long userId) throws Exception {

        if (userId > id) {
            throw new Exception();
        }

        UserEntity userEntity = users.get(userId);
        userEntity.setIsDeleted(true);
    }*/
}