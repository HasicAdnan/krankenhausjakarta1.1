package com.krankenhausjakarta.dao;

import com.krankenhausjakarta.dao.entity.Abteilung;
import com.krankenhausjakarta.dao.entity.PatientTermin;
import servlet.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class PatientTerminDao {
    DBConnection dbInstance = DBConnection.getInstance();
    Connection conn = dbInstance.getConnect();


    public boolean addTermin(PatientTermin ter) {
        boolean f = false;

        try {

            String sql = "insert into krankenhausjakarta.termin(arztid,patientversicherungsnummer,abteilungid,datum,uhrzeit,hinweis) values(?,?,?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, ter.getArztid());
            ps.setString(2, ter.getPatientverischerungsnummer());
            ps.setInt(3, ter.getAbteilungid());
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

        System.out.println(f);
        return f;
    }

    public List<PatientTermin> getAllTerminByLoginArzt(int arztid) {
        List<PatientTermin> terminlist = new ArrayList<PatientTermin>();
        PatientTermin term = null;

        try {

            String sql = "select * from krankenhausjakarta.termin where arztid=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, arztid);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                term = new PatientTermin();
                term.setTerminid(rs.getInt(1));
                term.setArztid(rs.getInt(2));
                term.setPatientverischerungsnummer(rs.getString(3));
                term.setAbteilungid(rs.getInt(1));
                term.setDatum(rs.getString(5));
                term.setUhrzeit(rs.getString(6));
                term.setHinweis(rs.getString(7));

                terminlist.add(term);
            }  for(PatientTermin ab : terminlist) {
                System.out.println(ab);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
            return terminlist;
        }




    public List<PatientTermin> getAllTerminByArztLogin(int arztid) {
        List<PatientTermin> terminlist = new ArrayList<PatientTermin>();
        PatientTermin ter = null;

        try {

            String sql = "select * from krankenhausjakarta.termin where arztid=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, arztid);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ter = new PatientTermin();
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

    public PatientTermin getTerminByTerminid(int terminid) {

        PatientTermin ter = null;

        try {

            String sql = "select * from krankenhausjakarta.termin where terminid=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, terminid);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ter = new PatientTermin();
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

    public List<PatientTermin> getAllTermin() {
        List<PatientTermin> terminlist = new ArrayList<PatientTermin>();
        PatientTermin ter = null;

        try {

            String sql = "select * from krankenhausjakarta.termin order by terminid desc";
            PreparedStatement ps = conn.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ter = new PatientTermin();
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

