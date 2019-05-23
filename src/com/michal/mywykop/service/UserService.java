package com.michal.mywykop.service;

import com.michal.mywykop.dao.DAOFactory;
import com.michal.mywykop.dao.UserDao;
import com.michal.mywykop.model.User;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class UserService {

    public void addUser(String username, String email, String password) {
        User user = new User();
        user.setUsername(username);
        String md5Pass = encryptPassword(password);
        user.setPassword(md5Pass);
        user.setEmail(email);
        user.setActive(true);
        DAOFactory factory = DAOFactory.getDAOFactory();
        UserDao userDao = factory.getUserDAO();
        userDao.create(user);
    }

    private String encryptPassword(String password) {
        MessageDigest digest = null;
        try {
            digest = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        digest.update(password.getBytes());
        String md5Password = new BigInteger(1, digest.digest()).toString(16);
        return md5Password;
    }

    public User getUserById(long userId) {
        DAOFactory factory = DAOFactory.getDAOFactory();
        UserDao userDao = factory.getUserDAO();
        User user = userDao.read(userId);
        return user;
    }

    public User getUserByUsername(String username) {
        DAOFactory factory = DAOFactory.getDAOFactory();
        UserDao userDao = factory.getUserDAO();
        User user = userDao.getUserByUsername(username);
        return user;
    }
}