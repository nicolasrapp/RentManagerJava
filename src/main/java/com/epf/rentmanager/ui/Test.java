package com.epf.rentmanager.ui;

import com.epf.rentmanager.dao.VehicleDao;
import com.epf.rentmanager.exception.DaoException;
import com.epf.rentmanager.exception.ServiceException;
import com.epf.rentmanager.model.Client;
import com.epf.rentmanager.model.Vehicle;
import com.epf.rentmanager.service.VehicleService;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

public class Test {

    public static void main(String [] args){

        try {
            System.out.println(VehicleService.getInstance().findById(1));
        } catch (ServiceException e) {
            throw new RuntimeException(e);
        }
    }

    public long create(Vehicle vehicle) throws ServiceException {
        return 0;
    }

    public Vehicle findByID(long id) throws ServiceException {
        return null;
    }

    public List<Vehicle> findAll() throws ServiceException {
        try{

            return VehicleDao.getInstance().findAll();
        } catch (DaoException e) {
            e.printStackTrace();
            throw new ServiceException();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

}
