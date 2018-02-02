package com.cz.lookportnews.repositories;

import com.cz.lookportnews.entity.Channel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChannelRepository extends JpaRepository<Channel , Long> {
}
