package fr.titan.kata;

import java.time.LocalDateTime;

public record Payment(int id, int quantity, double cost, String name, LocalDateTime time) {
}
