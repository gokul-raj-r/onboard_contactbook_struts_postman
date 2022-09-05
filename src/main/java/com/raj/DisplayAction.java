package com.raj;

import com.opensymphony.xwork2.ActionSupport;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DisplayAction extends ActionSupport {

    private ArrayList ContactList = new ArrayList();

    public ArrayList getContactList() {
        return ContactList;
    }

    public void setList(ArrayList ContactList) {
        this.ContactList = ContactList;
    }

    Property p = new Property();
    Connection con = p.connection();
    public String display() throws SQLException {
        PreparedStatement p = con.prepareStatement("SELECT * from details");
        ResultSet rs = p.executeQuery();

        while (rs.next())
            ContactList.add(new ContactContext(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getString(4),rs.getString(5)));

        return SUCCESS;
    }
}
