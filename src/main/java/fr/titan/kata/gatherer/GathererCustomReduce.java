package fr.titan.kata.gatherer;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Gatherer;

public class GathererCustomReduce {


    public Optional<String> customReduce(List<Integer> list) {
        return list.stream().gather(new CustomReduce(i -> i + ":")).findFirst();
    }

    class Wrapper{
        private String value ="";

        Wrapper(String init){
            this.value = init;
        }

        public Wrapper() {

        }

        public void change(String newValue){
            this.value = newValue;
        }
        public String get(){
            return this.value;
        }
    }

    private class CustomReduce implements Gatherer<Integer, Wrapper, String> {
        private Function<Integer,String> transform;

        public CustomReduce(Function<Integer,String> transform){
            this.transform = transform;
        }
        @Override
        public Supplier<Wrapper> initializer() {
            return Wrapper::new;
        }

        @Override
        public Integrator<Wrapper, Integer, String> integrator() {
            return (window, element, col)->{
                window.change(window.get() + this.transform.apply(element));
                return true;
            };
        }

        @Override
        public BinaryOperator<Wrapper> combiner() {
            return (a,b)->new Wrapper(a.get() + b.get());
        }

        @Override
        public BiConsumer<Wrapper, Downstream<? super String>> finisher() {
            return (window, stream)->{
                stream.push(window.get());
            };
        }
    }


}
