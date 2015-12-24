package Database.Tables;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.util.LinkedList;

/**
 * Created by PolinaDomnina on 03.11.2015.
 */
public class Branch extends Object {
    private int id_branch;
    private String branch_address;
    private String branch_number;

    public Branch(int id_branch, String branch_address, String branch_number) {
        this.id_branch = id_branch;
        this.branch_address = branch_address;
        this.branch_number = branch_number;
    }


    public int getId_branch() { return id_branch; }
    public String getBranch_address() { return branch_address; }
    public String getBranch_number() { return branch_number; }
}