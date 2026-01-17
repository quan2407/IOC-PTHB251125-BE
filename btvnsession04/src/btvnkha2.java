public class btvnkha2 {
    public static void main(String[] args) {

        // 1. String
        String str1 = "Hello";
        long start = System.currentTimeMillis();
        for (int i = 0; i < 1_000_000; i++) {
            str1 = str1.concat(" World");
        }
        long end = System.currentTimeMillis();
        System.out.println("String time: " + (end - start) + " ms");

        // 2. StringBuffer
        StringBuffer str2 = new StringBuffer("Hello");
        start = System.currentTimeMillis();
        for (int i = 0; i < 1_000_000; i++) {
            str2.append(" World");
        }
        end = System.currentTimeMillis();
        System.out.println("StringBuffer time: " + (end - start) + " ms");

        // 3. StringBuilder
        StringBuilder str3 = new StringBuilder("Hello");
        start = System.currentTimeMillis();
        for (int i = 0; i < 1_000_000; i++) {
            str3.append(" World");
        }
        end = System.currentTimeMillis();
        System.out.println("StringBuilder time: " + (end - start) + " ms");
    }
}
