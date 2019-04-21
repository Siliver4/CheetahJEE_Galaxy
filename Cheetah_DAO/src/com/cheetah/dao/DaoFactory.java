package com.cheetah.dao;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * DaoFactory is the implementation of the design pattern DAO.
 * It represents an access to a given database, and the ability to perform databases table operation using
 * XXXDao implementation.
 */
public class DaoFactory {

    private static final String PROPERTIES_FILE = "/com/cheetah/dao/dao.properties";
    private static final String PROPERTY_URL = "url";
    private static final String PROPERTY_DRIVER = "driver";
    private static final String PROPERTY_USERNAME = "username";
    private static final String PROPERTY_PASSWORD = "password";

    /**
     * Database url
     */
    private String url;

    /**
     * Database username
     */
    private String username;

    /**
     * Database password
     */
    private String password;

    DaoFactory(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    /**
     * return an instance of this class.
     * The instance is able to give access to the connection to a given database using getConnection() method.
     * The instance is able to give access to 'XXXDao' new instance able to perform action on database side.
     *
     * @return an instance of this class.
     */
    public static DaoFactory getInstance() throws DaoException {

        Properties properties = new Properties();
        String url;
        String driver;
        String username;
        String password;

        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        InputStream propertiesFile = classLoader.getResourceAsStream(PROPERTIES_FILE);

        if (propertiesFile == null) {
            throw new DaoException("[CHEETAH_DAO] The property file " + PROPERTIES_FILE + " not found");
        }

        try {
            properties.load(propertiesFile);
            url = properties.getProperty(PROPERTY_URL);
            driver = properties.getProperty(PROPERTY_DRIVER);
            username = properties.getProperty(PROPERTY_USERNAME);
            password = properties.getProperty(PROPERTY_PASSWORD);
        } catch (IOException e) {
            throw new DaoException("[CHEETAH_DAO] Impossible to load the property file " + PROPERTIES_FILE, e);
        }

        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            throw new DaoException("[CHEETAH_DAO] Driver not found in the classpath", e);
        }

        DaoFactory instance = new DaoFactory(url, username, password);
        return instance;
    }

    /**
     * return a Connection object which represents the database connection.
     *
     * @return a Connection object which represents the database connection
     * @throws SQLException
     */
    public Connection getConnection() throws SQLException {
        Connection connexion = DriverManager.getConnection(url, username, password);
        connexion.setAutoCommit(false);
        return connexion;
    }

    /**
     * return an instance of ClientDao able to perform action on database side.
     *
     * @return an instance of ClientDao able to perform action on database side
     */
    public ClientDao getClientDao() {
        return new ClientDaoImpl(this);
    }

}