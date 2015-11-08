package sample.Tables;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.util.LinkedList;

/**
 * Created by PolinaDomnina on 09.04.2015.
 */
public class Insurance_company {
    private IntegerProperty id_company;
    private StringProperty company_name;
    private StringProperty address;
    private StringProperty phone;

    public Insurance_company(int id_company, String company_name, String address, String phone) {
        this.id_company = new SimpleIntegerProperty(id_company);
        this.company_name = new SimpleStringProperty(company_name);
        this.address = new SimpleStringProperty(address);
        this.phone = new SimpleStringProperty(phone);
    }
    public Insurance_company(LinkedList<String> fields){
        this.id_company=new SimpleIntegerProperty(Integer.parseInt(fields.get(0)));
        this.company_name = new SimpleStringProperty(fields.get(1));
        this.address = new SimpleStringProperty(fields.get(2));
        this.phone = new SimpleStringProperty(fields.get(3));

    }

    public IntegerProperty КодProperty() { return id_company; }
    public StringProperty НазваниеProperty() { return company_name; }
    public StringProperty АдресProperty() { return address; }
    public StringProperty ТелефонProperty() { return phone; }
}

