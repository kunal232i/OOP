package Assignments;
import java.util.*;

class Order{
   public static int counter = 0;
   public int ID;
   public List<String> itemNames;
   public boolean COD;

   public Order(List<String> _itemNames, boolean _COD) {
       ID= counter+1;
       counter++;
       itemNames = _itemNames;
       COD = _COD;
   }
   public void print(){
       for (String item : itemNames) {
           System.out.print(item+" ");
       }
   }
}

public class Lab5 {

   public static void main(String[] args) {
       Scanner SC = new Scanner(System.in);
       System.out.println("Enter number of orders - ");
       int noOfOrders = SC.nextInt();
       List<order> orders = new ArrayList<>(noOfOrders);

       for (int i = 0; i < noOfOrders; i++) {
           System.out.print("\nEnter number of items - ");
           int noOfItems = SC.nextInt();
           List<String> items = new ArrayList<String>(noOfItems);

           for (int j = 0; j < noOfItems; j++) {
               System.out.printf("%d : Enter item name ",j+1);
               items.add(SC.next());
           }

           System.out.print("Do you want COD - ");
           Boolean wantCod = SC.nextBoolean();

           orders.addAll((Collection<? extends order>) new Order(items, wantCod));
           for (order order : orders) {
               order.print();
           }
       }

   }
}

