package Database.Tables;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.util.LinkedList;

/**
 * Created by PolinaDomnina on 08.11.2015.
 */
public class Service {
    private IntegerProperty id_service;
    private StringProperty service_name;
    private IntegerProperty price;

    public Service(int id_service, String service_name, int price) {
        this.id_service = new SimpleIntegerProperty(id_service);
        this.service_name = new SimpleStringProperty(service_name);
        this.price = new SimpleIntegerProperty(price);
    }
    public Service(LinkedList<String> fields){
        this.id_service=new SimpleIntegerProperty(Integer.parseInt(fields.get(0)));
        this.service_name = new SimpleStringProperty(fields.get(1));
        this.price = new SimpleIntegerProperty(Integer.parseInt(fields.get(2)));

    }

    public IntegerProperty КодProperty() { return id_service; }
    public StringProperty Название_услугиProperty() { return service_name; }
    public IntegerProperty ЦенаProperty() { return price; }
}
