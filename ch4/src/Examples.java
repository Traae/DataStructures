import java.awt.image.AreaAveragingScaleFilter;
import java.util.Arrays;
public class Examples {
    public static double array(double[] data) {
        int n = data.length;
        double currentMax = data[0];
        for (int j=1; j<n; j++ ) {
            if (data[j] > currentMax) { currentMax = data[j]; }
        }
        return currentMax;
    }  // O(n)

    public static String concat1(char c, int n) {
        String answer = "";
        for (int i=0; i<n; i++) {
            answer += c;  // java creates a new string with the values of the old and new following.
            // its actually for loop under the hood
        }
        return answer;
    } // O(n^2)

    public static StringBuilder concat2(char c, int n) {
        StringBuilder answer = new StringBuilder();
        for (int i=0; i<n; i++) {
            answer.append(c);
        }
        return answer;
    }  // this is order n O(n)

    // return true is no element common to all 3 arrays
    public static boolean disjoint1(int[] Ga, int[] Gb, int[] Gc) {
        for (int a: Ga ) {
            for (int b: Gb) {
                for (int c: Gc) {
                    if ((a==b) & (b==c)) {
                        return false;
                    }
                }
            }
        }
        return  true;
    } // O(n^3)

    public static boolean disjoint2(int[] Ga, int[] Gb, int[] Gc) {
        for (int a: Ga ) {
            for (int b: Gb) {
                if (a==b) {
                    for (int c: Gc) {
                        if ((a==b) & (b==c)) {
                            return false;
                        }
                    }
                }
            }
        }
        return  true;
    } // O n^2 min, optional O n^3

    // check an array for doubleplicates elements
    public static boolean elementUniqeness1(int[] data) {
        int n = data.length;
        for (int i = 0; i<n; i++) {
            for (int k=i+1; k<n; k++) {
                if (data[i] == data[k]) {
                    return false;
                }
            }
        }
        return true;
    } // O(n^2)

    // returns true if there are no duplicates
    public static boolean elementUniqeness2(int[] data) {
        int n = data.length;
        int[] temp = Arrays.copyOf(data,n);
        Arrays.sort(temp);
        for (int i = 0; i<n-1; i++) {
            if (temp[i] == temp[i+1]) {
                return false;
            }
        }
        return true;
    } // O(nLogn)

    // returns an array of prefix averages
    public static double[] prefixAvg(double[] data) {
        int n = data.length;
        double[] a = new double[n];
        for (int j=0; j<n; j++) {
            double total = 0;
            for (int i=0; i<=j; i++) {
                total += data[i];
            }
            a[j] = total / (j+1);
        }
        return  a;
    } // O(n^2)

    // returns an array of prefix averages
    public static double[] prefixAvg2(double[] x) {
        int n = x.length;
        double[] a = new double[n];
        double total = 0;
        for (int j=0; j<n; j++) {
            total += x[j];
            a[j] = total / (j+1);
        }
        return  a;
    } // O(n)



    public static void main (String[] args) {
        System.out.println("agsfgs");
    }
}
