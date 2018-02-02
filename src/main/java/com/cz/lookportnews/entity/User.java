package com.cz.lookportnews.entity;

import java.io.Serializable;
import java.util.Date;

import com.sun.istack.internal.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * Created by 14221 on 2018/1/12.
 */
@AllArgsConstructor
@Data
@Entity
public class User implements Serializable {
    @Id
    @GeneratedValue(generator = "username")
    @GenericGenerator(name = "username",strategy="assigned")
    private String username ;

    private String password ;

    public User(){}

    @Column(nullable = false)
    private Date creatime;

    private Date loginlast;

    private Boolean gender;

    private Date birthday;


    private String nickName;


    private String phone;

    private String emaill;

}
