package com.tn.bedatn.service;

import com.tn.bedatn.dto.CommentRequest;
import com.tn.bedatn.exception.DataNotFoundException;
import com.tn.bedatn.model.Comment;
import com.tn.bedatn.repository.CommentRepository;
import com.tn.bedatn.repository.RoomRepository;
import com.tn.bedatn.repository.UserRepository;
import com.tn.bedatn.dto.CommentDTO;
import com.tn.bedatn.response.CommentResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class CommentService implements ICommentService{

    private final CommentRepository commentRepository;

    private final UserRepository userRepository;

    private final RoomRepository roomRepository;


    @Override
    @Transactional
    public Comment insertComment(CommentRequest commentDTO) {
        Comment newComment = Comment
                .builder()
                .user(userRepository.findByEmail(commentDTO.getEmailUser()).get())
                .room(roomRepository.findById(commentDTO.getRoomId()).get())
                .content(commentDTO.getContent())
                .build();
        return commentRepository.save(newComment);
    }

    @Override
    @Transactional
    public void deleteComment(Long commentId) {
        commentRepository.deleteById(commentId);
    }

    @Override
    @Transactional
    public void updateComment(Long id, CommentDTO comment) {
        Comment existingComment = commentRepository.findById(id).orElseThrow(() -> new DataNotFoundException("Comment not found"));
        commentRepository.save(existingComment);
    }

    @Override
    public List<CommentResponse> getCommentsByUserAndRoom(Long userId, Long roomId) {
        List<Comment> comments = commentRepository.findByUserIdAndRoomId(userId, roomId);
        return comments.stream()
                .map(comment -> CommentResponse.fromCommentResponse(comment))
                .collect(Collectors.toList());
    }

    @Override
    public List<CommentResponse> getCommentsByRoom(Long roomId) {
        List<Comment> comments = commentRepository.findByRoomId(roomId);
        return comments.stream()
                .map(comment -> CommentResponse.fromCommentResponse(comment))
                .collect(Collectors.toList());
    }

}
