package model;

public class Patient {
    //----------------------------------------------- Attributes
    private String ID;
    private String name;
    private SEX sex;
    private int age;
    private boolean pregnant;
    private String [] underDeseases;
    //----------------------------------------------- Constructor
    public Patient(String ID, String name, int sex, boolean pregnant, int age, String[] underDeseases) {
        this.ID = ID;
        this.name = name;
        setSex(sex);
        this.age = age;
        this.pregnant = pregnant;
        this.underDeseases = underDeseases;
    }
    //----------------------------------------------- Getters and Setters
    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public SEX getSex() {
        return sex;
    }
    public void setSex(int sex) {
        switch (sex){
            case 1:
                this.sex = SEX.MALE;
                break;
            default:
                this.sex = SEX.FEMALE;
                break;
        }
    }

    public boolean getPregnant() {
        return pregnant;
    }

    public void setPregnant(boolean pregnant) {
        this.pregnant = pregnant;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String[] getUnderDeseases() {
        return underDeseases;
    }

    public void setUnderDeseases(String[] underDeseases) {
        this.underDeseases = underDeseases;
    }
    //----------------------------------------------- Methods
    public String toString(){
        String info = "";
        info += "\nName: "+name;
        info += "\nSex: "+sex;
        info += "\nPregnant: "+pregnant;
        info += "\nID: "+ID;
        info += "\nAge: "+age;
        info += "\nUnderlying Deseases: ";
        for (int i = 0; i < underDeseases.length; i++) {
            info += "\n"+underDeseases[i];
        }
        info += "\nPriority Level: "+priorityLevel();
        return info;
    }
    public int priorityLevel(){
        return 0;
    }
}
