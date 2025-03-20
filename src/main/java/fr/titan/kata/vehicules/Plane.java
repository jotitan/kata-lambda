package fr.titan.kata.vehicules;

public class Plane extends Vehicule{

    private String name;
    private int passengers;

    public Plane(String marque, String name, int passengers) {
        super(marque);
        this.name = name;
        this.passengers = passengers;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPassengers() {
        return passengers;
    }

    public void setPassengers(int passengers) {
        this.passengers = passengers;
    }
}
