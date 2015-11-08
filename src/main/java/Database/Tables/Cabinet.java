package Database.Tables;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.util.LinkedList;

/**
 * Created by PolinaDomnina on 06.11.2015.
 */
public class Cabinet {
    private IntegerProperty id_cabinet;
    private IntegerProperty cabinet_number;
    private StringProperty cabinet_specialization;

    public Cabinet(int id_cabinet, int cabinet_number, String cabinet_specialization) {
        this.id_cabinet = new SimpleIntegerProperty(id_cabinet);
        this.cabinet_number = new SimpleIntegerProperty(cabinet_number);
        this.cabinet_specialization = new SimpleStringProperty(cabinet_specialization);
    }
    public Cabinet(LinkedList<String> fields){
        this.id_cabinet=new SimpleIntegerProperty(Integer.parseInt(fields.get(0)));
        this.cabinet_number = new SimpleIntegerProperty(Integer.parseInt(fields.get(1)));
        this.cabinet_specialization = new SimpleStringProperty(fields.get(2));

    }
    public IntegerProperty КодProperty() { return id_cabinet; }
    public IntegerProperty Номер_кабинетаProperty() { return cabinet_number; }
    public StringProperty СпециализацияProperty() { return cabinet_specialization; }
}
