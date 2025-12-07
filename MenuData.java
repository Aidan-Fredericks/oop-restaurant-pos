import java.util.ArrayList;

public class MenuData {
    public static ArrayList<MenuItem> getMenuItems() {
        ArrayList<MenuItem> list = new ArrayList<>();
        list.add(new MenuItem("Cheese Burger", 9.99, "Juicy beef burger with cheese"));
        list.add(new MenuItem("Margherita pizza", 12.50, "Fresh mozzarella, basil with tomato sauce"));
        list.add(new MenuItem("Lasagne", 10.75, "A baked dish layering wide, flat pasta sheets with ingredients like ragù sauce, creamy béchamel, and plenty of cheese"));
        list.add(new MenuItem("Salad", 7.25, "Healthy green salad with Lettuce, Kale and Tuna"));
        return list;
    }
}
