import java.util.*;

public class Lab4 {


    public static void main(String[] args) {

        while(true)
        {
            Scanner sc = new Scanner(System.in);
            System.out.println("Which operation do you want to perform");
            System.out.println("1: division");
            System.out.println("2: Array operation");
            System.out.println("3: Strings");
            System.out.println("4: exit");
            System.out.println("Enter your choice:");

            int ch = sc.nextInt();



            switch (ch) {
                case 1:
                    System.out.println("Enter first no.: ");
                    System.out.println();
                    int No1 = sc.nextInt();
                    System.out.println("\nEnter second no: ");
                    int No2 = sc.nextInt();
                    try {

                        System.out.println("\ndivision: " + No1 / No2);
                    } catch (ArithmeticException ae) {
                        System.out.println("\nYou shouldn’t divide a number by zero.");
                    }
                    break;

                case 2:
                    System.out.println("\nCreating a Null String");
                    String str = null;
                    try {
                        System.out.println(str.length());
                    } catch (NullPointerException ae) {
                        System.out.println("\nNull Pointer Exception arises!!");
                    }
                    break;
                case 3:
                    String arr[] = new String[6];
                    int index = 0;

                    System.out.println("Enter 6 names");
                    for (int i = 0; i < 6; i++) {
                        arr[i] = sc.next();
                    }
                    try {
                        System.out.println("\nEnter the index no to see the entered name");
                        index = sc.nextInt();
                        System.out.println("Entered name is: " + arr[index]);
                    } catch (ArrayIndexOutOfBoundsException ae) {
                        System.out.println("OOPs!!!Array Index " + index + " out of bounds for length " + arr.length);
                    }
                    break;
                case 4:
                    return;
                default:
                    System.out.println("\nInvalid Number...Enter number again!!");
                    break;
            }

        }

    }
}

