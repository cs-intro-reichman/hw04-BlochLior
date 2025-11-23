public class KeywordsDetector {
    public static void main(String[] args) {
        String[] sentences = {
            "Our product will transform the market",
            "Programming is both painful and engaging",
            "This has nothing to do with machine learning",
            "We need to leverage our core competencies",
            "Let's talk about data and algorithms",
            "Chatbots are great but must be used carefully",
            "This blockchain-based solution will disrupt the industry",
            "The team showed great Synergy in the last project",
            "Use simple words without hype and fluff",
            "Our new technology presents a significant paradigm shift",
            "Effective presentations must be clear, concise, and humble"
        };
        // Some keywords that typically signal bullshit contents in business presentations 
        String[] keywords = {"synergy", "disrupt", "leverage", "Paradigm", "transform"};
        detectAndPrint(sentences, keywords);
    }

    // Iterates through all the sentences.
    // If a sentence contains one or more of the kewords, prints it.
    public static void detectAndPrint(String[] sentences, String[] keywords) {
        for (int i = 0; i < sentences.length; i++) {
            String currSentance = sentences[i];
            String evalString = lowerCase(currSentance);
            int j = 0;
            while (j < keywords.length) {
                String currKeyword = lowerCase(keywords[j]);
                if (evalString.contains(currKeyword)) {
                    System.out.println(currSentance);
                    break;
                }
                j++;
            }
        }
    }

    // Ripped from MyString:
    public static String lowerCase(String str) {
        String returnString = "";
        for (int i = 0; i < str.length(); i++) {
            int c = (int)str.charAt(i);
            if (c > 64 && c < 91) {
                c += 32;
            } 
            returnString += (char)c;
        }
        return returnString;
    }

    public static boolean contains(String str1, String str2) {
        if (str2.length() == 0) {
            return true;
        }
        if (str1.length() < str2.length()) {
            return false;
        }
        char [] arr1 = str1.toCharArray();
        char [] arr2 = str2.toCharArray();
        int j = 0;
        while (j <= arr1.length - arr2.length) {
            int i = indexOf(arr1, charAt(arr2, 0), j);
            if (i == -1) {
                return false;
            }
            if (arr1.length < i + arr2.length) {
                return false;
            } 
            char [] tempSubArr = subArray(arr1, i, i + arr2.length);
            if (equals(tempSubArr, arr2)) {
                return true;
            }
            j = i + 1; 
        }
        return false;
    }

    // Methods ripped from: ArrCharOps

    public static char[] subArray(char[] arr, int beginIndex, int endIndex) {
        boolean falseFlags1 = arr.length == 0 || beginIndex > endIndex;
        boolean falseFlags2 = beginIndex < 0 || endIndex > arr.length;
        boolean falseFlags3 = beginIndex > arr.length - 1;
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
    public static char charAt(char[] arr, int index) {
        if (index > arr.length - 1) {
            System.out.println("improper index, returning char \' \'");
            return ' ';
        }
        return arr[index];
    }
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
}
