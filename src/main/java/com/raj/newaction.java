package com.raj;

import com.opensymphony.xwork2.ActionSupport;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class newaction extends ActionSupport {

    private String name,company,mail,status;
    private Integer id,number;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    Property p = new Property();
    Connection con = p.connection();

    public String add() throws IOException, SQLException {

        String sql ="INSERT into details (name,number,mail,company) values(?,?,?,?)";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1,name);
        ps.setInt(2, number);
        ps.setString(3,mail);
        ps.setString(4,company);

        int rs = ps.executeUpdate();
        if(rs==1)
            setStatus("Created...");
        else
            setStatus("Not Created");
        return SUCCESS;
    }

    public String edit() throws SQLException {

        PreparedStatement pd = con.prepareStatement("SELECT * from details WHERE id =?");
        pd.setInt(1,id);
//        ResultSet r = pd.executeQuery();

        Statement p= con.createStatement();
        int rs = 0;
        ResultSet r ;
        if (!name.isEmpty()) {
            rs = p.executeUpdate("UPDATE details SET name= '"+name+"' WHERE id="+id+"");
        }
        else {
            r= p.executeQuery("SELECT name FROM details WHERE id ="+id+"");
            if(r.next())
                setName(r.getString(1));
        }
        if (number!=0) {
            rs = p.executeUpdate("UPDATE details SET number= '"+number+"' WHERE id="+id+"");
        }
        else {
            r= p.executeQuery("SELECT number FROM details WHERE id ="+id+"");
            if(r.next())
                setNumber(r.getInt(1));
        }
        if (!mail.isEmpty()) {
            rs = p.executeUpdate("UPDATE details SET mail= '"+mail+"' WHERE id="+id+"");
        }
        else {
            r= p.executeQuery("SELECT mail FROM details WHERE id ="+id+"");
            if(r.next())
                setMail(r.getString(1));
        }
        if (!company.isEmpty()) {
            rs = p.executeUpdate("UPDATE details SET company= '"+company+"' WHERE id="+id+"");
        }
        else {
            r= p.executeQuery("SELECT company FROM details WHERE id ="+id+"");
            if(r.next())
                setCompany(r.getString(1));
        }
//        PreparedStatement p = con.prepareStatement("UPDATE details SET name= '"+name+"',number= '"+number+"',mail= '"+mail+"',company= '"+company+"' WHERE id =?");
//        p.setInt(1,id);

//        int rs = p.executeUpdate();
        if(rs==1)
            setStatus("Updated...");
        else
            setStatus("Not Updated");

        return SUCCESS;
    }

    public String delete() throws SQLException {
        PreparedStatement p = con.prepareStatement("DELETE from details WHERE id =?");
        p.setInt(1,id);

        PreparedStatement pd = con.prepareStatement("SELECT * from details WHERE id =?");
        pd.setInt(1,id);
        ResultSet rs = pd.executeQuery();


        while (rs.next()) {
            setId(rs.getInt(1));
            setName(rs.getString(2));
            setNumber(Integer.valueOf(rs.getString(3)));
            setMail(rs.getString(4));
            setCompany(rs.getString(5));
        }

        int r = p.executeUpdate();
        if(r==1)
            setStatus("Deleted...");
        else
            setStatus("Not Deleted");

        return SUCCESS;
    }

}
