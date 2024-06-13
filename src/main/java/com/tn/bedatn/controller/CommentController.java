package com.tn.bedatn.controller;

import com.tn.bedatn.dto.CommentRequest;
import com.tn.bedatn.model.Comment;
import com.tn.bedatn.dto.CommentDTO;
import com.tn.bedatn.response.CommentResponse;
import com.tn.bedatn.service.CommentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/comment")
public class CommentController {
    private final CommentService commentService;
    @GetMapping("/get")
//    @PreAuthorize("permitAll()")
    public ResponseEntity<List<CommentResponse>> getAllComments(
            @RequestParam(value = "user_id", required = false) Long user_id,
            @RequestParam("room_id") Long room_id
    ){
        List<CommentResponse> commentResponses;
        if (user_id == null){
            commentResponses = commentService.getCommentsByRoom(room_id);
        }else {
            commentResponses = commentService.getCommentsByUserAndRoom(user_id, room_id);
        }
        return ResponseEntity.ok(commentResponses);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')")
    public ResponseEntity<?> updateComment(
            @PathVariable Long commentId,
            @Valid @RequestBody CommentDTO commentDTO,
            Authentication authentication
    )
    {
        try{
            commentService.updateComment(commentId, commentDTO);
            return ResponseEntity.ok("Update successfully!");
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred during comment update");
        }
    }

    @PostMapping("/insert")
//    @PreAuthorize("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')")
    public ResponseEntity<?> insertComment(
            @Valid @RequestBody CommentRequest commentDTO
    )
    {
        try{
            commentService.insertComment(commentDTO);
            return ResponseEntity.ok("Insert successfully!");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred during comment insert");
        }
    }
}
