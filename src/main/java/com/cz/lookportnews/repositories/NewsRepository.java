package com.cz.lookportnews.repositories;

import com.cz.lookportnews.entity.MultiMedia;

import com.cz.lookportnews.entity.News;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface NewsRepository extends JpaRepository<News, Long> {

//    @Query(nativeQuery = true ,value = "select n.* from news n LEFT JOIN `comment` c ON n.id=c.news_id and c.fath_comment_id=NULL")
//    public List<News> testNews();


    @Query(
            value = "select news  " +
                    "from News news " +
                    "where news.channel.name=:name and news.time=:time"
    )
    public List<News> findNewsByChanl(@Param("name")String name,@Param("time") Date time);




}
