package com.example.loginarquivo.utils;

import java.io.FileInputStream;
import java.io.IOException;

public class Login {

    public static boolean check(FileInputStream fis, String name, String password) {
        int quantity = 0;
        String str = "";
        try {
            quantity = fis.available();
            for(int i = 0; i < quantity; i++) {
                str += (char) fis.read();
            }
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String[] users = str.split("\n");
        boolean checked = false;
        for (String user : users) {
            String n = user.split(";")[0];
            String p = user.split(";")[1];
            if (n.equals(name) && p.equals(password)) {
                checked = true;
            }
        }
        return checked;
    }

}
