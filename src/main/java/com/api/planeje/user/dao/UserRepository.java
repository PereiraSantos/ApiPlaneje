package com.api.planeje.user.dao;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.NativeQuery;
import org.springframework.stereotype.Repository;


import com.api.planeje.user.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    @NativeQuery(value = "select * from users where login = :login and password = :password")
    User auth(String login, String password);
}