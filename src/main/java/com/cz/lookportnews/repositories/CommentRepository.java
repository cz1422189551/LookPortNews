package com.cz.lookportnews.repositories;

import com.cz.lookportnews.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends JpaRepository<Comment ,Long> {
}
