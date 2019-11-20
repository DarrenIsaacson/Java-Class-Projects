package Exceptions;

public class newExceptionTest {
    public static void main(String[] args) {
        String numString = "cat";
        try {



            int number = Integer.parseInt(numString);

            System.out.println(number);

        } catch (NumberFormatException nfe ) {
            System.out.println("Error, not a number: " + numString);
        }



    }
}
