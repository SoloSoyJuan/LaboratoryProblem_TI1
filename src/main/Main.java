package main;

import model.LabolatoryLobby;

public class Main {
    public static LabolatoryLobby lab = new LabolatoryLobby();

    public static void main(String[] args) {
        String [] desea = {"asdf", "asdf"};
        lab.insetPatient("1234", "Carlos Gonzalez", 1, false, 34, desea);
        lab.insetPatient("1233", "Laura Urdinola", 3, false, 34, desea);
        System.out.println(lab.searchPatient("1234"));
        System.out.println(lab.searchPatient("1233"));
    }
}