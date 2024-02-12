package com.krankenhausjakarta.dao.entity;

public class PatientTermin {
    private int terminid;
    private int arztid;
    private String patientverischerungsnummer;
    private int abteilungid;
    private String datum;
    private String uhrzeit;
    private String hinweis;

    public PatientTermin() {
    }

    public PatientTermin(int arztid, String patientverischerungsnummer, int abteilungid, String datum, String uhrzeit, String hinweis) {
        this.arztid = arztid;
        this.patientverischerungsnummer = patientverischerungsnummer;
        this.abteilungid = abteilungid;
        this.datum = datum;
        this.uhrzeit = uhrzeit;
        this.hinweis = hinweis;
    }

    public int getTerminid() {
        return terminid;
    }

    public void setTerminid(int terminid) {
        this.terminid = terminid;
    }

    public int getArztid() {
        return arztid;
    }

    public void setArztid(int arztid) {
        this.arztid = arztid;
    }

    public String getPatientverischerungsnummer() {
        return patientverischerungsnummer;
    }

    public void setPatientverischerungsnummer(String patientverischerungsnummer) {
        this.patientverischerungsnummer = patientverischerungsnummer;
    }

    public int getAbteilungid() {
        return abteilungid;
    }

    public void setAbteilungid(int abteilungid) {
        this.abteilungid = abteilungid;
    }

    public String getDatum() {
        return datum;
    }

    public void setDatum(String datum) {
        this.datum = datum;
    }

    public String getUhrzeit() {
        return uhrzeit;
    }

    public void setUhrzeit(String uhrzeit) {
        this.uhrzeit = uhrzeit;
    }

    public String getHinweis() {
        return hinweis;
    }

    public void setHinweis(String hinweis) {
        this.hinweis = hinweis;
    }

    @Override
    public String toString() {
        return "PatientTermin{" +
                "terminid=" + terminid +
                ", arztid=" + arztid +
                ", patientverischerungsnummer='" + patientverischerungsnummer + '\'' +
                ", abteilungid=" + abteilungid +
                ", datum='" + datum + '\'' +
                ", uhrzeit='" + uhrzeit + '\'' +
                ", hinweis='" + hinweis + '\'' +
                '}';
    }
}
