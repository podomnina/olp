package Database.Tables;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.util.LinkedList;

/**
 * Created by PolinaDomnina on 08.11.2015.
 */
public class Patient {
    private IntegerProperty id_patient;
    private StringProperty patient_name;
    private StringProperty patient_phone;

    public Patient(int id_patient, String patient_name, String patient_phone) {
        this.id_patient = new SimpleIntegerProperty(id_patient);
        this.patient_name = new SimpleStringProperty(patient_name);
        this.patient_phone = new SimpleStringProperty(patient_phone);
    }
    public Patient(LinkedList<String> fields){
        this.id_patient=new SimpleIntegerProperty(Integer.parseInt(fields.get(0)));
        this.patient_name = new SimpleStringProperty(fields.get(1));
        this.patient_phone = new SimpleStringProperty(fields.get(2));

    }

    public IntegerProperty КодProperty() { return id_patient; }
    public StringProperty ФИО_пациентаProperty() { return patient_name; }
    public StringProperty ТелефонProperty() { return patient_phone; }
}