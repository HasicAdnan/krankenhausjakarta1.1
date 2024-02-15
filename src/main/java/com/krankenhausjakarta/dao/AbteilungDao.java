package com.krankenhausjakarta.dao;

import com.krankenhausjakarta.entity.Abteilung;
import com.krankenhausjakarta.servlet.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class AbteilungDao {
    DBConnection dbInstance = DBConnection.getInstance();
    Connection conn = dbInstance.getConnect();

    public List<Abteilung> getAllAbteilung() {
        List<Abteilung> abteilunglist = new ArrayList<Abteilung>();
        Abteilung abteilung = null;
        try {

            String sql = "select * from krankenhausjakarta.abteilung order by abteilungid desc";
            PreparedStatement ps = conn.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                abteilung = new Abteilung();
                abteilung.setAbteilungid(Integer.parseInt(rs.getString(1)));
                abteilung.setNamederabteilung(rs.getString(2));
                abteilung.setAbteilungemail(rs.getString(3));
                abteilung.setAbteiluingtelefonnummer(rs.getString(4));
                abteilunglist.add(abteilung);
            }
            for(Abteilung ab : abteilunglist) {
                System.out.println(ab);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return abteilunglist;
    }
}
