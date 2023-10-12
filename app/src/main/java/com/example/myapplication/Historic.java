package com.example.myapplication;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Historic {

    private final String dirPart =  "app\\sampledata\\part.txt";

    private String getDate(){
        Date current = new Date();
        SimpleDateFormat simpDate = new SimpleDateFormat("EEE, d MMM yyyy HH:mm:ss Z");
        return simpDate.format(current);
    }

    public void addPart(String win_lose) {
        String info = win_lose + "--" + this.getDate();
        File fil = new File(this.dirPart);
        BufferedWriter writ = null;
        try {
            writ = new BufferedWriter(new FileWriter(this.dirPart));
            writ.append(info);
            writ.close();
         } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
