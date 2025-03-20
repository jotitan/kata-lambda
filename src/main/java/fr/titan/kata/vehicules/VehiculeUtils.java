package fr.titan.kata.vehicules;

import java.util.List;

public class VehiculeUtils {

    public String carToString(Car c){
        return vehiculeToString(v->String.format("Car : %s (%s)",v.getName() ,v.getMarque()),c);
    }

    public String planeToString(Plane p){
        return vehiculeToString(v->String.format("Plane : %s (%s), %d passengers",v.getName() ,v.getMarque(), v.getPassengers()),p);
    }

    private <V extends Vehicule> String vehiculeToString(Extractor<V, String> extractor,V vehicule){
        return extractor.extract(vehicule);
    }

    public Integer planePassengers(Plane p){
        return vehiculeToInt(Plane::getPassengers,p);
    }

    public List<String>getVehiculesAsString(List<Plane> list){
        return list.stream().map(p->vehiculeToString(v->String.format("Plane : %s (%s), %d passengers",v.getName() ,v.getMarque(), v.getPassengers()),p)).toList();
    }

    private <V extends Vehicule> Integer vehiculeToInt(Extractor<V, Integer> extractor,V vehicule){
        return extractor.extract(vehicule);
    }
}
