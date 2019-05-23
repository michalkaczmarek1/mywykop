package com.michal.mywykop.dao;

import com.michal.mywykop.exception.NoSuchDbTypeException;

public abstract class DAOFactory {

    public static final int MYSQL_DAO_FACTORY = 1;

    public abstract DiscoveryDao getDiscoveryDAO();

    public abstract UserDao getUserDAO();

    public static DAOFactory getDAOFactory() {
        DAOFactory factory = null;
        try {
            factory = getDAOFactory(MYSQL_DAO_FACTORY);
        } catch (NoSuchDbTypeException e) {
            e.printStackTrace();
        }
        return factory;
    }

    private static DAOFactory getDAOFactory(int type) throws NoSuchDbTypeException {
        switch (type) {
            case MYSQL_DAO_FACTORY:
                return new MysqlDaoFactory();
            default:
                throw new NoSuchDbTypeException();
        }
    }
}