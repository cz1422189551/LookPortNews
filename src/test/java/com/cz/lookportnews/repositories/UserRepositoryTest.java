package com.cz.lookportnews.repositories;

import com.cz.lookportnews.config.ServiceConfig;
import com.cz.lookportnews.entity.*;
import com.cz.lookportnews.entity.admin.Admin;
import com.cz.lookportnews.entity.admin.Role;
import com.cz.lookportnews.repositories.admin.AdminRepository;
import com.cz.lookportnews.services.admin.AdminServices;
import com.cz.lookportnews.services.admin.RoleServices;
import com.cz.lookportnews.util.GsonUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;



public class UserRepositoryTest {

    ClassPathXmlApplicationContext context = null ;
    AnnotationConfigApplicationContext annotationContext=null;

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

    AdminRepository adminRepository=null ;

    @Test
    public void testAdminRepository () {
        adminRepository = (AdminRepository) context.getBean("adminRepository");
        Admin admin = new Admin();
        admin.setAdminName("admin");
        admin.setPassword("admin");
        Admin admin1 = adminRepository.validateAdmin("admin","admin");
        System.out.println(admin1);
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

    @Test
    public void testAdminAuthorization () {
        Admin admin  =null;


        AdminServices adminServices = (AdminServices) annotationContext.getBean("adminServices");

        admin=adminServices.findOne("admin");


        RoleServices roleServices = (RoleServices) annotationContext.getBean("roleServices");


        List<Role> roles =null;

        roles=roleServices.findAllRole();


        Admin admin1 = adminServices.authorizationSave(admin, roles);
        System.out.println(admin1);
    }



    @Before
    public void init(){
        context = new ClassPathXmlApplicationContext("classpath:config/spring-database.xml");
        annotationContext = new AnnotationConfigApplicationContext(ServiceConfig.class);
        context.start();
        annotationContext.start();
        newsRepository = (NewsRepository) context . getBean("newsRepository");

    }
    @After
    public void destroy(){
        context = null ;
        repository = null;
        newsRepository=null;
    }

}