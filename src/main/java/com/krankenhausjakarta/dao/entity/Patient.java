package com.krankenhausjakarta.dao.entity;

public class Patient extends Arzt{


    public Patient() {
    }

    public Patient(String vorname, String nachname, String adresse, String telefonnummer, String versicherungsnummer, String email, String password, String geburtstag, String ipAdresse) {
        super(vorname, nachname, adresse, telefonnummer, versicherungsnummer, email, password, geburtstag, ipAdresse);
    }




}
