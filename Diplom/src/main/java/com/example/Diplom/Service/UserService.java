package com.example.Diplom.Service;

import com.example.Diplom.Model.User;

import java.util.List;

public interface UserService {
    public void saveUser(User user);
    public List<Object> isUserPresent(User user);
}
