package com.vladavekin.domain;

import javax.persistence.*;

@Entity
public class DataJson {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    @Column(columnDefinition = "text")
    private String data;

    public DataJson() {
    }

    public DataJson(String data) {
        this.data = data;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
