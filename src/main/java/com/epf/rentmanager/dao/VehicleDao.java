package com.epf.rentmanager.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.epf.rentmanager.exception.DaoException;
import com.epf.rentmanager.model.Vehicle;
import com.epf.rentmanager.persistence.ConnectionManager;
import org.springframework.stereotype.Repository;

@Repository
public class VehicleDao {
	
	private VehicleDao() {}

	private static final String CREATE_VEHICLE_QUERY = "INSERT INTO Vehicle(constructeur, nb_places) VALUES(?, ?);";
	private static final String DELETE_VEHICLE_QUERY = "DELETE FROM Vehicle WHERE id=?;";
	private static final String FIND_VEHICLE_QUERY = "SELECT id, constructeur, nb_places FROM Vehicle WHERE id=?;";
	private static final String FIND_VEHICLES_QUERY = "SELECT id, constructeur, nb_places FROM Vehicle;";
	private static final String COUNT_VEHICLES_QUERY = "SELECT COUNT(id) AS vehiclesCount FROM Vehicle;";


	public long create(Vehicle vehicle) throws DaoException {
		int id = 0;
		try {
			Connection connection = ConnectionManager.getConnection();
			PreparedStatement ps = connection.prepareStatement(CREATE_VEHICLE_QUERY, Statement.RETURN_GENERATED_KEYS);

			ps.setString(1, vehicle.getConstructeur());
			ps.setInt(2, vehicle.getNbplace());

			ps.execute();

			ResultSet resultSet = ps.getGeneratedKeys();

			if (resultSet.next()){
				id = resultSet.getInt(1);
			}

			ps.close();
			connection.close();
			return id;

		} catch (SQLException e) {
			throw new DaoException();
		}	}

	public long delete(Vehicle vehicle) throws DaoException {
		return 0;
	}

	public Vehicle findById(long id) throws DaoException {
		return new Vehicle();
	}

	public List<Vehicle> findAll() throws DaoException, SQLException {

		List<Vehicle> vehicles = new ArrayList<Vehicle>();

		try{
			Connection connection = ConnectionManager.getConnection();
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery(FIND_VEHICLES_QUERY);

			while (rs.next()) {
				long id =rs.getLong("id");
				String constructor = rs.getString("constructeur");
				int nbPlace = rs.getInt("nb_places");

				vehicles.add(new Vehicle(id, constructor, nbPlace));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return vehicles;
		
	}

	public long count() throws DaoException {
		int vehiclesCount=1;
		try {

			Connection conn = ConnectionManager.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(COUNT_VEHICLES_QUERY);

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				vehiclesCount = rs.getInt(vehiclesCount);
			}

			return vehiclesCount;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	

}
