package com.cz.lookportnews.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;

/**
 * 评论
 * Created by 14221 on 2018/1/12.
 */

@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Comment implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id ;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "newsId")
    @JsonBackReference
    private News multiMedia;

    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name="user")
    private User user ;

    //自关联
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "fathCommentId")
    @JsonBackReference
    private Comment  parentComment ;


    //评论内容
    private String commentContent ;

    @OneToMany(
            cascade = CascadeType.ALL
            ,mappedBy ="parentComment"
            ,fetch = FetchType.EAGER
    )
    @Fetch(FetchMode.SUBSELECT)
//    @JsonBackReference
    @JsonIgnoreProperties(value = {"multiMedia","parentComment"})
    //改评论的回复
    private List<Comment>  subComment = new ArrayList<>();

    //评论时间
    private Date time ;

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

    public News getMultiMedia() {
        return multiMedia;
    }

    public void setMultiMedia(News multiMedia) {
        this.multiMedia = multiMedia;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Comment getParentComment() {
        return parentComment;
    }

    public void setParentComment(Comment parentComment) {
        this.parentComment = parentComment;
    }

    public String getCommentContent() {
        return commentContent;
    }

    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent;
    }

    public List<Comment> getSubComment() {
        return subComment;
    }

    public void setSubComment(List<Comment> subComment) {
        this.subComment = subComment;
    }



    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}
