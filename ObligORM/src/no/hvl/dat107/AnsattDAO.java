package no.hvl.dat107;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AnsattDAO {
	static final String JDBC_DRIVER = "org.postgresql.Driver";
	static final String DB_URL = "jdbc:postgresql://129.151.221.119:5432/675218";
	static final String USER = "675218";
	static final String PASS = "Ha1FinDagIDag!";

	// finne ansatt med ID
	public Ansatt finnAnsattMedId(int id) {
		Ansatt ansatt = null;
		String sql = "SELECT * FROM Oblig3.Ansatt WHERE ansatt_id = ?";
		try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
				PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setInt(1, id);
			try (ResultSet rs = stmt.executeQuery()) {
				if (rs.next()) {
					int ansatt_id = rs.getInt("ansatt_id");
					String fornavn = rs.getString("fornavn");
					String etternavn = rs.getString("etternavn");
					String brukernavn = rs.getString("brukernavn");
					java.util.Date dato_ansatt = rs.getDate("dato_ansatt");
					String stilling = rs.getString("stilling");
					java.math.BigDecimal lonn_mnd = rs.getBigDecimal("lonn_mnd");
					int avdeling_id = rs.getInt("avdeling_id");

					ansatt = new Ansatt(ansatt_id, fornavn, etternavn, brukernavn, dato_ansatt, stilling, lonn_mnd,
							avdeling_id);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ansatt;
	}

	// Finne ansatt med brukernavnet
	public Ansatt finnAnsattMedBrukernavn(String brukernavn) {
		Ansatt ansatt = null;
		String sql = "SELECT * FROM Oblig3.Ansatt WHERE brukernavn = ?";
		try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
				PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setString(1, brukernavn);
			try (ResultSet rs = stmt.executeQuery()) {
				if (rs.next()) {
					int ansatt_id = rs.getInt("ansatt_id");
					String fornavn = rs.getString("fornavn");
					String etternavn = rs.getString("etternavn");
					java.util.Date dato_ansatt = rs.getDate("dato_ansatt");
					String stilling = rs.getString("stilling");
					java.math.BigDecimal lonn_mnd = rs.getBigDecimal("lonn_mnd");
					int avdeling_id = rs.getInt("avdeling_id");

					ansatt = new Ansatt(ansatt_id, fornavn, etternavn, brukernavn, dato_ansatt, stilling, lonn_mnd,
							avdeling_id);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ansatt;
	}

	// Liste alle ansatte
	public List<Ansatt> listAlleAnsatte() {
		List<Ansatt> ansatte = new ArrayList<>();
		String sql = "SELECT * FROM Oblig3.Ansatt";
		try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
				PreparedStatement stmt = conn.prepareStatement(sql);
				ResultSet rs = stmt.executeQuery()) {
			while (rs.next()) {
				int ansatt_id = rs.getInt("ansatt_id");
				String fornavn = rs.getString("fornavn");
				String etternavn = rs.getString("etternavn");
				String brukernavn = rs.getString("brukernavn");
				java.util.Date dato_ansatt = rs.getDate("dato_ansatt");
				String stilling = rs.getString("stilling");
				java.math.BigDecimal lonn_mnd = rs.getBigDecimal("lonn_mnd");
				int avdeling_id = rs.getInt("avdeling_id");

				Ansatt ansatt = new Ansatt(ansatt_id, fornavn, etternavn, brukernavn, dato_ansatt, stilling, lonn_mnd,
						avdeling_id);
				ansatte.add(ansatt);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ansatte;
	}

	// Oppdatere stilling og lønn
	public void oppdaterAnsattStillingOgLonn(int ansatt_id, String nyStilling, java.math.BigDecimal nyLonn) {
		String sql = "UPDATE Oblig3.Ansatt SET stilling = ?, lonn_mnd = ? WHERE ansatt_id = ?";
		try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
				PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setString(1, nyStilling);
			stmt.setBigDecimal(2, nyLonn);
			stmt.setInt(3, ansatt_id);
			stmt.executeUpdate();
			System.out.println("Oppdatering av ansatt vellykket.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void leggTilNyAnsatt(Ansatt nyAnsatt) {
        String sql = "INSERT INTO Oblig3.Ansatt (fornavn, etternavn, brukernavn, dato_ansatt, stilling, lonn_mnd, avdeling_id) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, nyAnsatt.getFornavn());
            stmt.setString(2, nyAnsatt.getEtternavn());
            stmt.setString(3, nyAnsatt.getBrukernavn());
            stmt.setDate(4, new java.sql.Date(nyAnsatt.getDatoAnsatt().getTime()));
            stmt.setString(5, nyAnsatt.getStilling());
            stmt.setBigDecimal(6, nyAnsatt.getLonnMnd());
            stmt.setInt(7, nyAnsatt.getAvdelingId());
            stmt.executeUpdate();
            System.out.println("Ny ansatt lagt til i databasen.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
