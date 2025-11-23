/** A library of operations on arrays of characters (char values).
 *  The library also features a string comparison method. */
public class ArrCharOps {
    public static void main(String[] args) {
        String str = "clearly";
        char[] arr1 = {'c','l','e','a','r','l','y'};
        char[] arr2 = {'U','n','d','e','r','s','t', 'o', 'o', 'd'};
        System.out.println(str);  // Prints the string - clearly;
        println(arr1);            // Prints an array of characters - clearly;
        System.out.println(charAt(arr1,2)); // Prints e;      
        System.out.println(indexOf(arr1,'l')); // Prints 1;
        System.out.println(indexOf(arr1,'l',3)); // Prints 5;
        System.out.println(lastIndexOf(arr1, 'l')); // Prints 5;
        System.out.println(concat(arr1, arr2)); // Prints clearlyUnderstood;
        System.out.println(subArray(arr2, 2, 9)); // Prints derstoo;
        System.out.println(compareTo("abcd", "abcd")); // Prints 0;
        System.out.println(compareTo("abc", "abcd")); // Prints -1;
        System.out.println(compareTo("abw", "abcd")); // Prints 1;
        System.out.println(compareTo("Abcd", "a")); // Prints -1;
        System.out.println(compareTo("apple", "banana")); // Prints -1;
        System.out.println(compareTo("apple", "applepie")); // Prints -1;
        System.out.println(compareTo("Zoo", "zoo")); // Prints -1;
        System.out.println(hashCode(arr1)); // Hash print
        System.out.println(hashCode(arr2)); // Hash print
    }

    /** Prints the given array of characters, and moves the cursor to the next line.
     */
    public static void println(char[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
        }
        System.out.println();
    }

    /** Returns the char value at the specified index. Assume that the array is non-empty.
     */
    public static char charAt(char[] arr, int index) {
        if (index > arr.length - 1) {
            System.out.println("improper index, returning char \' \'");
            return ' ';
        }
        return arr[index];
    }

    /** If the two arrays have the same value in every index, 
     *  returns true; Otherwise returns false.
     */
    public static boolean equals(char[] arr1, char[] arr2) {
        if (arr1.length != arr2.length) {
            return false;
        }
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }

    /** Returns the index within the given array of the first occurrence of the given character.
     *  If no such character is found, returns -1.
     */
    public static int indexOf(char[] arr, char ch) {
        if (arr.length == 0) {
            return -1;
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == ch) {
                return i;
            }
        }
        return -1;
    }

    /** Same as indexOf(char[], char), but starts the search in the given index.
     */
    public static int indexOf(char[] arr, char ch, int fromIndex) {
        if (fromIndex >= arr.length || fromIndex < 0) { 
            System.out.println("Improper fromIndex value, returning -1");
            return -1;
        }
        for (int i = fromIndex; i < arr.length; i++) {
            if (arr[i] == ch) {
                return i;
            }
        }
        return -1;
    }

    /** Returns the index within the given arr of the last occurrence of the given character.
     *  If no such character is found, returns -1.
     */
    public static int lastIndexOf(char[] arr, char ch) {
        if (arr.length == 0) {
            return -1;
        }
        for (int i = arr.length - 1; i > -1; i--) {
            if (arr[i] == ch) {
                return i;
            }
        }
        return -1;
    }


    /* Returns an array which is the concatanation of the two given arrays.
    */
    public static char[] concat(char[] arr1, char[] arr2) {
        if (arr1.length == arr2.length && arr1.length == 0) {
            System.out.println("Provided empty arrays, returning null");
            return null;
        }

        char[] res = new char[arr1.length + arr2.length];
        int i = 0;
        while (i < arr1.length) {
            res[i] = arr1[i];
            i++;
        }
        int j = 0;
        while (j < arr2.length) {
            res[i + j] = arr2[j];
            j++;
        }

        return res;
    }

    /** Returns a new array that can be described as a sub-array of this array.
     *  The sub-array begins at the specified beginIndex and extends to the character at index endIndex - 1.
     *  For example, if arr contains the characters "hamburger", then subArray(4, 8) returns an array of
     *  characters containing the characters "urge".
     */     
    public static char[] subArray(char[] arr, int beginIndex, int endIndex) {
        boolean falseFlags1 = arr.length == 0 || beginIndex > endIndex;
        boolean falseFlags2 = beginIndex < -1 || endIndex > arr.length;
        boolean falseFlags3 = beginIndex > arr.length - 1 || endIndex > arr.length -1;
        boolean flags = falseFlags1 || falseFlags2 || falseFlags3;
        if (flags) {
            System.out.println("Improper inputs provided, returning null");
            return null;
        }

        char [] res = new char[endIndex-beginIndex];
        for (int i = 0; i < res.length; i++) {
            res[i] = arr[i + beginIndex];
        }

        return res;
    }

     /** Returns a single integer that represents the given array. This integer is sometimes 
     *  referred to as the array's "hash code". Later in the course we'll explain what these 
     *  hash codes are used for. For now, simply implement the specification given below.
     *  The hash code is computed as: arr[0]*7^(n-1) + arr[1]*7^(n-2) + ... + arr[n-2]*7 + arr[n-1]
     *  where arr[i] is the i'th character of the array, and n is the array's length.
     *  The hash value of an empty array is zero.
     */
    public static long hashCode(char[] arr) {
        if (arr.length == 0) {
            return 0;
        }
        long hashSum = 0;
        for (int i = 0; i < arr.length; i++) {
            double exponent = arr.length - 1 - i;
            double base = 7;
            hashSum += Math.pow(base, exponent);
        }
        return hashSum;
    }

    /**
     * Compares the two strings lexicographically.
     * Assume that both strings are not empty.
     * 
     * Characters are compared one by one from left to right, using their numeric Unicode values,
        as follows:
     * 1. If two characters at the same position in both strings are different,
     *    the string with the smaller character is considered lexicographically smaller.
     * 2. If all characters in the shorter string match the corresponding characters
     *    in the longer string, the shorter string is considered lexicographically smaller.
     * 3. If both strings have the same characters and the same length, they are considered equal.
     * 
     * Examples:
     * - "apple" is less than "banana" because 'a' comes before 'b'.
     * - "abc" is less than "abcd" because it is shorter.
     * - "hello" is equal to "hello".
     * - "date" is greater than "dark" because 't' comes after 'k'.
     * 
     * @param str1 the first string to compare
     * @param str2 the second string to compare
     * @return -1 if str1 is lexicographically less than str2,
     *         zero if they are equal, and 1 if str1 is
     *         lexicographically greater than str2.
     *         return -2 if there is an error with the input.
     */
    public static int compareTo(String str1, String str2) {
        if (str1.length() == str2.length() && str1.length() == 0) {
            return -2;
        }
        int i = 0;
        while (i < str1.length() && i < str2.length()) {
            if (str1.charAt(i) < str2.charAt(i)) {
                return -1;
            } else if (str2.charAt(i) < str1.charAt(i)) {
                return 1;
            }
            i++;
        }
        if (str1.length() < str2.length()) {
            return -1;
        } else if (str2.length() < str1.length()) {
            return 1;
        }
        return 0;
    }
}
