package com.cz.lookportnews.services;

import com.cz.lookportnews.entity.Comment;
import com.cz.lookportnews.entity.MultiMedia;
import com.cz.lookportnews.entity.News;
import com.cz.lookportnews.entity.Response;
import com.cz.lookportnews.repositories.NewsRepository;
import com.cz.lookportnews.repositories.UserRepository;
import com.cz.lookportnews.util.ResponseFactory;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sun.security.tools.keytool.Main;

import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Service("newsServices")
public class NewsServices implements  ILazyMode<News>{

    @Autowired
    NewsRepository repository ;


    @Transactional
    public News saveNews(News news) {
            return repository.save(news);
    }



    public Response<List<News>> getAllNews(boolean lazyMode){
        List<News> newsList = null;
        newsList=repository.findAll();
        if(lazyMode){
            getTypeWithoutList(newsList);
        } else {
            getTypeWithList(newsList);
        }

        Response<List<News>> response =new Response<>();
        response.setErrorType(ResponseFactory.DeFalutSuccess);
        response.setSuccess(true);
        response.setErrorMessage(ResponseFactory.errorMessage(0));
        response.setResult(newsList);
        System.out.println("services" +response);
        return response;
    }


    @Override
    public List<News> getTypeWithList(List<News> list) {
        if(list!=null && list.size()>0){
            for (News news : list) {
                for (Comment comment : news.getComments()) {
                    comment.toString();
                }
            }
        }
        return list;
    }

    @Override
    public List<News> getTypeWithoutList(List<News> list) {
        if(list!=null && list.size()>0){
            for (News news : list) {
                news.setComments(null);
            }
        }
        return list;
    }
}
