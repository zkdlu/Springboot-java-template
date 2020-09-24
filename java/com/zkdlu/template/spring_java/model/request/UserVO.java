package com.zkdlu.template.spring_java.model.request;

import com.zkdlu.template.spring_java.interfaces.EntityDao;
import com.zkdlu.template.spring_java.interfaces.EntityVO;
import com.zkdlu.template.spring_java.model.entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = "password")
public class UserVO implements EntityVO {
    private int id;
    private String name;
    private String password;

    @Override
    public EntityDao convertToDao() {
        User user = new User(name, password);
        return user;
    }
}
