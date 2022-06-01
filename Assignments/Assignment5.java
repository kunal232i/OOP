import java.util.*;

class order {
    public int orderID;
    public ArrayList<String> itemNames;
    public boolean COD;

    public order(int _orderID, ArrayList<String> _itemNames, boolean _COD) {
        orderID = _orderID;
        itemNames = _itemNames;
        COD = _COD;
    }
}

public class Assignment5 {

    public static ArrayList<String> getItems(ArrayList<order> orders){
        ArrayList<String> items = new ArrayList<String>();
        for( order order:orders) {
            items.addAll(order.itemNames);
        }
        return items;
    }
    public static void main(String[] args) {
        ArrayList<String> itemNames = new ArrayList<String>();
        itemNames.add("Jeans");
        itemNames.add("Shirt");
        itemNames.add("Belt");
        order order1 =new order( 101,itemNames,true);
        itemNames.clear();
        itemNames.add("Tie");
        itemNames.add("Shirt");
        order order2 =new order(102,itemNames,true);
        itemNames.clear();
        itemNames.add("Tshirt");
        itemNames.add("Socks");
        itemNames.add("Tie");
        order order3 =new order(103,itemNames,true);
        ArrayList<order> orders = new ArrayList<order>();
        orders.add(order1);
        orders.add(order2);
        orders.add(order3);
        System.out.println(getItems(orders));
    }
}

