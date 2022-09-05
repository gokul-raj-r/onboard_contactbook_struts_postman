package com.raj;

public class ContactContext {

    private String name,company,mail;
    private Integer id,number;

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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    ContactContext(Integer id,String name,Integer number,String mail,String company)
    {
        this.id = id;
        this.name=name;
        this.number=number;
        this.mail=mail;
        this.company=company;
    }
}
