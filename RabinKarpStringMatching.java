public class RabinKarpStringMatching {
    public static void main(String[] args) {
        String T = "3141592653589";
        String P = "26";
        int q = 11; // A prime number for hashing
        int d = 10; // Number of characters
        System.out.println("Using RabinKarpStringMatching");
        System.out.println("String: "+T);
        System.out.println("The no to be found: "+P);
        RabinKarpMatcher(T, P, d, q);
    }

    static void RabinKarpMatcher(String T, String P, int d, int q) {
        int n = T.length();
        int m = P.length();
        int p = 0;
        int t = 0;
        int h = 1;

        for (int i = 0; i < m - 1; i++) {
            h = (h * d) % q;
        }

        for (int i = 0; i < m; i++) {
            p = (d * p + P.charAt(i)) % q;
            t = (d * t + T.charAt(i)) % q;
        }

        for (int i = 0; i <= n - m; i++) {
            if (p == t) {
                int j;
                for (j = 0; j < m; j++) {
                    if (T.charAt(i + j) != P.charAt(j)) {
                        break;
                    }
                }
                if (j == m) {
                    System.out.println("Pattern occurs with shift " + i);
                }
            }

            if (i < n - m) {
                t = (d * (t - T.charAt(i) * h) + T.charAt(i + m)) % q;
                if (t < 0) {
                    t = t + q;
                }
            }
        }
    }
}