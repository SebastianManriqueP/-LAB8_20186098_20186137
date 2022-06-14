package Servlets;

import Daos.CancionRecomenDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "listaRecomendados",urlPatterns = {"/listaRecomendados"})
public class TourServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CancionRecomenDao cancionRecomenDao = new CancionRecomenDao();

        request.setAttribute("listaRecomendados", cancionRecomenDao.obtenerCancionesRecom);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("listaTours.jsp");
        requestDispatcher.forward(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }
}