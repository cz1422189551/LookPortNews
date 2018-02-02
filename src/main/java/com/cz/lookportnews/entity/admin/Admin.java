package com.cz.lookportnews.entity.admin;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Created by 14221 on 2018/1/12.
 */
@AllArgsConstructor
@Data
@Entity
public class Admin implements Serializable {
    @Id
    @GeneratedValue(generator = "admin")
    @GenericGenerator(name = "admin",strategy="assigned")
    private String adminName ;

    private String password ;

    public Admin(){}

    @Column(nullable = false)
    private Date creatime;

    private Date loginlast;

    private Boolean gender;

    private Date birthday;

    private String nickName;

    private String phone;

    private String email;

    @ManyToMany(
            fetch = FetchType.EAGER
    )
    @JoinTable(
            name = "admin_role",
            joinColumns = {
                    @JoinColumn( name = "admin")
            },
            inverseJoinColumns = {
                    @JoinColumn( name = "roleId")
            }
    )
    private List<Role> roleList;


}
