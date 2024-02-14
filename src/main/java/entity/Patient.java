package entity;

public class Patient{


    private int patientid;
    private String vorname;
    private String nachname;
    private String adresse;
    private String telefonnummer;

    private String patientversicherungsnummer;

    private String email;

    private String password;

    private String geburtstag;

    private String ipAdresse;


    public Patient() {
    }

    public Patient(String vorname, String nachname, String adresse, String telefonnummer, String patientversicherungsnummer, String email, String password, String geburtstag, String ipAdresse) {
        this.vorname = vorname;
        this.nachname = nachname;
        this.adresse = adresse;
        this.telefonnummer = telefonnummer;
        this.patientversicherungsnummer = patientversicherungsnummer;
        this.email = email;
        this.password = password;
        this.geburtstag = geburtstag;
        this.ipAdresse = ipAdresse;
    }

    public int getPatientid() {
        return patientid;
    }

    public void setPatientid(int patientid) {
        this.patientid = patientid;
    }

    public String getVorname() {
        return vorname;
    }

    public void setVorname(String vorname) {
        this.vorname = vorname;
    }

    public String getNachname() {
        return nachname;
    }

    public void setNachname(String nachname) {
        this.nachname = nachname;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getTelefonnummer() {
        return telefonnummer;
    }

    public void setTelefonnummer(String telefonnummer) {
        this.telefonnummer = telefonnummer;
    }

    public String getPatientversicherungsnummer() {
        return patientversicherungsnummer;
    }

    public void setPatientversicherungsnummer(String patientversicherungsnummer) {
        this.patientversicherungsnummer = patientversicherungsnummer;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGeburtstag() {
        return geburtstag;
    }

    public void setGeburtstag(String geburtstag) {
        this.geburtstag = geburtstag;
    }

    public String getIpAdresse() {
        return ipAdresse;
    }

    public void setIpAdresse(String ipAdresse) {
        this.ipAdresse = ipAdresse;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "patientid=" + patientid +
                ", vorname='" + vorname + '\'' +
                ", nachname='" + nachname + '\'' +
                ", adresse='" + adresse + '\'' +
                ", telefonnummer='" + telefonnummer + '\'' +
                ", patientversicherungsnummer='" + patientversicherungsnummer + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", geburtstag='" + geburtstag + '\'' +
                ", ipAdresse='" + ipAdresse + '\'' +
                '}';
    }
}
