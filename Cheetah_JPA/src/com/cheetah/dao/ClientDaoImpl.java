package com.cheetah.dao;

import java.util.ArrayList;
import java.util.List;

import com.cheetah.entities.Client;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
public class ClientDaoImpl {

    private static final String JPQL_SELECT_ALL = "SELECT c.surname, c.name FROM Client c";
    private static final String JPQL_SELECT_BY_ID = "SELECT c FROM Client c WHERE c.id=:id";
    private static final String PARAM_ID = "id";

    @PersistenceContext(unitName = "cheetah_PU")
    private EntityManager em;

    public void add(Client client) throws DaoException {
        try {
            em.persist(client);
        } catch (Exception e) {
            throw new DaoException("[CHEETAH_JPA] ", e);
        }
    }

    public Client findById(Long id) throws DaoException {
        Client client = null;
        Query query = em.createQuery(JPQL_SELECT_BY_ID);
        query.setParameter(PARAM_ID, id);

        try {
            client = (Client) query.getSingleResult();
        } catch ( NoResultException e ) {
            return null;
        } catch ( Exception e ) {
            throw new DaoException("[CHEETAH_JPA] ", e);
        }
        return client;
    }

    public List<Client> list() throws DaoException {
        List<Client> clients = new ArrayList<Client>();
        Query query = em.createQuery(JPQL_SELECT_ALL);

        try {
            clients = (List<Client>) query.getResultList();
        } catch ( Exception e ) {
            throw new DaoException("[CHEETAH_JPA] ", e);
        }
        return clients;
    }

}