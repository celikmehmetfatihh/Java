import java.util.Scanner;

public class Main {

    static boolean isPalindrome(String word){
        int i = 0, j = word.length()-1;

        while(i < word.length()/2){
            if(word.charAt(i) != word.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String word;
        System.out.println("Enter a word to check whether palindromic or not: ");
        word = input.nextLine();

        if(isPalindrome(word))
            System.out.println(word + " is a palindromic word!");
        else
            System.out.println(word + " is not a palindromic word!");
    }
}