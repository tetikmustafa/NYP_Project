package com.example.nyp_proje;

public class User {
    static private String fileName;

    public static String getFileName() {
        return fileName;
    }

    public static void setFileName(String dosyaAdi) {
        User.fileName = dosyaAdi;
    }
}
