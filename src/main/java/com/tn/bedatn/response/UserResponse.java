package com.tn.bedatn.response;

import com.tn.bedatn.model.User;
import jakarta.persistence.Entity;
import lombok.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserResponse {

    private String firstName;
    private String lastName;
    private String email;

    public  static UserResponse fromUser(User user){
        return UserResponse.builder()
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .email(user.getEmail())
                .build();
    }
}
