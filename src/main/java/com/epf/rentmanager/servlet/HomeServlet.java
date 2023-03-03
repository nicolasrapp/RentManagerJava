package com.epf.rentmanager.servlet;

import com.epf.rentmanager.exception.ServiceException;
import com.epf.rentmanager.service.ClientService;
import com.epf.rentmanager.service.ReservationService;
import com.epf.rentmanager.service.VehicleService;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/home")
public class HomeServlet extends HttpServlet {


	private static final long serialVersionUID = 1L;
	ClientService clientService;
	VehicleService vehicleService;
	ReservationService reservationService;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		try {

			request.setAttribute("usersCount", this.clientService.getInstance().count());

			request.setAttribute("vehiclesCount", this.vehicleService.getInstance().count());

			request.setAttribute("reservationsCount", this.reservationService.getInstance().count());


		} catch (ServiceException e) {
			e.printStackTrace();
		}

		this.getServletContext().getRequestDispatcher("/WEB-INF/views/home.jsp").forward(request, response);
	}

}
