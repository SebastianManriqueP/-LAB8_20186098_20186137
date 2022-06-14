package Servlets;

import Beans.Tour;
import Beans.TPC;
import Daos.TourDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "TourporCiudad Servlet",urlPatterns = {"/listaToursporciudad"})
public class TourServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        TourDao tourDao = new TourDao();
        ArrayList<TPC> listaToursporCiudad = tourDao.obtenerListaToursporciudad();

        request.setAttribute("listaToursporciudad",listaToursporCiudad);

        RequestDispatcher view =request.getRequestDispatcher("listaToursporciudad.jsp");
        view.forward(request,response);
    }
}