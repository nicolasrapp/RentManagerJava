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


    public long create(Reservation reservation) throws ServiceException {
        // TODO: créer un reservation
        return 0;
    }


    public List<Reservation> findAll() throws ServiceException {
        List <Reservation> reservations = new ArrayList<Reservation>();
        try {
            reservations = reservationDao.findAll();
            for (int i=0; i<reservations.size(); i++){
                Client client = clientService.findById(reservations.get(i).getClientid());
                reservations.get(i).setClient(client);
                Vehicle vehicule = vehicleService.findById(reservations.get(i).getVehicleid());
                reservations.get(i).setVehicule(vehicule);
            }
            return reservations;
        } catch (DaoException e) {
            throw new RuntimeException(e);
        }
    }

    public Reservation findById(long id) throws ServiceException {
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

}
