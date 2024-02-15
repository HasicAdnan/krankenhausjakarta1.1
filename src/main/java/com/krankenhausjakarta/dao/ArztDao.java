package com.krankenhausjakarta.dao;


import com.krankenhausjakarta.servlet.DBConnection;
import com.krankenhausjakarta.entity.Arzt;
import com.krankenhausjakarta.servlet.PasswordEncrypt;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ArztDao {

        DBConnection dbInstance = DBConnection.getInstance();
        Connection conn = dbInstance.getConnect();



    public boolean register(Arzt arzt) throws SQLException {
        boolean result = false;
        SingletonIp singletonIp = SingletonIp.getInstance();

        try {
            String sql = "insert into krankenhausjakarta.arzt(vorname, nachname, adresse, telefonnummer, versicherungsnummer, email, password, ipadresse ) values(?,?, ?, ?, ?, ?, ?, ?) ";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, arzt.getVorname());
            ps.setString(2, arzt.getNachname());
            ps.setString(3, arzt.getAdresse());
            ps.setString(4, arzt.getTelefonnummer());
            ps.setString(5, arzt.getVersicherungsnummer());
            ps.setString(6, arzt.getEmail());
            ps.setString(7, arzt.getPassword());
            ps.setString(8, singletonIp.getIp());

            int i = ps.executeUpdate();

            if (i == 1) {
                result = true;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        conn.close();
        return result;
    }

    public Arzt login(String email, String password) throws SQLException {
        Arzt arzt = null;

        try {
            String sql = "select * from krankenhausjakarta.arzt where email=? and password=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, email);
            ps.setString(2,  PasswordEncrypt.encryptPassword(password));
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                arzt = new Arzt();
                //arzt.setArztid(Integer.parseInt(rs.getString(1)));
                arzt.setVorname(rs.getString(2));
                arzt.setNachname(rs.getString(3));
                arzt.setAdresse(rs.getString(4));
               arzt.setTelefonnummer(rs.getString(5));
               arzt.setVersicherungsnummer(rs.getString(6));
               arzt.setEmail(rs.getString(7));
                arzt.setPassword(rs.getString(8));
               arzt.setGeburtstag(rs.getString(9));
                arzt.setIpAdresse(rs.getString(10));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        conn.close();
        return arzt;
    }

    public boolean checkOldPassword(int userid, String oldPassword) {
        boolean f = false;

        try {
            String sql = "select * from user_dtls where id=? and password=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, userid);
            ps.setString(2, oldPassword);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                f = true;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return f;
    }

    public boolean changePassword(int userid, String newPassword) {
        boolean f = false;

        try {
            String sql = "update user_dtls set password=? where id=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, newPassword);
            ps.setInt(2, userid);

            int i = ps.executeUpdate();
            if (i == 1) {
                f = true;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return f;
    }
    public List<Arzt> getAllArzt() {
        List<Arzt> arztlist = new ArrayList<Arzt>();
        Arzt arzt = null;
        try {

            String sql = "select * from krankenhausjakarta.arzt order by arztid desc";
            PreparedStatement ps = conn.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                arzt = new Arzt();
                arzt.setArztid(Integer.parseInt(rs.getString(1)));
                arzt.setVorname(rs.getString(2));
                arzt.setNachname(rs.getString(3));
                arzt.setAdresse(rs.getString(4));
                arzt.setTelefonnummer(rs.getString(5));
                arzt.setVersicherungsnummer(rs.getString(6));
                arzt.setEmail(rs.getString(7));
                arzt.setPassword(rs.getString(8));
                arzt.setGeburtstag(rs.getString(9));
                arzt.setIpAdresse(rs.getString(10));
                arztlist.add(arzt);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return arztlist;
    }
}
