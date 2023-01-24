package be.technifutur.decouverte.api.collection.stream;

import be.technifutur.decouverte.api.collection.data.Personne;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ArrayToStream {
    public static void main(String[] args) {
        Personne[] personnes = Personne.dataTest();

        Stream<Personne> objectif = Arrays.stream(personnes);
        //objectif = Arrays.asList(personnes).stream();
        objectif.filter(p -> p.getAge() > 60)
                .forEach(System.out::println);

        System.out.println("------------------------------------");

        objectif = Arrays.stream(personnes);
        List<Personne> list = objectif.filter(p -> p.getAge() < 70).toList();
        System.out.println(list);

        System.out.println("------------------------------------");

        objectif = Arrays.stream(personnes);
        long combien = objectif.filter(p -> p.getAge() > 20 && p.getAge() < 70).count();
        System.out.println(combien);

        System.out.println("------------------------------------");

        objectif = Arrays.stream(personnes);
        String noms = objectif
                .map(p -> p.getName().toUpperCase() + ' ' + p.getPrenom())
                .collect(Collectors.joining(","));
        System.out.println(noms);

        System.out.println("------------------------------------");

        objectif = Arrays.stream(personnes);
        Map<Integer, Integer> map = objectif
                .collect(Collectors.toMap(
                        p -> p.getAge()/10*10,                  //key
                        p -> 1,                                 //value
                        (ancien, nouveau) -> ancien + nouveau)  //merge
                );
        System.out.println(map);

        objectif = Arrays.stream(personnes);
        Map<Integer, String> map2 = objectif
                .collect(Collectors.toMap(
                        p -> p.getAge()/10*10,                                                  //key
                        p -> String.format("%s %s", p.getName().toUpperCase(), p.getPrenom()),  //value
                        (p1, p2) -> String.format("%s/%s", p1, p2))                             //merge
                );
        System.out.println(map2);

        objectif = Arrays.stream(personnes);
        Map<Integer, Personne> map3 = objectif
                .collect(Collectors.toMap(
                        p -> p.getAge()/10*10,                                              //key
                        p -> p,                                                             //value
                        (p1, p2) -> p1.getName().length() > p2.getName().length()? p1 : p2) //merge
                );
        System.out.println(map3);

        System.out.println("------------------------------------");

        objectif = Arrays.stream(personnes);
        Map<Character, SortedSet<Personne>> map4 = objectif
                .collect(Collectors.groupingBy(
                        p -> p.getName().charAt(0),
                        Collectors.toCollection(
                                () -> new TreeSet<>(Comparator.comparing(Personne::getName)))
                        )
                );
        System.out.println(map4);

    }
}
