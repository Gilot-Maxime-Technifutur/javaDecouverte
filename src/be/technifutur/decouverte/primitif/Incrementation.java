package be.technifutur.decouverte.primitif;

public class Incrementation {
    public static void main(String[] args) {
        int i = 5;

        System.out.println(i++); //5
        System.out.println(++i); //7

        i = i++;
        System.out.println(i); //7

        System.out.println(i++ + ++i); //7 + 9 = 16

        i = i += i++;

        System.out.println("-----------");
        for(int j = 0; j < 5; ++j){
            System.out.println(j);
        }

        i+= 5;
        i -= 5;
        i /= 5;
        i <<= 2;

        System.out.println("-----------");

        int[] tab = {1,5,4,9,3};
        int pos = 0;
        while(pos < tab.length && tab[pos] != 9){
            System.out.println(tab[pos++]);
        }
        System.out.println(pos);

        System.out.println("-----------");

        int a = 9;
        int b = 5;
        System.out.printf("a : %s , b : %s\n", a, b);
        a ^= b;
        b ^= b;
        a ^= b;
        System.out.printf("a : %s , b : %s\n", a, b);

        System.out.println("-----------");

        a = b = i = pos = 5;

        System.out.println("-----------");


    }
}
