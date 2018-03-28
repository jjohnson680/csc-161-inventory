public abstract class SerializedItem extends InventoryItem {
    private String _serialnumber = Long.toHexString(Double.doubleToLongBits(Math.random()));

    public void setSerialnumber(String serialnumber) {
        _serialnumber = serialnumber;
    }

    public String getSerialnumber(){
        return _serialnumber;
    }


}

