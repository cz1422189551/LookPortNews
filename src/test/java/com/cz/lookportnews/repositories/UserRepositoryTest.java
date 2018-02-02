package com.cz.lookportnews.repositories;

import com.cz.lookportnews.config.MyDispatcherServlet;
import com.cz.lookportnews.entity.*;
import com.cz.lookportnews.util.GsonUtils;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import ikidou.reflect.TypeBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.domain.Specifications;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Date;
import java.util.List;



public class UserRepositoryTest {

    ClassPathXmlApplicationContext context = null ;

    UserRepository repository = null ;

    NewsRepository newsRepository = null;

    CommentRepository commentRepository = null ;

    ChannelRepository channelRepository =null ;

    @Test
    public void testChannel () {
        channelRepository = (ChannelRepository) context.getBean("channelRepository");
        Channel channel = new Channel();
        channel.setName("NBA");
        channel.setPrefixUrl("sport");
        channel.setSuffixUrl("nba");

        Channel channel2 = new Channel();
        channel2.setName("CBA");
        channel2.setPrefixUrl("sport");
        channel2.setSuffixUrl("cba");

        Channel parent  = new Channel();
        parent.setId(1L);

        channel.setChannel(parent);
        channel2.setChannel(parent);

        channelRepository.save(channel);
        channelRepository.save(channel2);

    }





    @Test
    public void testQuery () {
        List<News>  news = newsRepository.findAll();
        for (News news1 : news) {
            System.out.println("新闻 ： " +news1);
            for (Comment comment : news1.getComments()) {
                System.out.println(comment.getUser().getUsername()+"的评论 ：" +comment.getCommentContent());

            }

        }
    }
    @Test
    public void testGson () {

        String json ="";

        Response response = GsonUtils.fromJsonArray(json,News.class);
        System.out.println("response "+ response);

        List<News> news = (List<News>) response.getResult();
        for (News news1 : news) {
            GsonUtils.printJson(news1);
            System.out.println("==============");
            for (Comment comment : news1.getComments()) {
                System.out.println("comment " +comment.toString());
            }
        }



    }



    @Test
    public void testComment () {

        User user  =  new User();

        user.setUsername("周杰伦");
        user.setPassword("222");


        newsRepository = (NewsRepository) context . getBean("newsRepository");
        News news = new News();
        news.setTime(new Date());
        news.setContent("第一条新闻");
        news.setDescription("简介");
        news.setOrigin("新华社");
        news.setTitle("今日头条");
        news.setId(new Long(1));

        commentRepository =
                (CommentRepository) context.getBean("commentRepository");
        Comment comment = new Comment();
        comment.setUser(user);
        comment.setCommentContent("回复cz的评论");
        comment.setMultiMedia(news);
        comment.setTime(new Date());
        Comment comment1 = new Comment();
        comment1.setId(new Long(1));
        comment.setParentComment(comment1);

        commentRepository.save(comment);
    }



    @Test
    public void testUser2 () {
        repository = (UserRepository) context.getBean("userRepository");
        User user  =  new User();

        user.setUsername("周杰伦");
        user.setPassword("222");
        repository.save(user);
    }


    @Test
    public void testUser () {
        repository = (UserRepository) context.getBean("userRepository");
        User user  =  new User();
        user.setUsername("cz");
        user.setPassword("1234");
       // repository.save(user);

        newsRepository = (NewsRepository) context . getBean("newsRepository");

        News news = new News();
        news.setTime(new Date());
        news.setContent("第一条新闻");
        news.setDescription("简介");
        news.setOrigin("新华社");
        news.setTitle("今日头条");
      //  newsRepository.save(news);

        commentRepository =
                (CommentRepository) context.getBean("commentRepository");
        Comment comment = new Comment();
        comment.setUser(user);
        comment.setCommentContent("我是" + user.getUsername()+"的评论");
        comment.setMultiMedia(news);
        comment.setTime(new Date());
        comment.setParentComment(null);

        commentRepository.save(comment);


    }


    @Before
    public void init(){
        context = new ClassPathXmlApplicationContext("classpath:config/spring-database.xml");
        context.start();
        newsRepository = (NewsRepository) context . getBean("newsRepository");
    }
    @After
    public void destroy(){
        context = null ;
        repository = null;
        newsRepository=null;
    }

}