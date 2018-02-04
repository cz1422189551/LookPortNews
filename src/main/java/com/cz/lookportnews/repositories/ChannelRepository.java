package com.cz.lookportnews.repositories;

import com.cz.lookportnews.entity.Channel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface ChannelRepository extends JpaRepository<Channel , Long> ,
        JpaSpecificationExecutor<Channel>{
}
