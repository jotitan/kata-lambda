package fr.titan.kata.vehicules;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VehiculeUtilsTest {
    private VehiculeUtils vehiculeUtils = new VehiculeUtils();

    @Test
    void carToString(){
        Assertions.assertEquals("Car : DS (Citroen)", vehiculeUtils.carToString(new Car("Citroen","DS")));
    }

}