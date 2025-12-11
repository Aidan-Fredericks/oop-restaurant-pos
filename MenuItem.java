public class MenuItem {
    private String name;
    private double price;
    private String description;
    private int id;
    private static int count = 0;

    public MenuItem(String name, double price, String description) {
        this.name = name;
        this.price = price;
        this.description = description;
        id = ++count;
    }

    public String getName() { return name; }
    public double getPrice() { return price; }
    public String getDescription() { return description; }
    public int getID(){ return id; }
}
