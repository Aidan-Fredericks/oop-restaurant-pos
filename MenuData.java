import java.util.ArrayList;

public class MenuData {
    public static ArrayList<MenuItem> getMenuItems() {
        ArrayList<MenuItem> list = new ArrayList<>();

        list.add(new MenuItem("Cheese Burger", 9.99, "Juicy beef patty with melted cheese"));
        list.add(new MenuItem("Crispy Chicken Burger", 10.29, "Breaded chicken breast with mayo and lettuce"));

        list.add(new MenuItem("Margherita Pizza", 12.50, "Fresh mozzarella, basil, tomato sauce"));
        list.add(new MenuItem("Pepperoni Pizza", 13.99, "Loaded with spicy pepperoni slices"));

        list.add(new MenuItem("Lasagne", 10.75, "Layers of pasta, ragu sauce, bechamel, and cheese"));
        list.add(new MenuItem("Spaghetti Bolognese", 10.49, "Classic Italian meat sauce pasta"));

        list.add(new MenuItem("House Green Salad", 7.25, "Lettuce, kale, tuna, and vinaigrette"));
        list.add(new MenuItem("Caesar Salad", 8.50, "Romaine, parmesan, croutons, Caesar dressing"));

        list.add(new MenuItem("French Fries", 4.50, "Crispy golden fries"));
        list.add(new MenuItem("Garlic Bread", 3.99, "Toasted bread with garlic butter"));


        list.add(new MenuItem("Coca-Cola", 2.25, "Classic refreshing cola"));
        list.add(new MenuItem("Iced Tea", 2.49, "Freshly brewed lemon iced tea"));
        list.add(new MenuItem("Latte", 3.99, "Creamy espresso-based latte"));

        return list;
    }
}
