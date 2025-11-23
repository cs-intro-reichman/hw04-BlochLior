public class Primes {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage <Primes>: expected args[0] = integer - and nothing else.");
            return;
        }
        int n = Integer.parseInt(args[0]);
        boolean [] boolArray = new boolean[n+1];
        for (int i = 0; i < boolArray.length; i++) {
            if (i <= 1) {
                boolArray[i] = false;
            } else {
                boolArray[i] = true;
            }
        }
        int p = 2;
        while (p <= Math.sqrt(n)) {
            int crossOffIdx = p * p;
            while (crossOffIdx < boolArray.length) {
                boolArray[crossOffIdx] = false;
                crossOffIdx += p;
            }
            p++;
            while (p < boolArray.length && !checkIsPrime(boolArray, p)) {
                p++;
            }
        }
        System.out.println("Prime numbers up to " + n + ":");
        printPrimes(boolArray);
        int primesCount = countPrimes(boolArray);
        int percentagePrimes = (int)((double) primesCount / n * 100);
        System.out.print("There are " + primesCount + " primes between 2 and " + n);
        System.out.println(" (" + percentagePrimes + "% are primes)");
    }
    public static boolean checkIsPrime(boolean [] arr, int idx) {
        if (arr.length == 0 || idx >= arr.length) {
            return false;
        } else if (arr[idx] == true) {
            return true;
        }
        return false;
    }

    public static int countPrimes(boolean [] arr) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == true) {
                count++;
            }
        }
        return count;
    }

    public static void printPrimes(boolean [] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == true) {
                System.out.println(i);
            }
        }
    }
}