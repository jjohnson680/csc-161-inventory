import java.util.ArrayList;

public class InventoryDatabase implements InventoryDatabaseInterface{
    private ArrayList<Role> roles = new ArrayList();
    private ArrayList<InventoryItem> inventory = new ArrayList<>();

    public int getSize() {
        return roles.size();
    }

    @Override
    public boolean AddRole(Role addrole) {
        return roles.add(addrole);
    }

    @Override
    public Role ViewRole(int uid) {
        for( Role lookin : roles) {
            if( lookin.amI(uid) )
                return lookin;
        }
        return null;
    }

    @Override
    public boolean DeleteRole(int uid) {
        return roles.remove(ViewRole(uid));
    }

    @Override
    public boolean EditRole(int replaceme, Role replacewith) {
        return DeleteRole(replaceme) && AddRole(replacewith);
    }

    @Override
    public Role ReloadRole(int uid) {
        return ViewRole(uid);
    }

    @Override
    public boolean AddInventoryItem(InventoryItem inv_item) {
        return inventory.add(inv_item);
    }

    @Override
    public InventoryItem ViewInvItem(int inv_num) {
        for(InventoryItem lookin : inventory){
            if(lookin.amI(inv_num))
                return lookin;
        }return null;
    }

    @Override
    public boolean DeleteInvItem(int inv_num) {
        return inventory.remove(ViewInvItem(inv_num));
    }

    @Override
    public boolean EditInvItem(int replaceMe, InventoryItem replacewith) {
        return DeleteInvItem(replaceMe) && AddInventoryItem(replacewith);
    }

    @Override
    public InventoryItem ReloadInvItem(int inv_num) {
        return ViewInvItem(inv_num);
    }
}