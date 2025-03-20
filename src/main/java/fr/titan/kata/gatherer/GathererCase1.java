package fr.titan.kata.gatherer;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Gatherer;
import java.util.stream.Gatherers;

public class GathererCase1 {

    public void t(){
        List<Integer> list = List.of(4,1,3,9,13,35, 2, 104, 83);

        List<List<Integer>> s = list.stream().gather(new OddEven()).map(l->{l.sort(Integer::compareTo);return l;}).toList();
        System.out.println(s.get(0));
        System.out.println(s.get(1));
    }

    public void t3(Function<Integer, Integer> fct){
        List<Integer> list = List.of(4,1,3,9,13,35, 2, 104, 83);
        list.stream().gather(Gatherer.of((u,element, l)->{
            l.push(fct.apply(element));
            return true;
        }));
    }

    public void t3(){
        List<Integer> list = List.of(4,1,3,9,13,35, 2, 104, 83);
        List<List<Integer>> s = list.stream()
                .gather(Gatherer.<Integer, List<Integer>[], List<Integer>>of(
                        ()->new List[]{new ArrayList(),new ArrayList()},
                        (w,e,c)->{
                            w[e%2].add(e);
                            return true;
                        },
                        (a,ba)->new List[]{},
                        (window,stream)->{
                            stream.push(window[0]);
                            stream.push(window[1]);
                        }
                        ))
                //.map(ll->{ll.sort((a,b)->((int)a) - ((int)b));return ll;})
               /* .map(l->{
                    System.out.println(l);
                    l.sort((a,b)->a-b);
                    return l;
                })*/
                .toList();
        System.out.println(s.get(0));
        System.out.println(s.get(1));
    }

    private class OddEven implements Gatherer<Integer, List<Integer>[], List<Integer>> {
        @Override
        public Supplier<List<Integer>[]> initializer() {
            return ()->new List[]{new ArrayList(),new ArrayList()};
        }

        @Override
        public Gatherer.Integrator<List<Integer>[], Integer, List<Integer>> integrator() {
            return (window, element, col)->{
                window[element%2].add(element);
                return true;
            };
        }

        @Override
        public BinaryOperator<List<Integer>[]> combiner() {
            return (a,b)->new List[]{};
        }

        @Override
        public BiConsumer<List<Integer>[], Gatherer.Downstream<? super List<Integer>>> finisher() {
            return (window, stream)->{
                stream.push(window[0]);
                stream.push(window[1]);
            };
        }
    }


}
