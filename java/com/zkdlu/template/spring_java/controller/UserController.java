package com.zkdlu.template.spring_java.controller;

import com.zkdlu.template.spring_java.interfaces.CrudController;
import com.zkdlu.template.spring_java.model.request.UserVO;
import com.zkdlu.template.spring_java.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/users")
@RestController
public class UserController implements CrudController<UserVO, Integer>{
    @Autowired
    UserService userService;

    @Override
    public boolean create(UserVO model) {
        return userService.createUser(model);
    }

    @Override
    public List<UserVO> read() {
        return userService.getUserAll();
    }

    @Override
    public UserVO update(Integer key, UserVO model) {
        return userService.updateUser(key, model);
    }

    @Override
    public boolean delete(Integer key) {
        return userService.deleteUser(key);
    }

    @Override
    public UserVO readOne(Integer key) {
        return userService.getUser(key);
    }
}