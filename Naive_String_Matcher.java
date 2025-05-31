public class Naive_String_Matcher {
    public static void main(String[] args) {
        String T = "3141592653589";
        String P = "26";
        int n = T.length();
        int m = P.length();
        System.out.println("String: " + T);
        System.out.println("The no to be found: " + P);
        for (int i = 0; i <= n - m; i++) {
            int j;
            for (j = 0; j < m; j++) {
                if (T.charAt(i + j) != P.charAt(j)) {
                    break;
                }
            }

            if (j == m) {
                System.out.println("Pattern occures with shift " + i);
            }
        }
    }
}
