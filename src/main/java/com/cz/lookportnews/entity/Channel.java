package com.cz.lookportnews.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
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
@Entity
public class Channel implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id ;

    //栏目后缀url
    private String suffixUrl;

    //栏目前缀url，为顶级栏目才有前缀
    private String prefixUrl;

    private String name;


    //自关联
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "parentId")
    @JsonBackReference
    private Channel  channel ;


    @OneToMany(
            cascade = CascadeType.ALL
            ,mappedBy ="channel"
            ,fetch = FetchType.EAGER
    )
    @Fetch(FetchMode.SUBSELECT)

    @JsonIgnoreProperties(value = {"prefixUrl"})
    private List<Channel>  children = new ArrayList<>();


    @OneToMany(cascade = CascadeType.ALL ,fetch = FetchType.LAZY)
    @JoinColumn(name="channelId")
    private List<News>  newsList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSuffixUrl() {
        return suffixUrl;
    }

    public void setSuffixUrl(String suffixUrl) {
        this.suffixUrl = suffixUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<News> getNewsList() {
        return newsList;
    }

    public void setNewsList(List<News> newsList) {
        this.newsList = newsList;
    }

    public String getPrefixUrl() {
        return prefixUrl;
    }

    public void setPrefixUrl(String prefixUrl) {
        this.prefixUrl = prefixUrl;
    }

    public Channel getChannel() {
        return channel;
    }

    public void setChannel(Channel channel) {
        this.channel = channel;
    }

    public List<Channel> getChildren() {
        return children;
    }

    public void setChildren(List<Channel> children) {
        this.children = children;
    }
}
