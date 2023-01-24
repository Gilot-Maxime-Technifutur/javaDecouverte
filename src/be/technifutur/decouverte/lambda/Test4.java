package be.technifutur.decouverte.lambda;

public class Test4 {

    public static void main(String[] args) {
        Test4 test4 = new Test4();
        test4.test();
    }

    private void test() {
        Runnable anonyme = new Runnable() {
            @Override
            public void run() {
                System.out.println(this.getClass());
            }
        };
        Runnable lambda = () -> System.out.println(this.getClass());
        anonyme.run();
        lambda.run();
    }
}
