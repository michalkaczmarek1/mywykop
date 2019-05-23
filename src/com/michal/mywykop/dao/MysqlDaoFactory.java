package com.michal.mywykop.dao;

public class MysqlDaoFactory extends DAOFactory {

    @Override
    public DiscoveryDao getDiscoveryDAO() {
        return new DiscoveryDaoImpl();
    }

    @Override
    public UserDao getUserDAO() {
        return new UserDaoImpl();
    }

}