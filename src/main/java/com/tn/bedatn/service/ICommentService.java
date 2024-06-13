package com.tn.bedatn.service;


import com.tn.bedatn.dto.CommentRequest;
import com.tn.bedatn.exception.DataNotFoundException;
import com.tn.bedatn.model.Comment;
import com.tn.bedatn.dto.CommentDTO;
import com.tn.bedatn.response.CommentResponse;

import java.util.List;

public interface ICommentService {
    // Thêm một bình luận mới
    Comment insertComment(CommentRequest comment);

    // Xóa một bình luận
    void deleteComment(Long commentId);

    // Cập nhật nội dung của một bình luận
    void updateComment(Long id, CommentDTO comment) throws DataNotFoundException;

    // Xem tất cả các bình luận của một người dùng
    List<CommentResponse> getCommentsByUserAndRoom(Long userId, Long roomId);

    List<CommentResponse> getCommentsByRoom(Long roomId);
}
