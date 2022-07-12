public class Recursion {
    public static String[] mergeSort(String[] arr) {
        if (arr.length <= 1) {
            return arr;
        }
        int midpoint = arr.length/2;
        //System.out.println(midpoint);

        String[] left = new String[midpoint];
        String[] right = new String[arr.length - midpoint];
        //copies values into left array
        for (int i = 0; i < arr.length; i++) {
            if (i < midpoint) {
                left[i] = arr[i];
                //System.out.print("left   " + arr[i] + "     ");
            } else {
                right[i - midpoint] = arr[i];
                //System.out.print("right   " + arr[i] + "     ");
            }
        }

        left = mergeSort(left);
        right = mergeSort(right);

        String[] result = merge(left, right);
        return result;
    }
    public static String[] merge(String[] left, String[] right) {
        String[] result = new String[left.length + right.length];
        int i, j, k;
        i = 0;
        j = 0;
        k = 0;
        while (i < left.length && j < right.length) {
            if (left[i].compareTo(right[j]) <= 0) {
                result[k++] = left[i++];
            } else {
                result[k++] = right[j++];
            }
        }
        while (i < left.length) {
            result[k++] = left[i++];
        }
        while (j < right.length) {
            result[k++] = right[j++];
        }
        return result;
    }

    public static String[] mergeAll(String[][] strings) {
        /*String[] result = null;
        for (int i = 0; i < strings.length; i++) {
            if (i == (strings.length - 1)) {
                break;
            }
            //System.out.println(strings[i]);
            result = merge(strings[i], strings[i + 1]);
            //System.out.println(result);
        }
        //System.out.println(result);
        return result;
         */
        int size = 0;
        for (int i = 0; i < strings.length; i++) {
            for (int j = 0; j < strings[i].length; j++) {
                size++;
            }
        }
        String[] result = new String[size];
        int count = 0;
        for (int i = 0; i < strings.length; i++) {
            for (int j = 0; j < strings[i].length; j++) {
                result[count] = strings[i][j];
                count++;
            }
        }
        result = mergeSort(result);
        return result;
    }






    public static void main(String[] args) {
        String[][] stringer = {{"b","a"},{"z","x"},{"k","l"}};
        String[] l = mergeAll(stringer);
        for (String i : l) {
            System.out.println(i);
        }
    }
}
