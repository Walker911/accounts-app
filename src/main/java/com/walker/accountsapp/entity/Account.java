package com.walker.accountsapp.entity;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.walker.accountsapp.config.CustomDateDeserializer;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

@Entity
public class Account implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    @JsonDeserialize(using = CustomDateDeserializer.class)
    private Date date;
    @Column
    private String title;
    @Column
    private Double amount;

    public Account() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }
}
