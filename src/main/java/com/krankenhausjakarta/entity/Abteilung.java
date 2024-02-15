package com.krankenhausjakarta.entity;

public class Abteilung {
    private int abteilungid;
    private String namederabteilung;
    private String abteilungemail;
    private String abteiluingtelefonnummer;

    public Abteilung() {
    }

    public Abteilung(String namederabteilung, String abteilungemail, String abteiluingtelefonnummer) {
        this.namederabteilung = namederabteilung;
        this.abteilungemail = abteilungemail;
        this.abteiluingtelefonnummer = abteiluingtelefonnummer;
    }

    public int getAbteilungid() {
        return abteilungid;
    }

    public void setAbteilungid(int abteilungid) {
        this.abteilungid = abteilungid;
    }

    public String getNamederabteilung() {
        return namederabteilung;
    }

    public void setNamederabteilung(String namederabteilung) {
        this.namederabteilung = namederabteilung;
    }

    public String getAbteilungemail() {
        return abteilungemail;
    }

    public void setAbteilungemail(String abteilungemail) {
        this.abteilungemail = abteilungemail;
    }

    public String getAbteiluingtelefonnummer() {
        return abteiluingtelefonnummer;
    }

    public void setAbteiluingtelefonnummer(String abteiluingtelefonnummer) {
        this.abteiluingtelefonnummer = abteiluingtelefonnummer;
    }

    @Override
    public String toString() {
        return "Abteilung{" +
                "abteilungid=" + abteilungid +
                ", namederabteilung='" + namederabteilung + '\'' +
                ", abteilungemail='" + abteilungemail + '\'' +
                ", abteiluingtelefonnummer='" + abteiluingtelefonnummer + '\'' +
                '}';
    }
}
