package fr.titan.kata.vehicules;

public abstract class Vehicule {
    private String marque;

    public Vehicule(String marque) {
        this.marque = marque;
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }
}
