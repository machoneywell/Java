// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
import java.util.Scanner;
class Palindrome {
    public static boolean isPalindrome(String word) {
        int len = word.length();
        int i, j;
        i = 0; j = len-1;
        while ( i < j ) {
            if ( word.charAt(i) != word.charAt(j) )
                return false;
            i++;
            j--;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        while ( scnr.hasNext() ) {
            String word = scnr.next();
            if ( isPalindrome(word) )
                System.out.println("\""+word+"\"" + " is a palindrome");
            else
                System.out.println("\""+word+"\"" + " is NOT a palindrome");
        }
    }
}