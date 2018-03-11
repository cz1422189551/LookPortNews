package com.cz.lookportnews.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *  树状结构的频道栏目列表
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Channel implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id ;


    private String name;

    private String url ;

    private Integer accordion;

    private String fragmentName;

//    //自关联
//    @ManyToOne(fetch = FetchType.EAGER)
//    @JoinColumn(name = "parentId")
//    @JsonBackReference
//    private Channel  channel ;


//    @OneToMany(
//            cascade = CascadeType.ALL
//            ,mappedBy ="channel"
//            ,fetch = FetchType.EAGER
//    )
//    @Fetch(FetchMode.SUBSELECT)
////    @JsonIgnoreProperties(value = {"prefixUrl"})
//    private List<Channel>  children = new ArrayList<>();


//    @OneToMany(cascade = CascadeType.ALL ,fetch = FetchType.LAZY)
//    @JoinColumn(name="channelId")
//    @JsonBackReference
//    private List<News>  newsList;




}
