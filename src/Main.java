import java.util.List;

public class Main {

    /*
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
    */

    public static void main(String[] args) {
        double[] L = {0, 2, 3, 5, 1, 5, 11, 7};
        double[] R = {3, 3.5, 8, 6, 2, 12, 12, 15};
        Main m = new Main();
        List<Integer> cover = m.Driver(L, R);
        m.doubleBubbleSort(L, R);
        for (int i : cover) {
            System.out.println("L: " + L[i] + "   R: " + R[i]);
        }
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

    void doubleBubbleSort(double[] arr1, double[] arr2) {
        int n = arr1.length;
        for (int i = 0; i < n-1; i++) {
            for(int j = 0; j < n - i - 1; j++) {
                if(arr1[j] > arr1[j + 1]) {
                    double temp1 = arr1[j];
                    double temp2 = arr2[j];
                    arr1[j] = arr1[j + 1];
                    arr2[j] = arr2[j + 1];
                    arr2[j + 1] = temp2;
                    arr1[j + 1] = temp1;

                }
            }
        }
    }
}
