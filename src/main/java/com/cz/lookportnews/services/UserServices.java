package com.cz.lookportnews.services;

import com.cz.lookportnews.entity.ListResponse;
import com.cz.lookportnews.entity.Response;
import com.cz.lookportnews.entity.User;
import com.cz.lookportnews.exception.InsertException;
import com.cz.lookportnews.repositories.UserRepository;
import com.cz.lookportnews.util.ResponseFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.domain.Specifications;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sun.security.tools.keytool.Main;

import javax.persistence.criteria.*;
import java.io.IOException;
import java.util.*;

@Service
public class UserServices implements Services<User> {

    @Autowired
    UserRepository userRepository;

    public List<User> getAllUser() {
        List<User> users = new ArrayList<>();
        users = userRepository.findAll();
        return users;
    }


    @Override
    public Response<User> findone(String username) {
        return null;
    }

    @Override
    public Response<List<User>> findAll(String username) {
        return null;
    }

    @Override
    public Response<List<User>> queryAll(int pageNumber, int countSize) {
        return null;
    }

    @Override
    @Transactional
    public Response<User> insert(User user) {
        Response<User> response = null;
        try {
            userRepository.save(user);
        } catch (Exception e) {
            e.printStackTrace();

        }
        response = ResponseFactory.getResponse(user);
        System.out.println(response.toString());
        return response;
    }

    @Override
    public Response<User> update(User user) {
        return null;
    }

    @Override
    public Response<User> delete(User user) {
        return null;
    }

    @Override
    public Map<String, Object> findPage(Map<String, Object> param) {

        Integer pageSize = ((Integer) param.get("pageSize"));
        Integer pageNumber = (Integer) param.get("pageNumber");
//        Sort.Order order = new Sort.Order(Sort.Direction.DESC, "creatime");
//        Sort sort = new Sort(order);
        Pageable pageable = new PageRequest(pageNumber, pageSize);
//        Specification<User> specifications = new Specification<User>() {
//            @Override
//            public Predicate toPredicate(Root<User> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
//                Path<String> username = root.get("username");
//                Path<String> password = root.get("password");
//                cb.equal()
//
//
//                return null;
//            }
//        };
        Page<User> page = userRepository.findAll(pageable);
        System.out.println("查询总页数:"+page.getTotalPages());
        System.out.println("查询总记录数 :" +page.getTotalElements());
        System.out.println("查询的当前第几页:"+(page.getNumber()+1));
        System.out.println("查询的当前页的集合:"+page.getContent());
        System.out.println("查询的当前的记录数 :" +page.getNumberOfElements());
        Map<String,Object> result = new HashMap<>();
        result.put("total",page.getTotalElements());
        result.put("rows",page.getContent());
        return result;
    }


}
