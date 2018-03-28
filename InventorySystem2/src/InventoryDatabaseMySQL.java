import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class InventoryDatabaseMySQL implements InventoryDatabaseInterface {

    private Connection conn = null;

    private Connection getConnection() {
        if (conn == null) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                return DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/inventory?useSSL=false", "root", "password"
                );
            } catch (Exception any) {
                any.printStackTrace();
            }
        }
        return conn;
    }

    public int getRoleSize() {
        try {
            ResultSet results = getConnection().createStatement().executeQuery(
                    "SELECT COUNT(*) FROM roles;"
            );
            while (results.next())
                return results.getInt(1);
        } catch (Exception any) {
            any.printStackTrace();
        }
        return 0;
    }

    @Override
    public boolean AddRole(Role addrole) {
        try {
            getConnection().createStatement().executeUpdate(
                    "INSERT INTO roles (uid, rolename, targetname, `permissions-view`, `permissions-add`, `permissions-delete`, `permissions-edit`, `permissions-reload`)" +
                            " VALUES (" + addrole.getUid() +
                            ", '" + addrole.getRolename() +
                            "', '" + addrole.getTargetname() +
                            "', " + (addrole.canView() ? "1" : "0") +
                            ", " + (addrole.canAdd() ? "1" : "0") +
                            ", " + (addrole.canDelete() ? "1" : "0") +
                            ", " + (addrole.canEdit() ? "1" : "0") +
                            ", " + (addrole.canReload() ? "1" : "0") + ");"
            );
        } catch (SQLException any) {
            any.printStackTrace();
        }

        return true;
    }

    @Override
    public Role ViewRole(int uid) {
        Role returnme = null;
        try {
            ResultSet results = getConnection().createStatement().executeQuery(
                    "SELECT * FROM roles WHERE uid=" + uid + ";"
            );
            while (results.next()) {
                returnme = Role.cloneRole(
                        results.getInt(1),
                        results.getString(2),
                        results.getString(3),
                        results.getBoolean(4),
                        results.getBoolean(5),
                        results.getBoolean(6),
                        results.getBoolean(7),
                        results.getBoolean(8)
                );
            }
        } catch (Exception any) {
            any.printStackTrace();
        }
        return returnme;
    }

    @Override
    public boolean DeleteRole(int uid) {
        try {
            getConnection().createStatement().executeUpdate(
                    "DELETE FROM roles WHERE uid=" + uid + ";"
            );
        } catch (SQLException any) {
            any.printStackTrace();
        }
        return true;
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
    public InventoryItem ViewInvItem(int inv_num) {
        InventoryItem returnme = null;
        try {
            ResultSet results = getConnection().createStatement().executeQuery(
                    "SELECT * FROM inventory WHERE inventory_number =" + inv_num + ";"
            );
        } catch (Exception any) {
            any.printStackTrace();
        }
        return returnme;
    }


    @Override
    public boolean AddInventoryItem(InventoryItem inv_item) {
        try {
            getConnection().createStatement().executeUpdate(
                    "INSERT INTO Inventory (inventory_number, kind, name, value, serial_number)" +
                            " VALUES (" + inv_item.getInventoryNumber() +
                            ", '" + inv_item.getClass().getName() +
                            "', '" + inv_item.getName() +
                            "', " + inv_item.getValue() +
                            (inv_item instanceof SerializedItem ? ", '" + ((SerializedItem) inv_item).getSerialnumber() + "');" : ", '0');"));
        } catch (SQLException any) {
            any.printStackTrace();
        }

        return true;
    }

    @Override
    public boolean DeleteInvItem(int inv_num) {
        try {
            getConnection().createStatement().executeUpdate(
                    "DELETE FROM inventory WHERE inventory_number=" + inv_num + ";"
            );
        } catch (SQLException any) {
            any.printStackTrace();
        }
        return true;
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



