import java.util.List;

public class Bakery extends Expired{
    private boolean glutenFree;//variable for whether item is gluten free

    public Bakery(int id, String name, String description, float price, int daysToExpire, boolean quantityBased, boolean glutenFree, List<Retailer> retailers) {//constructor
        super(id, name, description, price, daysToExpire, quantityBased,  retailers);
        this.glutenFree = glutenFree;
    }

    public boolean isGlutenFree() {//get method for glutenFree
        return glutenFree;
    }

    public void setGlutenFree(boolean glutenFree) {//set method for glutenFree
        this.glutenFree = glutenFree;
    }
}
