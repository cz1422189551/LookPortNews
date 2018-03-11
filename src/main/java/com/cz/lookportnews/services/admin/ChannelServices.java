package com.cz.lookportnews.services.admin;

import com.cz.lookportnews.entity.Channel;
import com.cz.lookportnews.repositories.ChannelRepository;
import com.cz.lookportnews.specification.ChannelSpec;
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

        channelList=channelRepository.findAll(ChannelSpec.findRootChannel());
        return channelList;
    }

}
