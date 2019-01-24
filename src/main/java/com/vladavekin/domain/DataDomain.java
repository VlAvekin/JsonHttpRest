package com.vladavekin.domain;

import com.vladavekin.modell.DataJsonModel;
import com.vladavekin.modell.DataModel;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Map;

@Entity

public class DataDomain {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    private DataModel dataModel;

    public DataDomain() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public DataModel getDataModel() {
        return dataModel;
    }

    public void setDataModel(DataModel dataModel) {
        this.dataModel = dataModel;
    }
}
