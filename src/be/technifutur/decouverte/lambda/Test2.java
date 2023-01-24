package be.technifutur.decouverte.lambda;

import be.technifutur.decouverte.poo.VaisseauAncetre;
import be.technifutur.decouverte.poo.Xwing;
import be.technifutur.decouverte.poo.autre.Millenium;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Test2 {
    public static void main(String[] args) {
        List<VaisseauAncetre> vaisseauList = new ArrayList<>();

        vaisseauList.add(new Millenium());
        vaisseauList.add(new Millenium());
        vaisseauList.add(new Millenium());
        vaisseauList.add(new Xwing(5));
        vaisseauList.add(new VaisseauAncetre(6) {
            @Override
            public void afficherCamps() {
                System.out.println("j'ai pas de camps");
            }
        });
        vaisseauList.add(new Xwing(3) {
            @Override
            public void tirer() {
                System.out.println("je vais tirer");
                super.tirer();
            }
        });
/*
        {
            vaisseauList.forEach(System.out::println);
            vaisseauList.forEach(v -> v.tirer());

            for (VaisseauAncetre v : vaisseauList) {
                v.decoller();
            }
        }
*/
        List<String> result = vaisseauList.stream()
                                          .filter(v -> v.getNbMissiles() > 5)
                                          .map(v -> String.format("j'ai %s missiles", v.getNbMissiles()))
                                          .toList();

        System.out.println(result);

        Optional<Integer> max = vaisseauList.stream()
                                            .filter(v -> v.getNbMissiles() < 7)
                                            .map(v -> v.getNbMissiles())
                                            .max(Integer::compareTo);
        if (max.isEmpty()) {
            System.out.println("pas de max");
        } else {
            System.out.println(max.get());
        }

        long count = vaisseauList.stream()
                                 .peek(v -> {
                                     if(v.getNbMissiles()==10){
                                         v.decoller();
                                     }
                                  })
                                 .filter(v -> v.isEnVol())
                                 .count();
        System.out.println(count);
    }
}
