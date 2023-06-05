import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("-------WELCOME TO NUMBER GUESSER GAME-------");
        System.out.println("You have 5 chances to guess the number. Number is between 0-100. Good luck!\n");

        boolean isWin = false;
        int chance = 1, i=0;
        int guessedNum;
        int num = (int) (Math.random()*100);
        while(chance < 6){
            System.out.println((i+1) + ". chance: ");
            guessedNum = input.nextInt();
            while(guessedNum <0 || guessedNum > 100){
                System.out.println("Please enter a number between 0-100!");
                System.out.println((i+1) + ". chance: ");
                guessedNum = input.nextInt();
            }

            if (num > guessedNum)
                System.out.println("Try bigger!");
            else if(num < guessedNum)
                System.out.println("Try smaller!");
            else {
                System.out.println("You found the number!!!");
                isWin = true;
                break;
            }
            chance++;
            i++;
        }

        if(isWin)
            System.out.println("Congrats you guessed right in your " + chance +". chance!");
        else
            System.out.println("You lost! The number was: " + num);
    }
}