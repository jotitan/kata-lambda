package fr.titan.kata;

import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Predicate;

public class PaymentOperation {

    public String formatFrenchPaymentWithId(Payment p){
        return "";
    }

    public String formatFrenchPaymentWithoutId(Payment p){
        return "";
    }

    private String format(Payment p, BiFunction<Payment, Boolean, String> formatFunction){
        return "";
    }

    public double basketCost(List<Payment> payments){
        return 0;
    }

    public double countProductWithReduce(List<Payment> payments){
        return 0;
    }

    public String costsAsString(List<Payment> payments, String separator){
        return "";
    }

    private double basketCostWithCriteria(List<Payment> payments, Predicate<Payment> filterFunction){
        return 0;
    }

    public double basketCostFromPrice(List<Payment> payments, int startPrice){
        return 0;
    }

    public int countSingleProducts(List<Payment> payments){
        return 0;
    }


    public int countDistinctProduct(List<Payment> payments) {
        return 0;
    }

    public int countProductsInBasket(List<Basket> baskets){
        return 0;
    }

    public int countCostProductsInBasket(List<Basket> baskets){
        return 0;
    }
}
