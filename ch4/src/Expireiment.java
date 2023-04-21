public class Expireiment {
    public static String concat1(char c, int n) {
        String answer = "";
        for (int i=0; i<n; i++) {
            answer += c;
        }
        return answer;
    }

    public static StringBuilder concat2(char c, int n) {
        StringBuilder answer = new StringBuilder();
        for (int i=0; i<n; i++) {
            answer.append(c);
        }
        return answer;
    }






    public static void main(String[] args) {
        int trials = 50;
        long average1 = 0;
        long average2 = 0;

        for (int i = 0; i < trials; i++) {


            long startTime = System.currentTimeMillis();
            System.out.println("concat1:  ");
            // do the stuff
            concat1('~', 50000);
            // show the time
            long endTime = System.currentTimeMillis();
            System.out.println("Time computation took: " + (endTime - startTime));
            average1 += (endTime - startTime);

            startTime = System.currentTimeMillis();
            System.out.println("concat2: ");
            // do the stuff
            concat2('~', 50000);
            // show the time
            endTime = System.currentTimeMillis();
            System.out.println("Time computation took: " + (endTime - startTime));
            average2 += (endTime - startTime);
        }
        System.out.println(average1);
        System.out.println(average2);
        System.out.println((average2 - average1) / trials);

    }
}
