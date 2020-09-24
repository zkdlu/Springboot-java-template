package com.zkdlu.template.spring_java.model.entity;

import com.zkdlu.template.spring_java.model.EntityDao;
import com.zkdlu.template.spring_java.model.EntityVO;
import com.zkdlu.template.spring_java.model.request.UserVO;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
@ToString(exclude = "password")
public class User implements EntityDao {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @NonNull
    @Column(length=100, nullable = false)
    private String name;

    @NonNull
    @Column(length = 255, nullable = false)
    private String password;

    @Override
    public EntityVO convertToVO() {
        UserVO userVo = new UserVO(id, name, password);
        return userVo;
    }
}
