package com.michal.mywykop.dao;

import java.util.List;

import com.michal.mywykop.model.User;


public interface UserDao extends GenericDAO<User, Long> {

    List<User> getAll();
    User getUserByUsername(String username);

}