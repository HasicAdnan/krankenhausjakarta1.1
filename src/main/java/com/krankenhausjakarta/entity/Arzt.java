package com.krankenhausjakarta.entity;

public class Arzt {

    private int arztid;
    private String vorname;
    private String nachname;
    private String adresse;
    private String telefonnummer;

    private String versicherungsnummer;

    private String email;

    private String password;

    private String geburtstag;

    private String ipAdresse;

    public Arzt() {
    }

    public Arzt(String vorname, String nachname, String adresse, String telefonnummer, String versicherungsnummer, String email, String password, String geburtstag, String ipAdresse) {
        this.vorname = vorname;
        this.nachname = nachname;
        this.adresse = adresse;
        this.telefonnummer = telefonnummer;
        this.versicherungsnummer = versicherungsnummer;
        this.email = email;
        this.password = password;
        this.geburtstag = geburtstag;
        this.ipAdresse = ipAdresse;
    }

    public int getArztid() {
        return arztid;
    }

    public void setArztid(int arztid) {
        this.arztid = arztid;
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

    public String getVersicherungsnummer() {
        return versicherungsnummer;
    }

    public void setVersicherungsnummer(String versicherungsnummer) {
        this.versicherungsnummer = versicherungsnummer;
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
        return "Arzt{" +
                "arztid=" + arztid +
                ", vorname='" + vorname + '\'' +
                ", nachname='" + nachname + '\'' +
                ", adresse='" + adresse + '\'' +
                ", telefonnummer='" + telefonnummer + '\'' +
                ", versicherungsnummer='" + versicherungsnummer + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", geburtstag='" + geburtstag + '\'' +
                ", ipAdresse='" + ipAdresse + '\'' +
                '}';
    }
}