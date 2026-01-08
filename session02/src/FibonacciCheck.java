public class FibonacciCheck {
    public static void main(String[] args) {
        int f0 = 0;
        int f1 = 1;
        int n = 10;
        int fk=0,fk_1 = f1,fk_2=f0;
        for (int i = 1; i < n; i++) {
            fk = fk_1 + fk_2;
            fk_2  = fk_1;
            fk_1 = fk;
        }
    }
}
