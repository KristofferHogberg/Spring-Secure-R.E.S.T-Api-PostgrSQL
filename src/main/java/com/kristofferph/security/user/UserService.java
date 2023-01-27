package com.kristofferph.security.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    private final UserRepository repository;

    @Autowired
    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public List<UserResponse> getAllUsers() {
        try {
            var users = repository.findAll();
            List<UserResponse> userResponses = new ArrayList<>();
            users.forEach(user -> {
                userResponses.add(new UserResponse(user.getFirstname(), user.getLastname(), user.getEmail()));
            });
            return userResponses;

        } catch (Exception e) {
            throw new IllegalStateException("Could not get users.");
        }
    }

    public UserResponse getUserByEmail(String email) {
        try {
            var user = repository.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException("No account found with email: "));
            UserResponse userResponse = new UserResponse(user.getFirstname(), user.getLastname(), user.getEmail());
            return userResponse;

        } catch (Exception e) {
            throw new IllegalStateException("Could not get user.");
        }

    }

    public void deleteUserById(Integer id) {
        try {
            repository.deleteById(id);

        } catch (Exception e) {

        }
    }

    public boolean userExist(Integer id){
        if(repository.existsById(id)) return true;
        return false;
    }

}
