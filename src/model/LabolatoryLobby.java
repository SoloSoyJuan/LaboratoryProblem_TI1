package model;

import generics.*;

public class LabolatoryLobby {
    //----------------------------------------------- attributes
    private IHashtable<Integer, Patient> dataBase;
    private IPriorityQueue<Patient> hematologia;
    private IPriorityQueue<Patient> general;
    private IStack<Patient> goBack;
    //----------------------------------------------- Constructor
    public LabolatoryLobby(){
        dataBase = new Hashtable<>();
        hematologia = new PriorityQueue<>();
        general = new PriorityQueue<>();
        goBack = new Stack<>();
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
        if(patient != null){
            switch (queue) {
                case 1: hematologia.insert(patient.priorityLevel(), patient); break;// en caso de ingresar a hematología
                case 2: general.insert(patient.priorityLevel(), patient); break; // en caso de ingresar a propósito general
            }
            // agregar el paso realizado de ingreso en la stack
            goBack.push(true, queue, patient);
        }
    }
    /*
        metodo para extraer un paciente de alguna de las dos filas del laborarotio para ser atendido
     */
    public String egressFromQueue(int queue){
        String info = "";
        Patient patient = null;
        switch (queue){
            case 1: patient = hematologia.extractMax(); break; // en caso de extraer en hematologia
            case 2: patient = general.extractMax(); break; // en caso de extraer en general
        }
        if(patient == null){ // para revisar si las filas estan vacio
            info = "No hay nadie en la fila\n";
        }else{
            info = "Turno de: "+ patient.toString();
            goBack.push(false, queue, patient); // si no esta vacia guardo la informacion y guardo ese paso en la stack
        }
        return info;
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
            case 2: s = (general.delete(patient)) ? "Eliminado\n": "No esta en la fila\n"; break;
        }
        return s;
    }
    /*
        metodo para regresar al paso anterior de un ingreso o egreso de alguna de las filas
     */
    public String goBack(){
        NodeThreeValue<Integer, Patient> node = (NodeThreeValue<Integer, Patient>) goBack.pop(); // cargo el nodo que es el paso anterior
        String info = "Paciente ingresado nuevamente: " + node.getValue().toString(); // información en caso de tener que volver a ingresar al paciente en la fila
        if (node.getEntry()) { // en caso de ser un ingreso y toca sacarlo de la fila
            if(node.getKey() == 1){ // indica cual fila fue
                info = (hematologia.delete(node.getValue())) ? "Eliminado\n": "No esta en la fila\n";
            }else{
                info = (general.delete(node.getValue())) ? "Eliminado\n": "No esta en la fila\n";
            }
        }else{ // en caso de ser un egreso y toca volver a ingresarlo
             if(node.getKey() == 1){ // indica cual fila fue
                hematologia.insert(node.getValue().priorityLevel(), node.getValue());
            }else{
                general.insert(node.getValue().priorityLevel(), node.getValue());
            }
        }
        return info;
    }
}
