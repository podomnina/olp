package Database.Tables;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.util.LinkedList;

/**
 * Created by PolinaDomnina on 07.11.2015.
 */
public class ReceptionRequest {

    private IntegerProperty id;
    private StringProperty doctor_name;
    private StringProperty patient_name;
    private StringProperty date;
    private StringProperty service_name;
    private IntegerProperty price;


    public ReceptionRequest(LinkedList<String> fields){
        this.id=new SimpleIntegerProperty(Integer.parseInt(fields.get(0)));
        this.doctor_name = new SimpleStringProperty(fields.get(1));
        this.patient_name = new SimpleStringProperty(fields.get(2));
        this.date = new SimpleStringProperty(fields.get(3));
        this.service_name = new SimpleStringProperty(fields.get(4));
        this.price=new SimpleIntegerProperty(Integer.parseInt(fields.get(5)));
    }

    public IntegerProperty КодProperty() { return id; }
    public StringProperty ФИО_врачаProperty() { return doctor_name; }
    public StringProperty ФИО_пациентаProperty() { return patient_name; }
    public StringProperty Дата_посещенияProperty() { return date; }
    public StringProperty Название_услугиProperty() { return service_name; }
    public IntegerProperty ЦенаProperty() { return price; }
}
