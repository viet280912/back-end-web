package com.tn.bedatn.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class CommentRequest {
    @JsonProperty("email")
    private String emailUser;

    @JsonProperty("room_id")
    private Long roomId;

    @JsonProperty("content")
    private String content;
}
