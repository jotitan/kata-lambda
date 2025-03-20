package fr.titan.kata.vehicules;

public class Car extends Vehicule{
    public Car(String marque, String name) {
        super(marque);
        this.name = name;
    }

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

