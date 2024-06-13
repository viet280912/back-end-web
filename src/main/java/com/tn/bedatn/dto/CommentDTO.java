package com.tn.bedatn.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder

public class CommentDTO {
    @JsonProperty("user_id")
    private Long userId;

    @JsonProperty("room_id")
    private Long roomId;

    @JsonProperty("content")
    private String content;
}
