package fr.titan.kata.vehicules;

import fr.titan.kata.vehicules.Vehicule;

@FunctionalInterface
public interface Extractor<V extends Vehicule, T> {
    T extract (V v);
}
