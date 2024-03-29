package com.epf.rentmanager.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.epf.rentmanager.exception.DaoException;
import com.epf.rentmanager.model.Reservation;
import com.epf.rentmanager.model.Reservation;
import com.epf.rentmanager.persistence.ConnectionManager;
import org.springframework.stereotype.Repository;

import static com.epf.rentmanager.persistence.ConnectionManager.getConnection;
@Repository
public class ReservationDao {

	private static ReservationDao instance = null;
	private ReservationDao() {}


	private static final String CREATE_RESERVATION_QUERY = "INSERT INTO Reservation(client_id, vehicle_id, debut, fin) VALUES(?, ?, ?, ?);";
	private static final String DELETE_RESERVATION_QUERY = "DELETE FROM Reservation WHERE id=?;";
	private static final String FIND_RESERVATIONS_BY_CLIENT_QUERY = "SELECT id, vehicle_id, debut, fin FROM Reservation WHERE client_id=?;";
	private static final String FIND_RESERVATIONS_BY_VEHICLE_QUERY = "SELECT id, client_id, debut, fin FROM Reservation WHERE vehicle_id=?;";
	private static final String FIND_RESERVATIONS_QUERY = "SELECT id, client_id, vehicle_id, debut, fin FROM Reservation;";
	private static final String FIND_RESERVATION_QUERY = "SELECT id, client_id, vehicle_id, debut, fin FROM Reservation WHERE id=?;";
	private static final String COUNT_RESERVATIONS_QUERY = "SELECT COUNT(id) AS reservationsCount FROM Reservation;";
	public long create(Reservation reservation) throws DaoException {
		try {
			Connection conn = ConnectionManager.getConnection();
			PreparedStatement stmt = conn.prepareStatement(CREATE_RESERVATION_QUERY,
					Statement.RETURN_GENERATED_KEYS);
			stmt.setLong(1, reservation.getClient_id());
			stmt.setLong(2, reservation.getVehicle_id());
			stmt.setDate(3, Date.valueOf(reservation.getDebut()));
			stmt.setDate(4, Date.valueOf(reservation.getFin()));
			long key = ((PreparedStatement) stmt).executeUpdate();
			conn.close();
			return key;
		} catch (SQLException e) {
			throw new DaoException();
		}

	}

	public long delete(Reservation reservation) throws DaoException {
		try {
			Connection conn = ConnectionManager.getConnection();
			PreparedStatement stmt = conn.prepareStatement(DELETE_RESERVATION_QUERY,
					Statement.RETURN_GENERATED_KEYS);
			stmt.setLong(1, reservation.getId());
			long key = ((PreparedStatement) stmt).executeUpdate();
			conn.close();
			return key;
		} catch (SQLException e) {
			throw new DaoException();
		}
	}

	public ArrayList<Reservation> findResaByClientId(long clientId) throws DaoException {
		try {
			Connection conn = ConnectionManager.getConnection();
			PreparedStatement stmt = conn.prepareStatement(FIND_RESERVATIONS_BY_CLIENT_QUERY);
			stmt.setLong(1, clientId);
			ResultSet rs = stmt.executeQuery();

			ArrayList<Reservation> resaList = new ArrayList<Reservation>();
			while (rs.next()) {
				Reservation resa = new Reservation(rs.getInt("id"),
						(int) (clientId),
						rs.getInt("vehicle_id"),
						rs.getDate("debut").toLocalDate(),
						rs.getDate("fin").toLocalDate());
				resaList.add(resa);
			}
			conn.close();
			return resaList;
		} catch (SQLException e) {
			throw new DaoException();
		}
	}



	public List<Reservation> findResaByReservationId(long vehicleId) throws DaoException {
		return new ArrayList<Reservation>();
	}

	public List<Reservation> findAll() throws DaoException {
		try {
			Connection conn = ConnectionManager.getConnection();
			PreparedStatement stmt = conn.prepareStatement(FIND_RESERVATIONS_QUERY);
			ResultSet rs = stmt.executeQuery();
			ArrayList<Reservation> resaResultList = new ArrayList<Reservation>();
			while (rs.next()) {
				Reservation resa = new Reservation(rs.getInt("id"), rs.getInt("client_id"), rs.getInt("vehicle_id"),
						rs.getDate("debut").toLocalDate(), rs.getDate("fin").toLocalDate());
				resaResultList.add(resa);
			}
			conn.close();
			return resaResultList;
		} catch (SQLException e) {
			throw new DaoException();
		}
	}
	public Reservation findById(int id) throws DaoException{
		try {
			Connection conn = ConnectionManager.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(FIND_RESERVATION_QUERY);

			pstmt.setLong(1, id);

			ResultSet rs = pstmt.executeQuery();

			rs.next();

			int reservationClientId = rs.getInt("client_id");
			int reservationVehicleId = rs.getInt("vehicle_id");
			LocalDate reservationDebut = rs.getDate("debut").toLocalDate();
			LocalDate reservationFin = rs.getDate("fin").toLocalDate();

			Reservation reservation = new Reservation(id, reservationClientId, reservationVehicleId, reservationDebut, reservationFin);

			return reservation;

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	public long count() throws DaoException {
		int reservationsCount = 1;
		try {

			Connection conn = ConnectionManager.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(COUNT_RESERVATIONS_QUERY);

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				reservationsCount = rs.getInt(reservationsCount);
			}

			return reservationsCount;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	public ArrayList<Reservation> findResaByVehicleId(long clientId) throws DaoException {
		try {
			Connection conn = ConnectionManager.getConnection();
			PreparedStatement stmt = conn.prepareStatement(FIND_RESERVATIONS_BY_VEHICLE_QUERY);
			stmt.setLong(1, clientId);
			ResultSet rs = stmt.executeQuery();

			ArrayList<Reservation> resaList = new ArrayList<Reservation>();
			while (rs.next()) {
				Reservation resa = new Reservation(rs.getInt("id"),
						(int) (clientId),
						rs.getInt("vehicle_id"),
						rs.getDate("debut").toLocalDate(),
						rs.getDate("fin").toLocalDate());
				resaList.add(resa);
			}
			conn.close();
			return resaList;
		} catch (SQLException e) {
			throw new DaoException();
		}
	}
}