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
//    @JsonIgnoreProperties(value = {"multiMedia","parentFunction"})

    private List<Function> subFunctionList;

    private String icon ;

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getSerialNum() {
        return serialNum;
    }

    public void setSerialNum(Integer serialNum) {
        this.serialNum = serialNum;
    }

    public Integer getAccording() {
        return according;
    }

    public void setAccording(Integer according) {
        this.according = according;
    }

    public Function getFunction() {
        return function;
    }

    public void setFunction(Function function) {
        this.function = function;
    }

    public List<Function> getSubFunctionList() {
        return subFunctionList;
    }

    public void setSubFunctionList(List<Function> subFunctionList) {
        this.subFunctionList = subFunctionList;
    }
}
