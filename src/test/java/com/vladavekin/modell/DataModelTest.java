package com.vladavekin.modell;

import org.junit.Test;

import static org.junit.Assert.*;

public class DataModelTest {

    private DataModel dm = new DataModel();

    @Test
    public void DataModelGetSetTest () {

        final DataJsonModel[] inputValue = new DataJsonModel[1];
        final DataJsonModel input = new DataJsonModel();
        input.setDescription("Description");
        input.setFormat("Format");
        input.setUrl("Url");
        input.setLanguage("Language");
        input.setTitle("Title");
        input.setDocumentOf("DocumentOf");
        input.setDatePublished("DatePublished");
        input.setDocumentType("DocumentType");
        input.setDateModified("DateModified");
        input.setRelatedItem("RelatedItem");
        input.setId("Id");
        input.setHash("Hash");
        inputValue[0] = input;

        final DataJsonModel[] expectedValue = inputValue;

        dm.setData(inputValue);

        final DataJsonModel[] actualValue = dm.getData();

        assertArrayEquals(expectedValue, actualValue);

    }
}