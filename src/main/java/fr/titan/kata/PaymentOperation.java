package fr.titan.kata;

import java.util.List;
import java.util.Locale;
import java.util.function.BiFunction;
import java.util.function.Predicate;

public class PaymentOperation {

    public String formatFrenchPaymentWithId(Payment p){
        return format(p, getFct(true));
    }

    public String formatFrenchPaymentWithoutId(Payment p){
        return format(p, getFct(false));
    }

    private BiFunction<Payment, Boolean,String> getFct(boolean b){
        return (prd,bb)->String.format("Product %s%s costs %s €",prd.name(), b ? String.format(" (%d)",prd.id()):"", String.format(Locale.FRENCH, "%s", prd.cost()));
    }

    private String format(Payment p, BiFunction<Payment, Boolean, String> formatFunction){
        return formatFunction.apply(p,true);
    }

    public double basketCost(List<Payment> payments){
        return payments.stream().mapToDouble(p->p.cost()*p.quantity()).reduce(0, Double::sum);
    }

    public double countProductWithReduce(List<Payment> payments){
        return payments.stream().mapToInt(Payment::quantity).sum();
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
