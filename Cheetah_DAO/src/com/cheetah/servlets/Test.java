package com.cheetah.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cheetah.beans.Client;
import com.cheetah.dao.*;

/**
 * Servlet implementation class Test
 */
@WebServlet("/Test")
public class Test extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private ClientDao clientDao;

    public void init() throws ServletException {
        try {
            DaoFactory daoFactory = DaoFactory.getInstance();
            this.clientDao = daoFactory.getClientDao();
        } catch (DaoException e) {
            throw new ServletException("[CHEETAH_DAO] DaoFactory initialization error", e);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            request.setAttribute("clients", clientDao.list());
        } catch (DaoException e) {
            request.setAttribute("error", e.getMessage());
        }
        this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/test.jsp").forward(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            Client client = new Client();
            client.setSurname(request.getParameter("surname"));
            client.setName(request.getParameter("name"));
            clientDao.add(client);
            request.setAttribute("clients", clientDao.list());

        } catch (Exception e) {
            request.setAttribute("error", e.getMessage());
        }
        this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/test.jsp").forward(request, response);
    }

}