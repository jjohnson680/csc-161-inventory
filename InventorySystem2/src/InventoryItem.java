    public abstract class InventoryItem implements Auditable {
        private static long current_inventory_number = 0;

        public String _name;
        public float _value;
        public long inventory_number;

        public InventoryItem() {
            inventory_number = ++current_inventory_number;
        }

        public static boolean canCreate(String name) throws NoNameException {
            if( name.isEmpty() ) {
                throw new NoNameException("Cannot create without a name.");
            }
            return true;
        }

        public InventoryItem( String name ) {
            _name = name;
        }

        public String getName() {
            return _name;
        }

        public float getValue() {
            return _value;
        }

        public long getInventoryNumber() {
            return inventory_number;
        }

        public static void displayReportHeader() {
            System.out.println("Identity \t\t\tName \t\t\t\t\t\tValue");
        }

        public void displayDetail() {
            System.out.printf("%d\t\t\t\t\t%15s\t\t\t\t%.2f\n", inventory_number, _name, _value );
        }

        public static void displayTotalItemsInInventory() {
            System.out.printf("The total number of items is %d\n" , current_inventory_number);
        }

        public boolean amI(int inventory_number) {
            return this.inventory_number == inventory_number;
        }
    }

