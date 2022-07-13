/**
 * @author Umar Manzoor
 * @version 1
 */
public class Recursion {
    /**
     * This method is recursive.
     * @param arr is a String array that
     *            will be merged in lexicographical order
     * @return will be the lexicographically sorted String array
     */
    public static String[] mergeSort(String[] arr) {
        if (arr.length <= 1) {
            return arr;
        }
        int midpoint = arr.length / 2;
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

    /**
     * @param left is the first array that needs to be merged.
     * @param right is the second array that needs to be merged
     * @return is a single array that has been merged from 2 other arrays
     */
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

    /**
     * This method calls a recursive helper method.
     * @param strings is a String[][] that holds string[]'s,
     *               and it combined them with the correct
     *                lexicographical order of each's elements.
     * @return is the String array in lexicographical order
     */
    public static String[] mergeAll(String[][] strings) {
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

    /**
     * This method is recursive.
     * @param arr is a sorted array that needs may contain duplicates
     * @return returns the total number of duplicated items in the sorted array
     */
    public static int countDuplicates(String[] arr) {
        //arr is already sorted
        if (arr.length == 0) {
            return 0;
        }
        int num = arr.length - 1;
        int duplicates = 0;
        if (num == 0) {
            return 0;
        }
        if (arr[0].equals(arr[1])) {
            duplicates += 1;
        }
        String[] arr1 = new String[arr.length - 1];
        for (int i = 1; i <= arr1.length; i++) {
            arr1[i - 1] = arr[i];
        }

        return duplicates + countDuplicates(arr1);
    }

    /**
     * This is a recursive method.
     * @param string is a string that is passed in
     * @return returns whether the given string is a palindrome
     */
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
            stringer = string.substring(1, string.length() - 1);
        } else {
            return true;
        }
        return verifyPalindrome(stringer);
    }

    /**
     * This is a recursive method.
     * @param points point array with points
     * @param radius the distance from teh origin in which the points are allowed to lie
     * @return whether the points lie within the circle or not
     */
    public static int numInteriorPoints(Point[] points, int radius) {
        //keeps track of how many points are inside the circle
        int interiorPoints = 0;
        //this allows it to stop recursion, but t still needs to check the last element in the list
        if (points.length == 1) {
            if (Math.sqrt((points[0].getX() * points[0].getX())
                    + (points[0].getY() * points[0].getY())) < radius) {
                interiorPoints += 1;
            }
            return interiorPoints;
        }
        //finds distance of point from origin,
        // if it is less than the radius, then it is inside the circle
        if (Math.sqrt((points[0].getX() * points[0].getX()
                + (points[0].getY() * points[0].getY()))) < radius) {
            interiorPoints += 1;
        }
        //makes new array of the size we need(original array - 1)
        Point[] pointsMinus1 = new Point[points.length - 1];
        //iterate through the list and make a new one with one less coordinate in it
        for (int i = 0; i < pointsMinus1.length; i++) {
            pointsMinus1[i] = points[i + 1];
        }
        return interiorPoints + numInteriorPoints(pointsMinus1, radius);
    }






    //public static void main(String[] args) {
        /*String[][] stringer = {{"b","a"},{"z","x"},{"k","l"}};
        String[] l = mergeAll(stringer);
        for (String i : l) {
            System.out.println(i);
        }
         */
       /* String[] arr = {"a","a","b","b","b"};
        System.out.println(countDuplicates(arr));
        */
        /*String string = null;
        System.out.println(verifyPalindrome(string));
         */
        /*Point point1 = new Point(1,1);
        Point point2 = new Point(2,2);
        Point point3 = new Point(3,3);
        Point point4 = new Point(1,1);
        Point point5 = new Point(0,4);

        Point[] points = {point1, point2, point3, point4, point5};
        System.out.println(numInteriorPoints(points,5));

         */
    //}
}
