package model;

import generics.Hashtable;
import generics.IHashtable;
import generics.IPriorityQueue;
import generics.PriorityQueue;

public class LabolatoryLobby {
    //----------------------------------------------- attributes
    private IHashtable<Integer, Patient> dataBase;
    private IPriorityQueue<Patient> hematologia;
    private IPriorityQueue<Patient> general;
    //----------------------------------------------- Constructor
    public LabolatoryLobby(){
        dataBase = new Hashtable<>();
        hematologia = new PriorityQueue<>();
        general = new PriorityQueue<>();
    }
    //----------------------------------------------- Methods
    /*
        Metodo para agregar un nuevo paciente a la base de datos
     */
    public void insetPatient(String ID, String name, int sex, boolean pregnant, int age, String[] underDeseases){
        Patient patient = new Patient(ID, name, sex, pregnant, age, underDeseases);
        int key = Integer.parseInt(ID);
        dataBase.insert(key, patient);
    }
    /*
        metodo para buscar a un paciente con la cedula
     */
    public String searchPatient(String ID){
        String infoPatient = "";
        int key = Integer.parseInt(ID);
        infoPatient = dataBase.search(key).getValue().toString();
        return infoPatient;
    }
    /*
        metodo para agregar un paciente a alguna de las dos filas del laboratorio
     */
    public void addToQueue(int queue, String id){
        int ID = Integer.parseInt(id);
        Patient patient = dataBase.search(ID).getValue();
        switch (queue) {
            case 1: hematologia.insert(patient.priorityLevel(), patient); break;// en caso de ingresar a hematología
            case 2: general.insert(patient.priorityLevel(), patient); break; // en caso de ingresar a propósito general
        }
    }
    /*
        metodo para mostrar los pacientes que se encuentrar en una de las filas
     */
    public String printQueue(int queue){
        String info = "";
        switch (queue){
            case 1: info = hematologia.toString(); break;
            case 2: info = general.toString(); break;
        }
        return info;
    }
    public String deletefromQueue(int queue, String id){
        String s = "";
        Patient patient = dataBase.search(Integer.parseInt(id)).getValue();
        switch (queue){
            case 1: s = (hematologia.delete(patient)) ? "Eliminado\n": "No esta en la fila\n"; break;
            case 2: s = (hematologia.delete(patient)) ? "Eliminado\n": "No esta en la fila\n"; break;
        }
        return s;
    }
}
