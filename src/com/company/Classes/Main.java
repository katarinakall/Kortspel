package com.company.Classes;

public class Main {
    private static boolean keepPlaying = true;

    public static void setKeepPlaying(boolean keepPlaying) {
        Main.keepPlaying = keepPlaying;
    }

    public static void main(String[] args) {
        Menu menu = new Menu();

        while (keepPlaying)
            menu.useMenu();

    }
}


