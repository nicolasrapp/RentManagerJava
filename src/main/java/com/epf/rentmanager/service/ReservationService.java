package com.epf.rentmanager.service;

import com.epf.rentmanager.dao.ReservationDao;
import com.epf.rentmanager.exception.DaoException;
import com.epf.rentmanager.exception.ServiceException;
import com.epf.rentmanager.model.Client;
import com.epf.rentmanager.model.Reservation;
import com.epf.rentmanager.model.Vehicle;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
@Repository
public class ReservationService {

    private ReservationDao reservationDao;
    public static ReservationService instance;
    private ClientService clientService;
    private VehicleService vehicleService;


    private ReservationService(ReservationDao reservationDao) {
        this.reservationDao = reservationDao;
    }


    public long delete(Reservation reservation) throws ServiceException {
        try {
            return this.reservationDao.delete(reservation);
        } catch (DaoException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public long create(Reservation reservation) throws ServiceException {
        try {
            return this.reservationDao.create(reservation);
        } catch (DaoException e) {
            e.printStackTrace();
        }
        return 0;
    }


    public List<Reservation> findAll() throws ServiceException {
        try {
            return this.reservationDao.findAll();
        } catch (DaoException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Reservation findById(int id) throws ServiceException {
        try {
            return reservationDao.findById(id);
        } catch (DaoException e) {
            throw new RuntimeException(e);
        }
    }
    public long count() throws ServiceException {
        try {
            return this.reservationDao.count();
        }catch (DaoException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public ArrayList<Reservation> findResaByClientId(long id) throws ServiceException {
        try {
            return this.reservationDao.findResaByClientId(id);
        } catch (DaoException e) {
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<Reservation> findResaByVehicleId(long id) throws ServiceException {
        try {
            return this.reservationDao.findResaByVehicleId(id);
        } catch (DaoException e) {
            e.printStackTrace();
        }
        return null;
    }

}
