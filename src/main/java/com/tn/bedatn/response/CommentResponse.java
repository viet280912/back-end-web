package com.tn.bedatn.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.tn.bedatn.model.Comment;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class CommentResponse {
    @JsonProperty("content")
    private String content;

    @JsonProperty("time")
    private LocalDateTime time;

    @JsonProperty("user")
    private UserResponse userResponse;

    public static CommentResponse fromCommentResponse(Comment comment){
        return CommentResponse.builder()
                .content(comment.getContent())
                .time(comment.getCreatedAt())
                .userResponse(UserResponse.fromUser(comment.getUser()))
                .build();
    }
}
