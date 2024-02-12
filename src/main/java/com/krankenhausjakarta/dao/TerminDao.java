package com.krankenhausjakarta.dao;

import servlet.DBConnection;
import com.krankenhausjakarta.dao.entity.Termin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class TerminDao {
    DBConnection dbInstance = DBConnection.getInstance();
    Connection conn = dbInstance.getConnect();


    public boolean addTermin(Termin ter) {
        boolean f = false;

        try {

            String sql = "insert into krankenhausjakarta.termin(arztid,patientversicherungsnummer,abteilungid,datum,uhrzeit,hinweis) values(?,?,?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, ter.getArztid());
            ps.setString(2, ter.getPatientverischerungsnummer());
            ps.setInt(1, ter.getAbteilungid());
            ps.setString(4, ter.getDatum());
            ps.setString(5, ter.getUhrzeit());
            ps.setString(6, ter.getHinweis());

            int i = ps.executeUpdate();
            if (i == 1) {
                f = true;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return f;
    }

    public List<Termin> getAllTerminByLoginArzt(int arztid) {
        List<Termin> terminlist = new ArrayList<Termin>();
        Termin ter = null;

        try {

            String sql = "select * from krankenhausjakarta.termin where arztid=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, arztid);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ter = new Termin();
                ter.setTerminid(rs.getInt(1));
                ter.setArztid(rs.getInt(2));
                ter.setPatientverischerungsnummer(rs.getString(3));
                ter.setAbteilungid(rs.getInt(1));
                ter.setDatum(rs.getString(5));
                ter.setUhrzeit(rs.getString(6));
                ter.setHinweis(rs.getString(7));

                terminlist.add(ter);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return terminlist;
    }

    public List<Termin> getAllTerminByArztLogin(int arztid) {
        List<Termin> terminlist = new ArrayList<Termin>();
        Termin ter = null;

        try {

            String sql = "select * from krankenhausjakarta.termin where arztid=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, arztid);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ter = new Termin();
                ter.setTerminid(rs.getInt(1));
                ter.setArztid(rs.getInt(2));
                ter.setPatientverischerungsnummer(rs.getString(3));
                ter.setAbteilungid(rs.getInt(1));
                ter.setDatum(rs.getString(5));
                ter.setUhrzeit(rs.getString(6));
                ter.setHinweis(rs.getString(7));

                terminlist.add(ter);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return terminlist;
    }

    public Termin getTerminByTerminid(int terminid) {

        Termin ter = null;

        try {

            String sql = "select * from krankenhausjakarta.termin where terminid=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, terminid);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ter = new Termin();
                ter.setTerminid(rs.getInt(1));
                ter.setArztid(rs.getInt(2));
                ter.setPatientverischerungsnummer(rs.getString(3));
                ter.setAbteilungid(rs.getInt(1));
                ter.setDatum(rs.getString(5));
                ter.setUhrzeit(rs.getString(6));
                ter.setHinweis(rs.getString(7));


            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return ter;
    }

    public boolean updateHinweis(int terminid, int arztid, String hinweis) {
        boolean f = false;
        try {
            String sql = "update krankenhausjakarta.termin set hinweis=? where terminid=? and arztid=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, hinweis);
            ps.setInt(2, terminid);
            ps.setInt(3, arztid);

            int i = ps.executeUpdate();
            if (i == 1) {
                f = true;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return f;
    }

    public List<Termin> getAllTermin() {
        List<Termin> terminlist = new ArrayList<Termin>();
        Termin ter = null;

        try {

            String sql = "select * from krankenhausjakarta.termin order by terminid desc";
            PreparedStatement ps = conn.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ter = new Termin();
                ter.setTerminid(rs.getInt(1));
                ter.setArztid(rs.getInt(2));
                ter.setPatientverischerungsnummer(rs.getString(3));
                ter.setAbteilungid(rs.getInt(1));
                ter.setDatum(rs.getString(5));
                ter.setUhrzeit(rs.getString(6));
                ter.setHinweis(rs.getString(7));

                terminlist.add(ter);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return terminlist;
    }

}

