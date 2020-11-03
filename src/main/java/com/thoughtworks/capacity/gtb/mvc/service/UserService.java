package com.thoughtworks.capacity.gtb.mvc.service;

import com.thoughtworks.capacity.gtb.mvc.dto.User;
import com.thoughtworks.capacity.gtb.mvc.exception.UserExistsException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    public static List<User> users = new ArrayList<>();

    public void register(User user) {
        if (users.size() > 0) {
            for (User userTmp : users) {
                if (userTmp.getUsername().equals(user.getUsername())) {
                    throw new UserExistsException("User already exists");
                }
            }
        }

        users.add(user);
    }

    public User login(String username, String password) {
        User user = new User();

        if (users.size() > 0) {
            for (User userTmp : users) {
                if (userTmp.getUsername().equals(username) && userTmp.getPassword().equals(password)) {
                    user = userTmp;
                }
            }
        }
        return user;
    }
}
