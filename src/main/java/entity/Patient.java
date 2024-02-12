package entity;

public class Patient extends Person {

    private String blutgruppe;


    public Patient() {
    }

    public Patient(String vorname, String nachname, String adresse, String telefonnummer, String versicherungsnummer, String email, String password, String geburtstag, String ipAdresse, String blutgruppe) {
        super(vorname, nachname, adresse, telefonnummer, versicherungsnummer, email, password, geburtstag, ipAdresse);
        this.blutgruppe = blutgruppe;
    }

    public String getBlutgruppe() {
        return blutgruppe;
    }

    public void setBlutgruppe(String blutgruppe) {
        this.blutgruppe = blutgruppe;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "blutgruppe='" + blutgruppe + '\'' +
                '}';
    }
}
