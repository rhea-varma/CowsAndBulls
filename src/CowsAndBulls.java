import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;


// todo learn to instantiate a class and use non-static members

public class CowsAndBulls {
     static String complete4DigitNumber;

    public static void main(String[] args) {

        int x = 1234;
        System.out.println ( "Cows and Bulls" );
        System.out.println ( "---------------" );
        System.out.println ( "Rules" );
        System.out.println ( "---------------" );
        System.out.println ( "Rule No.1 : The computer will think of a four-digit number with no repeating number e.g 4692 is acceptable and 4990 is not " );
        System.out.println ( "Rule No.2 : You will attempt to guess your number " );
        System.out.println ( "Rule No.3 : The computer will specify how many cows and bulls there are in your guess" );
        System.out.println ( "Cow: when the number is present in the four digit-number but is in the wrong position" );
        System.out.println ( "Bull: When the correct number is in the correct place" );
        System.out.println ( "----------------------------------------------------------------------------------------------------------" );
        Scanner input = new Scanner ( System.in );

        Random rand = new Random ();
//        int num1 = rand.nextInt(10);
//        int num2 = rand.nextInt(10);
//        int num3 = rand.nextInt(10);
//        int num4 = rand.nextInt(10);
//        int completeFourDigitNumber = (num1*1000)+(num2*100)+(num3*10)+num4;

        ArrayList<Integer> rheaList = new ArrayList<Integer> ();

        for (int i = 9; i >= 0; i--) {
            rheaList.add ( i );
        }

        int num1 = 0;
        while (num1 == 0) {
            num1 = rheaList.get ( rand.nextInt ( 10 ) );
        }

        rheaList.remove ( Integer.valueOf ( num1 ) );

        int num2 = rheaList.remove ( rand.nextInt ( 9 ) );
        int num3 = rheaList.remove ( rand.nextInt ( 8 ) );
        int num4 = rheaList.remove ( rand.nextInt ( 7 ) );
        complete4DigitNumber = String.valueOf ( num1 ) + String.valueOf ( num2 ) +
                String.valueOf ( num3 ) + String.valueOf ( num4 );
        // System.out.println ( complete4DigitNumber );

        boolean result = false;
        int tries = 0;

        while (result != true) {
            tries++;
            result = calculatingCowsAndBulls (tries);
        }

        System.out.println("You have completed in "+ tries + " attempts");

    }

    public static boolean calculatingCowsAndBulls(int attemptNo) {

        if (attemptNo == 1) System.out.println ( "What is your guess for the four-digit number?" );
        Scanner input = new Scanner ( System.in );
        String ans = input.next ();
        try {
            int temp = Integer.valueOf(ans);
            if ((temp < 1000) || (temp  > 9999)) {
                System.out.println("Invalid input: Please enter a 4 digit number");
                return false;
            }

            for (int i = 0; i < 3; i++) {

                char c = ans.charAt(i);
                int index = ans.indexOf(c, i + 1);
                if (index != -1){
                    System.out.println("Invalid input: Please ensure that your number does not have repeating digits");
                    return false;
                }
            }
            int bullCount = 0;
            int cowCount = 0;

            for (int i = 0; i < 4; i++) {

                char c = ans.charAt(i);
                int index = complete4DigitNumber.indexOf(c);
                if (index == i ) {
                    bullCount++;
                } else if(index != -1) {
                  cowCount++;
                }
            }

            System.out.println("Attempt #"+ attemptNo + ": You have " + cowCount + " cows and "  + bullCount + " bulls.");

            if (bullCount == 4){

               return true;

            }
            return false;


        } catch (NumberFormatException e) {
            return false;
        }

    }

}

