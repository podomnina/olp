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
    private int id_doctor;
    private String doctor_name;
    private String specialization;
    private String id_branch;

    public Doctor(int id_doctor, String doctor_name, String specialization, String id_branch) {
        this.id_doctor = id_doctor;
        this.doctor_name = doctor_name;
        this.specialization = specialization;
        this.id_branch = id_branch;
    }

}