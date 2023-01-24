package be.technifutur.decouverte.tableau;

public class TestVarArgs {

    public static void main(String[] args) {
        Integer[] tab = {1,2,3,4,5,6};
        /*
        System.out.println(additionner(tab));
        System.out.println(additionner(new int[]{4,5,6,7,8}));

        System.out.println(additionnerNew(tab));
        System.out.println(additionnerNew(5,7,8,9));
        */
        test(1,2,3);
        test((Object)tab);
    }

    static public int additionner(int[] valeurs){
        int result = 0;
        for(int i: valeurs){
            result += i;
        }
        return result;
    }

    static public int additionnerNew(int... valeurs){
        int result = 0;
        for(int i: valeurs){
            result += i;
        }
        return result;
    }

    //static void error(int... test, String text){}

    static void test(Object... param){
        for(Object o : param){
            System.out.println(o.getClass().getName());
        }
    }
}
