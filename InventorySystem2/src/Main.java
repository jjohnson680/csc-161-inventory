import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        InventoryDatabaseMySQL idb = new InventoryDatabaseMySQL();

        //idb.AddInventoryItem( new CPU("myCPU", 3000f) );

        idb.AddRole(new Role("admin", "InventoryTable", true, true, true, true, true));
        idb.AddRole(new Role("super", "InventoryTable", true, true, true, true, true));
        idb.AddRole(new Role("TheDude", "InventoryTable", true, true, true, true, true));
        idb.AddRole(new Role("TheDuder", "InventoryTable", true, true, true, true, true));




        System.out.println("End program.");
    }
}
