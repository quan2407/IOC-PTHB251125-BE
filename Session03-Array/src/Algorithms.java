import java.util.Arrays;
import java.util.Random;

public class Algorithms {
    public static void main(String[] args) {
        // check so nguyen to
//        int totalPrime = 0;
//        int n = 0;
//        int [] primeArr = new int[20];
//        while (totalPrime < 20){
//            boolean isPrime = true;
//            if (n < 2){
//                isPrime = false;
//            } else if (n == 2 || n == 3){
//                isPrime = true;
//            } else {
//                for (int i = 2; i <= Math.sqrt(n); i++){
//                    if (n % i == 0){
//                        isPrime = false;
//                        break;
//                    }
//                }
//            }
//            if (isPrime){
//                primeArr[totalPrime] = n;
//                totalPrime++;
//            }
//            n++;
//        }
//        for (int i = 0; i < primeArr.length; i++){
//            System.out.print(primeArr[i] + " ");
//        }

//        Random rand = new Random();
//        int [] arrayNumbers = new int[100];
//        for (int i = 0; i < arrayNumbers.length; i++) {
//            arrayNumbers[i] = rand.nextInt(1000);
//        }
//
//        for (int i = 0; i < arrayNumbers.length-1; i++) {
//            for (int j = 0; j < arrayNumbers.length-i-1; j++) {
//                if (arrayNumbers[j] > arrayNumbers[j+1]) {
//                    int temp = arrayNumbers[j];
//                    arrayNumbers[j] = arrayNumbers[j+1];
//                    arrayNumbers[j+1] = temp;
//                }
//            }
//        }
//        System.out.println(Arrays.toString(arrayNumbers));

        // 7,4,6,1,3 -- tăng dần
        // [4,7],6,1,3
        // 4,[6,7],1,3
        // 4,6,[1,7],3
        // 4,6,1,[3,7]

        // lần 2: nổi số 6

//        Arrays.sort(arrayNumbers); //quicksort

        String[] names = {"Nam", "An", "Bình", "Dũng"};
        for (int i = 0; i < names.length - 1; i++) {
            for (int j = 0; j < names.length - i - 1; j++) {
                if (names[j].compareTo(names[j + 1]) > 0) {
                    String temp = names[j];
                    names[j] = names[j + 1];
                    names[j + 1] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(names));

    }
}
