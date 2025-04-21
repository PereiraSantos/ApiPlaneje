package com.api.planeje.user.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.api.planeje.user.dao.UserRepository;
import com.api.planeje.user.entity.User;


@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public String  auth(User body) {
        User user = new  User();
        user.setLogin(body.getLogin());
        user.setPassword(body.getPassword());

       User userAuth =  userRepository.auth(user.getLogin(), user.getPassword());
       if (userAuth != null) {
        return "ujhjdfbcfhjsdbbsbhjk";
       } else {
        return "";
       }
     
    }

    public String saveUser(User body) {
        User user = new  User();
        user.setLogin(body.getLogin());
        user.setPassword(body.getPassword());


        userRepository.save(user);
        return "Salvo com succeso!!!";
    }
    
}
