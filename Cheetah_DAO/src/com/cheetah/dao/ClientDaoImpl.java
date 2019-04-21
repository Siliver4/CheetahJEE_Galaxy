package com.cheetah.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.cheetah.beans.BeanException;
import com.cheetah.beans.Client;

public class ClientDaoImpl implements ClientDao {

    private DaoFactory daoFactory;

    ClientDaoImpl(DaoFactory daoFactory) {
        this.daoFactory = daoFactory;
    }

    @Override
    public void add(Client client) throws DaoException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = daoFactory.getConnection();
            preparedStatement = connection.prepareStatement("INSERT INTO t_client_cli(cli_surname, cli_name) VALUES(?, ?);");
            preparedStatement.setString(1, client.getSurname());
            preparedStatement.setString(2, client.getName());
            preparedStatement.executeUpdate();
            connection.commit();
        } catch (SQLException e1) {
            try {
                if (connection != null) {
                    connection.rollback();
                }
            } catch (SQLException e2) {
                throw new DaoException("[CHEETAH_DAO] Database communication error - e2", e2);
            }
            throw new DaoException("[CHEETAH_DAO] Database communication error - e1", e1);
        }
        finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                throw new DaoException("[CHEETAH_DAO] Error while attempting to close the connection with the database", e);
            }
        }

    }

    @Override
    public List<Client> list() throws DaoException {
        List<Client> clients = new ArrayList<Client>();
        Connection connection = null;
        Statement statement = null;
        ResultSet result = null;

        try {
            connection = daoFactory.getConnection();
            statement = connection.createStatement();
            result = statement.executeQuery("SELECT cli_surname, cli_name FROM t_client_cli;");

            while (result.next()) {
                String surname = result.getString("cli_surname");
                String name = result.getString("cli_name");

                Client client = new Client();
                client.setSurname(surname);
                client.setName(name);
                clients.add(client);
            }
        } catch (SQLException e) {
            throw new DaoException("[CHEETAH_DAO] Database communication error", e);
        } catch (BeanException e) {
            throw new DaoException("[CHEETAH_DAO] Database data are invalid", e);
        }
        finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                throw new DaoException("[CHEETAH_DAO] Error while attempting to close the connection with the database", e);
            }
        }
        return clients;
    }

}