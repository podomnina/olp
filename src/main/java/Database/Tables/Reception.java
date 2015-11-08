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
    private IntegerProperty id_reception;
    private StringProperty date;

    public Reception(int id_reception, String date) {
        this.id_reception = new SimpleIntegerProperty(id_reception);
        this.date = new SimpleStringProperty(date);
    }
    public Reception(LinkedList<String> fields){
        this.id_reception=new SimpleIntegerProperty(Integer.parseInt(fields.get(0)));
        this.date = new SimpleStringProperty(fields.get(1));
    }

    public IntegerProperty КодProperty() { return id_reception; }
    public StringProperty Дата_посещенияProperty() { return date; }
}
