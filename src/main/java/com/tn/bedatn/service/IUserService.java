package com.tn.bedatn.service;

import com.tn.bedatn.model.User;
import java.util.List;


public interface IUserService {
    User registerUser(User user);
    List<User> getUsers();
    void deleteUser(String email);
    User getUser(String email);
}
