package com.zkdlu.template.spring_java.service;

import com.zkdlu.template.spring_java.model.entity.User;
import com.zkdlu.template.spring_java.model.request.UserVO;
import com.zkdlu.template.spring_java.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;
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
        Optional<User> result = userRepository.findById(id);
        if (result.isPresent()) {
            User user = result.get();
            return (UserVO) user.convertToVO();
        }

        return null;
    }

    public UserVO updateUser(int id, UserVO userVo) {
        Optional<User> result = userRepository.findById(id);

        if (result.isPresent()) {
            User user = result.get();

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
