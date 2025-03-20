package fr.titan.kata;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PaymentOperationTest {
    private PaymentOperation op = new PaymentOperation();
    @Test
    void formatFrenchPaymentWithId() {
        assertEquals("Product maison (3) costs 12.0 €",op.formatFrenchPaymentWithId(new Payment(3,1,12, "maison",LocalDateTime.now())));
    }

    @Test
    void formatFrenchPaymentWithoutId() {
        assertEquals("Product voiture costs 12.0 €",op.formatFrenchPaymentWithoutId(new Payment(3,1,12, "voiture", LocalDateTime.now())));
    }

    @Test
    void basketCost() {
        double cost = op.basketCost(List.of(
                new Payment(1,1,10,"",null),
                new Payment(2,2,4,"",null),
                new Payment(3,5,3,"",null)));
        assertEquals(33, cost);
    }

    @Test
    void countSingleProducts() {
        double nb = op.countSingleProducts(List.of(
                new Payment(1,1,10,"",null),
                new Payment(2,2,4,"",null),
                new Payment(3,1,3,"",null),
                new Payment(4,50,3,"",null),
                new Payment(5,3,3,"",null)
        ));
        assertEquals(2, nb);
    }

    @Test
    void basketCostFromPrice(){
        double cost = op.basketCostFromPrice(List.of(
                new Payment(1,1,10,"",null),
                new Payment(2,2,40,"",null),
                new Payment(3,1,1200,"",null)),20);
        assertEquals(1290, cost);
    }

    @Test
    void countProductWithReduce(){
        double nb = op.countProductWithReduce(List.of(
                new Payment(1,1,10,"",null),
                new Payment(2,2,4,"",null),
                new Payment(3,1,3,"",null),
                new Payment(4,50,3,"",null),
                new Payment(5,3,3,"",null)
        ));
        assertEquals(57, nb);
    }

    @Test
    void costsAsString(){
        String str = op.costsAsString(List.of(
                new Payment(1,1,10,"",null),
                new Payment(2,2,4,"",null),
                new Payment(3,1,3,"",null)
        ), "|");
        assertEquals("10|4|3|", str);
    }

    @Test
    void countDistinctProduct(){
        int nb = op.countDistinctProduct(List.of(
                new Payment(1,1,10,"",null),
                new Payment(2,2,4,"",null),
                new Payment(4,2,4,"",null),
                new Payment(5,2,4,"",null),
                new Payment(1,2,4,"",null),
                new Payment(2,2,4,"",null),
                new Payment(1,1,3,"",null)
        ));
        assertEquals(4, nb);
    }

    void countProductsInBaskets(){
        Basket b1 = new Basket(List.of(new Payment(1,1,10,"",null), new Payment(2,4,3,"",null)));
        Basket b2 = new Basket(List.of(new Payment(3,3,10,"",null), new Payment(1,10,3,"",null)));

        assertEquals(18, op.countProductsInBasket(List.of(b1,b2)));
    }

    void countCostProductsInBaskets(){
        Basket b1 = new Basket(List.of(new Payment(1,1,10,"",null), new Payment(2,4,3,"",null)));
        Basket b2 = new Basket(List.of(new Payment(3,3,10,"",null), new Payment(1,10,3,"",null)));

        assertEquals(82, op.countCostProductsInBasket(List.of(b1,b2)));
    }
}