package com.epf.rentmanager.service;

import java.sql.SQLException;
import java.util.List;

import com.epf.rentmanager.dao.ClientDao;
import com.epf.rentmanager.exception.DaoException;
import com.epf.rentmanager.exception.ServiceException;
import com.epf.rentmanager.model.Vehicle;
import com.epf.rentmanager.dao.VehicleDao;
import org.springframework.stereotype.Service;

@Service
public class VehicleService {

	private VehicleDao vehicleDao;
	public static VehicleService instance;
	
	private VehicleService(VehicleDao vehicleDao) {
		this.vehicleDao = vehicleDao;
	}

	
	
	public long create(Vehicle vehicle) throws ServiceException, DaoException {
		long id = vehicleDao.create(vehicle);

		return id;
	}

	public long delete(Vehicle vehicle) throws ServiceException {
		try {
			return this.vehicleDao.delete(vehicle);
		} catch (DaoException e) {
			e.printStackTrace();
		}
		return 0;
	}

	public Vehicle findById(long id) throws ServiceException {
		// TODO: récupérer un véhicule par son id

		return null;
	}

	public List<Vehicle> findAll() throws ServiceException {
		try{
			return vehicleDao.findAll();
		}catch(DaoException e){
			e.printStackTrace();
			throw new ServiceException();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public long count() throws ServiceException {
		try {
			return this.vehicleDao.count();
		}catch (DaoException e) {
			e.printStackTrace();
		}
		return 0;
	}

	public List<Vehicle> findVehicleByClientId(long id) throws ServiceException {
		try {
			return this.vehicleDao.findVehicleByClientId(id);
		} catch (DaoException e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
