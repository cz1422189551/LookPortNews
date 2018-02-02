package com.cz.lookportnews.entity;

import java.util.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;

/**
 * 新闻类
 * Created by 14221 on 2018/1/12.
 */


@AllArgsConstructor
@NoArgsConstructor
@Entity
public class News extends MultiMedia {

    //评论回复集合
    @OneToMany(cascade = CascadeType.ALL ,fetch = FetchType.LAZY)
    @JoinColumn(name = "newsId")
    private List<Comment> comments ;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="channelId")
    private Channel channel;


    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }





    //@DateTimeFormat(pattern = "yyyy-MM-dd")
    //投稿时间



}
