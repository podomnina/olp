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
    private int id_service;
    private String service_name;
    private int price;

    public Service(int id_service, String service_name, int price) {
        this.id_service = id_service;
        this.service_name = service_name;
        this.price = price;
    }

    public int getId_service() { return id_service; }
    public String getService_name() { return service_name; }
    public int getPrice() { return price; }
}
