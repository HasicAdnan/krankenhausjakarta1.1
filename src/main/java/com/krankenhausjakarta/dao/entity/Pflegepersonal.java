package com.krankenhausjakarta.dao.entity;

public class Pflegepersonal extends Person {
    private String mitarbeiterausweis;

    public Pflegepersonal() {
    }

    public Pflegepersonal(String vorname, String nachname, String adresse, String telefonnummer, String versicherungsnummer, String email, String password, String geburtstag, String ipAdresse, String mitarbeiterausweis) {
        super(vorname, nachname, adresse, telefonnummer, versicherungsnummer, email, password, geburtstag, ipAdresse);
        this.mitarbeiterausweis = mitarbeiterausweis;
    }

    public String getMitarbeiterausweis() {
        return mitarbeiterausweis;
    }

    public void setMitarbeiterausweis(String mitarbeiterausweis) {
        this.mitarbeiterausweis = mitarbeiterausweis;
    }
}
