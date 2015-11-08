package Database.Tables;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.util.LinkedList;

/**
 * Created by PolinaDomnina on 03.11.2015.
 */
public class Branch {
    private IntegerProperty id_branch;
    private StringProperty branch_address;
    private StringProperty branch_number;

    public Branch(int id_branch, String branch_address, String branch_number) {
        this.id_branch = new SimpleIntegerProperty(id_branch);
        this.branch_address = new SimpleStringProperty(branch_address);
        this.branch_number = new SimpleStringProperty(branch_number);
    }
    public Branch(LinkedList<String> fields){
        this.id_branch=new SimpleIntegerProperty(Integer.parseInt(fields.get(0)));
        this.branch_address = new SimpleStringProperty(fields.get(1));
        this.branch_number = new SimpleStringProperty(fields.get(2));

    }

    public IntegerProperty КодProperty() { return id_branch; }
    public StringProperty АдресProperty() { return branch_address; }
    public StringProperty ТелефонProperty() { return branch_number; }
}