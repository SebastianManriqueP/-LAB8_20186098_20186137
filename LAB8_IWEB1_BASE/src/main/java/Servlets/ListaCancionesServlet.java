package Servlets;

import Beans.Cancion;
import Daos.CancionDao;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "ListaCancionesServlet", value = "/listaCanciones")
public class ListaCancionesServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String action = request.getParameter("a") == null ? "listar" : request.getParameter("a");
        CancionDao cancionDao = new CancionDao();


        switch (action) {
            case "listar" -> {
                ArrayList<Cancion> listaCanciones = cancionDao.obtenerCanciones();
                request.setAttribute("listaCancion",listaCanciones);

                RequestDispatcher view =request.getRequestDispatcher("listaCanciones.jsp");
                view.forward(request,response);
            }

            case"agregarFav"->{
                String cancionId = request.getParameter("id");
                cancionDao.agregarFav(cancionId);
                response.sendRedirect(request.getContextPath() + "/listaCanciones");
            }
            case"borrarFav"->{
                String cancionId = request.getParameter("id");
                cancionDao.borrarFav(cancionId);
                response.sendRedirect(request.getContextPath() + "/listaCanciones");
            }
            case"listarBanda"->{
                String bandaId=request.getParameter("id");
                ArrayList<Cancion> listaCanciones = cancionDao.obtenerlistacanciones(bandaId);
                request.setAttribute("listaCancion",listaCanciones);
                RequestDispatcher view =request.getRequestDispatcher("listaCanciones.jsp");
                view.forward(request,response);
            }
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
