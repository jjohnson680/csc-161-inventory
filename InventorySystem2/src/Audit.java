import java.util.ArrayList;

public class Audit extends Menu{

    public void returnValue(ArrayList<InventoryItem> mystuff){


        for(int jndex = 0; jndex < mystuff.size(); ++jndex) {
            if (mystuff.get(jndex) instanceof InventoryItem)
                System.out.print((mystuff.get(jndex)).getName() + ", Value: " + mystuff.get(jndex).getValue());
            else
                System.out.print("Item not an inventory item.");
        }
    }
}


