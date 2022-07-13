import java.util.Locale;

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
    public static int countDuplicates(String[] arr) {
        //arr is already sorted
        int num = arr.length - 1;
        int duplicates = 0;
        if (num == 0) {
            return 0;
        }
        if (arr[0].equals(arr[1])) {
            duplicates +=1;
        }
        String[] arr1 = new String[arr.length - 1];
        for (int i = 1; i <= arr1.length; i++) {
            arr1[i - 1] = arr[i];
        }

        return duplicates + countDuplicates(arr1);
    }
    public static boolean verifyPalindrome(String string) {
        if (string == null) {
            return false;
        }
        if (string.equals("")) {
            return true;
        }
        string = string.toLowerCase();
        // iterate through string not including the first letter and the last letter
        String stringer = "";
        boolean answer = true;
        if (string.charAt(0) == string.charAt(string.length() - 1)) {
            answer = true;
        } else {
            return false;
        }
        if (string.length() > 1) {
            stringer = string.substring(1,string.length() - 1);
        } else {
            return true;
        }
        return verifyPalindrome(stringer);
    }
    






    public static void main(String[] args) {
        /*String[][] stringer = {{"b","a"},{"z","x"},{"k","l"}};
        String[] l = mergeAll(stringer);
        for (String i : l) {
            System.out.println(i);
        }
         */
       /* String[] arr = {"a","a","b","b","b"};
        System.out.println(countDuplicates(arr));
        */
        String string = null;
        System.out.println(verifyPalindrome(string));
    }
}
