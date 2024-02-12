package dao;


import entity.Pflegepersonal;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class PflegepersonalDao {
        private Connection conn;

        public PflegepersonalDao(Connection connection) {
            this.conn = connection;
        }

        public boolean register(Pflegepersonal pflegepersonal) {
            boolean result = false;
            SingletonIp singletonIp = SingletonIp.getInstance();

            try {
                String sql = "insert into new_schema.patient(vorname, nachname, adresse, telefonnummer, versicherungsnummer, email, password, ipadresse, geburtstag, mitarbeiterausweis ) values(?,?, ?, ?, ?, ?, ?, ?, ?, ?) ";

                PreparedStatement ps = conn.prepareStatement(sql);
                ps.setString(1, pflegepersonal.getVorname());
                ps.setString(2, pflegepersonal.getNachname());
                ps.setString(3, pflegepersonal.getAdresse());
                ps.setString(4, pflegepersonal.getTelefonnummer());
                ps.setString(5, pflegepersonal.getVersicherungsnummer());
                ps.setString(6, pflegepersonal.getEmail());
                ps.setString(7, pflegepersonal.getPassword());
                ps.setString(8, singletonIp.getIp());
                ps.setString(9, pflegepersonal.getMitarbeiterausweis());

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
