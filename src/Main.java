import java.util.List;

public class Main {

        public static void main (String[] args){
        String str = "1";
        System.out.println("0: " + str);
        for(int i = 0; i < 32; i++)
        {
            str = recurse(str, 0);
            System.out.println((i + 1) + ": " + str);
        }
    }

    private static String recurse(String str, int start) {
        StringBuilder out = new StringBuilder();
        char cur = str.charAt(start);
        int i;
        for (i = start; i < str.length(); i++) {
            if (str.charAt(i) != cur) {
                break;
            }
        }
        out.append(i - start);
        out.append(cur);
        if (i < str.length()) {
            out.append(recurse(str, i));
        }
        return out.toString();
    }

    List<Integer> Driver(double[] L, double[] R) {
        doubleBubbleSort(L, R);
        System.out.println(Arrays.toString(L));
        System.out.println(Arrays.toString(R));

        List<Integer> excl = new ArrayList<>();
        List<Integer> incl = new ArrayList<>();

        double largestRightEndpoint = -Double.MAX_VALUE;
        int largestRightIndex = 0;
        if (L[1] == L[0]) {
            for (int i = 0; i < L.length; i++) {
                if (L[i] == L[0] && R[i] > largestRightEndpoint) {
                    largestRightEndpoint = L[i];
                    largestRightIndex = i;
                }
            }
        }
        incl.add(largestRightIndex);
        return smallestCover(L, R, excl, incl, largestRightIndex);
    }
}
