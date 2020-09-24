package com.zkdlu.template.spring_java.service;

import com.zkdlu.template.spring_java.model.entity.User;
import com.zkdlu.template.spring_java.model.request.UserVO;
import com.zkdlu.template.spring_java.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public boolean createUser(UserVO userVo) {
        User user = (User) userVo.convertToDao();
        try {
            userRepository.save(user);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public List<UserVO> getUserAll() {
        List<User> users = userRepository.findAll();

        return users.stream()
                .map(user -> (UserVO)user.convertToVO())
                .collect(Collectors.toList());
    }

    public UserVO getUser(int id) {
        User user = userRepository.findById(id).get();

        return (UserVO) user.convertToVO();
    }

    public UserVO updateUser(int id, UserVO userVo) {
        User user = userRepository.findById(id).get();

        if (user != null) {
            user.setName(userVo.getName());
            user.setPassword(userVo.getPassword());

            return (UserVO) userRepository.save(user).convertToVO();
        }

        return null;
    }

    public boolean deleteUser(int id) {
        try {
            userRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
}
