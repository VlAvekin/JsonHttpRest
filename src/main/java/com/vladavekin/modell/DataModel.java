package com.vladavekin.modell;

import java.io.Serializable;
import java.util.Arrays;

public class DataModel implements Serializable {

    private DataJsonModel[] data;

    public DataModel() {
    }

    public DataJsonModel[] getData() {
        return data;
    }

    public void setData(DataJsonModel[] data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "{" +
                "data=" + Arrays.toString(data) +
                '}';
    }
}
