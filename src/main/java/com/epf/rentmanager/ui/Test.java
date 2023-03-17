package com.epf.rentmanager.ui;

import com.epf.rentmanager.configuration.AppConfiguration;
import com.epf.rentmanager.dao.ClientDao;
import com.epf.rentmanager.dao.VehicleDao;
import com.epf.rentmanager.exception.DaoException;
import com.epf.rentmanager.exception.ServiceException;
import com.epf.rentmanager.model.Client;
import com.epf.rentmanager.model.Vehicle;
import com.epf.rentmanager.service.ClientService;
import com.epf.rentmanager.service.VehicleService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

public class Test {

    ClientService clientService;
    VehicleService vehicleService;
    VehicleDao vehicleDao;


    public static void main(String [] args){

        ApplicationContext context= new AnnotationConfigApplicationContext(AppConfiguration.class);
        ClientService clientService = context.getBean(ClientService.class);
        VehicleService vehicleService = context.getBean(VehicleService.class);
    }

    public long create(Vehicle vehicle) throws ServiceException {
        return 0;
    }

    public Vehicle findByID(long id) throws ServiceException {
        return null;
    }

    public List<Vehicle> findAll() throws ServiceException {
        try{

            return vehicleDao.findAll();
        } catch (DaoException e) {
            e.printStackTrace();
            throw new ServiceException();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

}
