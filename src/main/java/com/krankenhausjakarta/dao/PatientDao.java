package com.krankenhausjakarta.dao;


import servlet.DBConnection;
import entity.Patient;
import servlet.PasswordEncrypt;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PatientDao {
    DBConnection dbInstance = DBConnection.getInstance();
    Connection conn = dbInstance.getConnect();

    public boolean register(Patient patient) throws SQLException {
        boolean result = false;
        SingletonIp singletonIp = SingletonIp.getInstance();

        try {
            String sql = "insert into krankenhausjakarta.patient(vorname, nachname, adresse, telefonnummer, patientversicherungsnummer, email, password, geburtstag, ipAdresse ) values(?,?, ?, ?, ?, ?, ?, ?, ?) ";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, patient.getVorname());
            ps.setString(2, patient.getNachname());
            ps.setString(3, patient.getAdresse());
            ps.setString(4, patient.getTelefonnummer());
            ps.setString(5, patient.getPatientversicherungsnummer());
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

    public Patient login(String email, String password) throws SQLException {
        Patient patient = null;

        try {
            String sql = "select * from krankenhausjakarta.patient where email=? and password=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, email);
            ps.setString(2,  PasswordEncrypt.encryptPassword(password));
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                patient = new Patient();
                //arzt.setPatientid(Integer.parseInt(rs.getString(1)));
                patient.setVorname(rs.getString(2));
                patient.setNachname(rs.getString(3));
                patient.setAdresse(rs.getString(4));
                patient.setTelefonnummer(rs.getString(5));
                patient.setPatientversicherungsnummer(rs.getString(6));
                patient.setEmail(rs.getString(7));
                patient.setPassword(rs.getString(8));
                patient.setGeburtstag(rs.getString(9));
                patient.setIpAdresse(rs.getString(10));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        conn.close();
        return patient;
    }

    public List<Patient> getAllPatient() {
        List<Patient> patientList = new ArrayList<Patient>();
        Patient patient = null;
        try {

            String sql = "select * from krankenhausjakarta.patient order by patientid desc";
            PreparedStatement ps = conn.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                patient = new Patient();
                patient.setPatientid(Integer.parseInt(rs.getString(1)));
                patient.setVorname(rs.getString(2));
                patient.setNachname(rs.getString(3));
                patient.setAdresse(rs.getString(4));
                patient.setTelefonnummer(rs.getString(5));
                patient.setPatientversicherungsnummer(rs.getString(6));
                patient.setEmail(rs.getString(7));
                patient.setPassword(rs.getString(8));
                patient.setGeburtstag(rs.getString(9));
                patient.setIpAdresse(rs.getString(10));
                patientList.add(patient);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return patientList;
    }
}
