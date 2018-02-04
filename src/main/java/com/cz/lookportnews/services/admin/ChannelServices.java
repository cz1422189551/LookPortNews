package com.cz.lookportnews.services.admin;

import com.cz.lookportnews.entity.Channel;
import com.cz.lookportnews.repositories.ChannelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.*;
import java.util.List;

@Service
public class ChannelServices  {

    @Autowired
    ChannelRepository channelRepository ;

    public List<Channel> findAll(){
        List<Channel> channelList = null;

        Specification<Channel> channelSpecification = new Specification<Channel>() {
            @Override
            public Predicate toPredicate(Root<Channel> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                Path<Integer> id = root.get("id");
                Path<Channel> channel = root.get("channel");
                System.out.println(channel);
                return   cb.isNull(channel);
            }
        };
        channelList=channelRepository.findAll(channelSpecification);
        return channelList;
    }


//    public List<Channel> findSub(Long id ) {
//
//    }

}
