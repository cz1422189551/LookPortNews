package com.cz.lookportnews.entity.admin;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Function implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id ;

    private String name;

    private String url ;

    private Integer serialNum;

    private Integer according;


    //自关联
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "parentId")
    @JsonBackReference
    private Function function ;

    @OneToMany(
            cascade = CascadeType.ALL
            ,mappedBy ="function"
            ,fetch = FetchType.EAGER
    )
    @Fetch(FetchMode.SUBSELECT)
//    @JsonBackReference
    @JsonIgnoreProperties(value = {"multiMedia","parentFunction"})
    //改评论的回复
    private List<Function> subFunctionList;



}
