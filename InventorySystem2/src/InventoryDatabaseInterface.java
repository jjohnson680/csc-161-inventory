public interface InventoryDatabaseInterface {
    Role ViewRole(int uid);
    boolean AddRole(Role addrole);
    boolean DeleteRole(int uid);
    boolean EditRole(int replaceMe, Role replacewith);
    Role ReloadRole(int uid);

    boolean AddInventoryItem(InventoryItem inv_item);
    InventoryItem ViewInvItem(int inv_num);
    boolean DeleteInvItem(int inv_num);
    boolean EditInvItem(int replaceMe, InventoryItem replacewith);
    InventoryItem ReloadInvItem(int inv_num);
}
