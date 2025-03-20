package fr.titan.kata.gatherer;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class GathererCase1Test {

    @Test
    void t(){
        new GathererCase1().t();
    }

    @Test
    void customReduce(){
        Optional<String> results = new GathererCustomReduce().customReduce(List.of(1,3,5,6,8));
        Assertions.assertTrue(results.isPresent());
        Assertions.assertEquals("1:3:5:6:8:",results.get());
    }

}