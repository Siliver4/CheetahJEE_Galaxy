package com.cheetah.dao;

import java.util.List;

import com.cheetah.beans.Client;

public interface ClientDao {

    void add(Client client) throws DaoException;

    List<Client> list() throws DaoException;
}