package com.cz.lookportnews.entity.admin;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Role implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id ;

    private String roleName;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name="role_function",
            joinColumns={
                    @JoinColumn(name="roleId")
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "functionId")
            }
    )
    private List<Function> functionList;

}
