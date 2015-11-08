package Database.Tables;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.util.LinkedList;

/**
 * Created by PolinaDomnina on 08.11.2015.
 */
public class Doctor {
    private IntegerProperty id_doctor;
    private StringProperty doctor_name;
    private StringProperty specialization;
    private StringProperty id_branch;

    public Doctor(int id_doctor, String doctor_name, String specialization, String id_branch) {
        this.id_doctor = new SimpleIntegerProperty(id_doctor);
        this.doctor_name = new SimpleStringProperty(doctor_name);
        this.specialization = new SimpleStringProperty(specialization);
        this.id_branch = new SimpleStringProperty(id_branch);
    }
    public Doctor(LinkedList<String> fields){
        this.id_doctor=new SimpleIntegerProperty(Integer.parseInt(fields.get(0)));
        this.doctor_name = new SimpleStringProperty(fields.get(1));
        this.specialization = new SimpleStringProperty(fields.get(2));
        this.id_branch = new SimpleStringProperty(fields.get(3));
    }

    public IntegerProperty КодProperty() { return id_doctor; }
    public StringProperty ФИО_врачаProperty() { return doctor_name; }
    public StringProperty СпециализацияProperty() { return specialization; }
    //public StringProperty Код_филиалаProperty() { return id_branch; }
    public StringProperty АдресProperty() { return id_branch; }
}