package com.epf.rentmanager.servlet;

import com.epf.rentmanager.exception.DaoException;
import com.epf.rentmanager.exception.ServiceException;
import com.epf.rentmanager.model.Vehicle;
import com.epf.rentmanager.service.ClientService;
import com.epf.rentmanager.service.ReservationService;
import com.epf.rentmanager.service.VehicleService;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/vehicles/create")
public class VehicleCreateServlet extends HttpServlet {


    private static final long serialVersionUID = 1L;
    VehicleService vehicleService;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.getServletContext().getRequestDispatcher("/WEB-INF/views/vehicles/create.jsp").forward(request, response);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        String constructeur = request.getParameter("manufacturer");
        int seats = Integer.parseInt(request.getParameter("seats"));

        try{
            vehicleService.getInstance().create(new Vehicle(0,constructeur, seats));


        } catch (ServiceException e) {
            e.printStackTrace();
        } catch (DaoException e) {
            throw new RuntimeException(e);
        }


        response.sendRedirect("/rentmanager/vehicles");
    }

}

