package com.tn.bedatn.repository;

import com.tn.bedatn.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface CommentRepository extends JpaRepository<Comment, Long> {


    List<Comment> findByUserIdAndRoomId(@Param("userId") Long userId,
                                        @Param("roomId") Long roomId);

    List<Comment> findByRoomId(@Param("roomId") Long roomId);
}
