package com.vladavekin.domain;

import com.vladavekin.modell.DataJsonModel;
import com.vladavekin.modell.DataModel;
import org.junit.Test;

import static org.junit.Assert.*;

public class DataDomainTest {

    private DataDomain dm = new DataDomain();

    @Test
    public void DataModelGetSetTest() {
        final DataJsonModel[] inputDataJsonModelArray = new DataJsonModel[1];
        final DataJsonModel inputDataJsonModel = new DataJsonModel();
        inputDataJsonModel.setDescription("Description");
        inputDataJsonModel.setFormat("Format");
        inputDataJsonModel.setUrl("Url");
        inputDataJsonModel.setLanguage("Language");
        inputDataJsonModel.setTitle("Title");
        inputDataJsonModel.setDocumentOf("DocumentOf");
        inputDataJsonModel.setDatePublished("DatePublished");
        inputDataJsonModel.setDocumentType("DocumentType");
        inputDataJsonModel.setDateModified("DateModified");
        inputDataJsonModel.setRelatedItem("RelatedItem");
        inputDataJsonModel.setId("Id");
        inputDataJsonModel.setHash("Hash");
        inputDataJsonModelArray[0] = inputDataJsonModel;

        final DataModel inputValue = new DataModel();
        inputValue.setData(inputDataJsonModelArray);


        final DataModel expectedValue = inputValue;

        dm.setDataModel(inputValue);

        final DataDomain actualValue = dm;

        assertEquals(expectedValue, actualValue.getDataModel());
    }
}