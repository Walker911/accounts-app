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
    @Column(columnDefinition = "bigint comment '主键'")
    private Long id;

    @Column(columnDefinition = "date comment '日期'")
    @JsonDeserialize(using = CustomDateDeserializer.class)
    private Date date;
    @Column(columnDefinition = "varchar(100) comment '标题'")
    private String title;
    @Column(columnDefinition = "double comment '数量'")
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
