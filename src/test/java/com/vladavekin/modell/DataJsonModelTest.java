package com.vladavekin.modell;

import org.junit.Test;

import static org.junit.Assert.*;

public class DataJsonModelTest {

    private DataJsonModel djm = new DataJsonModel();

    @Test
    public void HashGetSetTest() {

        final String inputValue = "Hash";
        final String expectedValue = inputValue;

        djm.setHash(inputValue);

        final String actualValue = djm.getHash();

        assertEquals(expectedValue, actualValue);

    }

    @Test
    public void DescriptionGetSetTest() {
        final String inputValue = "Description";
        final String expectedValue = inputValue;

        djm.setDescription(inputValue);

        final String actualValue = djm.getDescription();

        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void FormatGetSetTest() {
        final String inputValue = "Format";
        final String expectedValue = inputValue;

        djm.setFormat(inputValue);

        final String actualValue = djm.getFormat();

        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void UrlGetSetTest() {
        final String inputValue = "Url";
        final String expectedValue = inputValue;

        djm.setUrl(inputValue);

        final String actualValue = djm.getUrl();

        assertEquals(expectedValue, actualValue);
    }


    @Test
    public void LanguageGetSetTest() {
        final String inputValue = "Language";
        final String expectedValue = inputValue;

        djm.setLanguage(inputValue);

        final String actualValue = djm.getLanguage();

        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void TitleGetSetTest() {
        final String inputValue = "Title";
        final String expectedValue = inputValue;

        djm.setTitle(inputValue);

        final String actualValue = djm.getTitle();

        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void DocumentOfGetSetTest() {
        final String inputValue = "DocumentOf";
        final String expectedValue = inputValue;

        djm.setDocumentOf(inputValue);

        final String actualValue = djm.getDocumentOf();

        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void DatePublishedGetSetTest() {
        final String inputValue = "DatePublished";
        final String expectedValue = inputValue;

        djm.setDatePublished(inputValue);

        final String actualValue = djm.getDatePublished();

        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void DocumentTypeGetSetTest() {
        final String inputValue = "Document";
        final String expectedValue = inputValue;

        djm.setDocumentType(inputValue);

        final String actualValue = djm.getDocumentType();

        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void DateModifiedGetSetTest() {
        final String inputValue = "DateModified";
        final String expectedValue = inputValue;

        djm.setDateModified(inputValue);

        final String actualValue = djm.getDateModified();

        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void RelatedItemGetSetTest() {
        final String inputValue = "Related";
        final String expectedValue = inputValue;

        djm.setRelatedItem(inputValue);

        final String actualValue = djm.getRelatedItem();

        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void IdGetSetTest() {
        final String inputValue = "Id";
        final String expectedValue = inputValue;

        djm.setId(inputValue);

        final String actualValue = djm.getId();

        assertEquals(expectedValue, actualValue);
    }

}