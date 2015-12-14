package Database.Tables;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.util.LinkedList;

/**
 * Created by PolinaDomnina on 08.11.2015.
 */
public class Reception {
    private int id_reception;
    private String date;

    public Reception(int id_reception, String date) {
        this.id_reception = id_reception;
        this.date = date;
    }

    public int getId_reception() { return id_reception; }
    public String getDate() { return date; }
}
