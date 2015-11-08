package Database.Tables;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.util.LinkedList;

/**
 * Created by PolinaDomnina on 08.11.2015.
 */
public class Device {
    private IntegerProperty id_device;
    private StringProperty device_name;
    private StringProperty device_firm;

    public Device(int id_device, String device_name, String device_firm) {
        this.id_device = new SimpleIntegerProperty(id_device);
        this.device_name = new SimpleStringProperty(device_name);
        this.device_firm = new SimpleStringProperty(device_firm);
    }
    public Device(LinkedList<String> fields){
        this.id_device=new SimpleIntegerProperty(Integer.parseInt(fields.get(0)));
        this.device_name = new SimpleStringProperty(fields.get(1));
        this.device_firm = new SimpleStringProperty(fields.get(2));

    }

    public IntegerProperty КодProperty() { return id_device; }
    public StringProperty НазваниеProperty() { return device_name; }
    public StringProperty ФирмаProperty() { return device_firm; }
}