package com.krankenhausjakarta.dao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class SingletonIp {

    private SingletonIp singleton;



    private static SingletonIp instance = new SingletonIp();

    public static SingletonIp getInstance() {
        if (instance == null) {
            instance = new SingletonIp();
        }
        return instance;
    }

    protected String getIp() throws IOException {
        URL whatismyip = new URL("http://checkip.amazonaws.com/");
        BufferedReader in = new BufferedReader(new InputStreamReader(whatismyip.openStream()));
        String ip = in.readLine();
        System.out.println(ip);
        return ip;
    }
}
