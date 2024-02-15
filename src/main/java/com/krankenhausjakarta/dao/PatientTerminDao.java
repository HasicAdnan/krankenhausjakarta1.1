package com.krankenhausjakarta.dao;

import com.krankenhausjakarta.entity.Arzt;
import com.krankenhausjakarta.entity.PatientTermin;
import com.krankenhausjakarta.servlet.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
            ps.setString(2, ter.getPatientversicherungsnummer());
            ps.setInt(3, ter.getAbteilungid());
            ps.setString(4, ter.getDatum());
            ps.setString(5, ter.getUhrzeit());
            ps.setString(6, ter.getHinweis());

            int i = ps.executeUpdate();
            if (i == 1) {
                f = true;
                conn.close();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }


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
                term.setPatientversicherungsnummer(rs.getString(3));
                term.setAbteilungid(rs.getInt(4));
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

    public List<PatientTermin> getAllTerminForPatient(String patientversicherungsnummer) {
        List<PatientTermin> terminList = new ArrayList<>();
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conn = DBConnection.getInstance().getConnect();
            String query = "SELECT * FROM krankenhausjakarta.termin WHERE patientversicherungsnummer = ?";
            stmt = conn.prepareStatement(query);
            stmt.setString(1, patientversicherungsnummer);
            rs = stmt.executeQuery();

            while (rs.next()) {
                // Uzmi podatke za svaki termin iz baze podataka
                int terminId = rs.getInt("terminid");
                int arztId = rs.getInt("arztid");
                int abteilungId = rs.getInt("abteilungid");
                String datum = rs.getString("datum");
                String uhrzeit = rs.getString("uhrzeit");
                String hinweis = rs.getString("hinweis");

                // Kreiraj objekt termina i dodaj ga u listu
                PatientTermin termin = new PatientTermin( arztId, patientversicherungsnummer, abteilungId, datum, uhrzeit, hinweis);
                terminList.add(termin);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Zatvori resurse
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return terminList;
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
                ter.setPatientversicherungsnummer(rs.getString(3));
                ter.setAbteilungid(rs.getInt(4));
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
                ter.setPatientversicherungsnummer(rs.getString(3));
                ter.setAbteilungid(rs.getInt(4));
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
                ter.setPatientversicherungsnummer(rs.getString(3));
                ter.setAbteilungid(rs.getInt(4));
                ter.setDatum(rs.getString(5));
                ter.setUhrzeit(rs.getString(6));
                ter.setHinweis(rs.getString(7));

                terminlist.add(ter);

            }
            for(PatientTermin ab : terminlist) {
                System.out.println(ab);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return terminlist;
    }

    public List<PatientTermin> getAllArzt() {
        List<PatientTermin> terminList = new ArrayList<>();
        PatientTermin termin = null;
        try {

            String sql = "select * from krankenhausjakarta.arzt order by terminid desc";
            PreparedStatement ps = conn.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                termin = new PatientTermin();
                termin.setTerminid(Integer.parseInt(rs.getString(1)));
                termin.setArztid(Integer.parseInt(rs.getString(2)));
                termin.setPatientversicherungsnummer(rs.getString(3));
                termin.setAbteilungid(Integer.parseInt(rs.getString(4)));
                termin.setDatum(rs.getString(5));
                termin.setUhrzeit(rs.getString(6));
                termin.setHinweis(rs.getString(7));
                terminList.add(termin);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return terminList;
    }

    public List<PatientTermin> getAllTerminByPatientLogin(int patientid) {
        List<PatientTermin> terminlist = new ArrayList<PatientTermin>();
        PatientTermin ter = null;

        try {

            String sql = "select * from krankenhausjakarta.termin where patientid=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, patientid);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ter = new PatientTermin();
                ter.setTerminid(rs.getInt(1));
                ter.setArztid(rs.getInt(2));
                ter.setPatientversicherungsnummer(rs.getString(3));
                ter.setAbteilungid(rs.getInt(4));
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
    public List<PatientTermin> getAllTerminForPatient(int patientId) {
        List<PatientTermin> terminList = new ArrayList<>();
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conn = DBConnection.getInstance().getConnect();
            String query = "SELECT * FROM termin WHERE patientid = ?";
            stmt = conn.prepareStatement(query);
            stmt.setInt(1, patientId);
            rs = stmt.executeQuery();

            while (rs.next()) {
                // Uzmi podatke za svaki termin iz baze podataka
                int terminId = rs.getInt("terminid");
                int arztId = rs.getInt("arztid");
                String patientversicherungsnummer = rs.getString("patientversicherungsnummer");
                int abteilungId = rs.getInt("abteilungid");
                String datum = rs.getString("datum");
                String uhrzeit = rs.getString("uhrzeit");
                String hinweis = rs.getString("hinweis");

                // Kreiraj objekt termina i dodaj ga u listu
                PatientTermin termin = new PatientTermin(arztId, patientversicherungsnummer, abteilungId, datum, uhrzeit, hinweis);
                terminList.add(termin);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Zatvori resurse
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return terminList;
    }

    public boolean loschenTermin(int terminid) {
        boolean f = false;
        try {
            String sql = "delete from krankenhausjakarta.termin where terminid=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, terminid);

            int i = ps.executeUpdate();
            if (i == 1) {
                f = true;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return f;
    }

}

