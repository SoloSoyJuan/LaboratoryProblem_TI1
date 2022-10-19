package main;

import model.LabolatoryLobby;

import java.util.Scanner;

public class Main {
    public static LabolatoryLobby lab = new LabolatoryLobby();
    public static Scanner s = new Scanner(System.in);
    public static void main(String[] args) {
        int option = 0;
        do{
            option = mainMenu();
        }while(option != 0);
        System.out.println("\nApagando sistema");
    }
    public static int mainMenu(){
        int option = 0;
        System.out.println("\nQue quieres hacer:"+
                           "\n(1) ingresar a la fila "+
                            "\n(2) turnos actuales de la fila"+
                            "\n(3) información de paciente"+
                            "\n(0) Salir");
        option = s.nextInt();
        s.nextLine();
        return option;
    }
    public void actions(int option){
        int temp = 0;
        switch (option){
            case 1:
                System.out.println("\n¿Cuál fila?"+
                        "\n(1) Hematología"+
                        "\n(2) General");
                temp = s.nextInt();
                s.nextLine();

            break;
            case 2:
                System.out.println("\n¿Cuál fila?"+
                                    "\n(1) Hematología"+
                                    "\n(2) General");
                temp = s.nextInt();
                s.nextLine();
                System.out.println(lab.printQueue(temp));
            break;
            case 3:
                System.out.println("\nIngresar ID del paciente buscado");
                String patient = s.next();
                System.out.println(lab.searchPatient(patient));
                break;
        }
    }
}
