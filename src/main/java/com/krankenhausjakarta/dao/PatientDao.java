package com.krankenhausjakarta.dao;


import servlet.DBConnection;
import com.krankenhausjakarta.dao.entity.Patient;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PatientDao {
    DBConnection dbInstance = DBConnection.getInstance();
    Connection conn = dbInstance.getConnect();

    public boolean register(Patient patient) throws SQLException {
        boolean result = false;
        SingletonIp singletonIp = SingletonIp.getInstance();

        try {
            String sql = "insert into krankenhausjakarta.patient(vorname, nachname, adresse, telefonnummer, versicherungsnummer, email, password, geburtstag, ipAdresse ) values(?,?, ?, ?, ?, ?, ?, ?, ?) ";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, patient.getVorname());
            ps.setString(2, patient.getNachname());
            ps.setString(3, patient.getAdresse());
            ps.setString(4, patient.getTelefonnummer());
            ps.setString(5, patient.getVersicherungsnummer());
            ps.setString(6, patient.getEmail());
            ps.setString(7, patient.getPassword());
            ps.setString(8, patient.getGeburtstag());
            ps.setString(9, singletonIp.getIp());

            int i = ps.executeUpdate();

            if (i == 1) {
                result = true;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }
}
