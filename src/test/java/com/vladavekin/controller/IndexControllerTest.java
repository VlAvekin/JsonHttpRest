package com.vladavekin.controller;

import com.google.gson.Gson;
import com.vladavekin.domain.DataDomain;
import com.vladavekin.modell.DataModel;
import com.vladavekin.repos.DataDomainRepos;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.core.StringContains.containsString;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@TestPropertySource("/application-test.properties")
public class IndexControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private IndexController controller;

    @Autowired
    private DataDomainRepos dataDomainRepos;

    private OkHttpController okhc = new OkHttpController();

    @Test
    public void indexIsNotNullTest() {
        assertThat(controller).isNotNull();
    }

    @Test
    public void indexContainsStringTest() throws Exception {
        this.mockMvc.perform(get("/"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("JSON HTTP REST")));

    }

    @Before
    public void setUp() throws Exception {
        DataModel dataModel = new DataModel();
        DataDomain dataDomain = new DataDomain();
        dataDomain.setDataModel(dataModel);
        dataDomainRepos.save(dataDomain);
    }

    @Test
    public void indexListTest() throws Exception {
        this.mockMvc.perform(get("/"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(xpath("//*[@id='list-col']/tr").nodeCount(1));

    }

    private String url = "https://lb-api-sandbox.prozorro.gov.ua/api/2.4/contracts/4805f381d48948b1b34d6ea2daa029a3/documents";

    @Test
    public void addDataGetTest() throws Exception {

        String expectedValue = "{\"data\":[{\"hash\":\"md5:787caaf33e54d10e6cd302bce098564c\",\"description\":\"\",\"format\":\"application/vnd.openxmlformats-officedocument.spreadsheetml.sheet\",\"url\":\"https://public-docs-sandbox.prozorro.gov.ua/get/69966a5cbdf94ea9a7420ade7d97ca56?KeyID\\u003d1331dc52\\u0026Signature\\u003d7feOocmK9uCwci0%2FrHMXl4jScyfOTK7XQjnRsJLIZFN21Z9hRDjeZJrrVn4XXiqGjgOSQ6XKtTggvJHe6G8cDQ%253D%253D\",\"title\":\"Додаткова угода.xlsx\",\"documentOf\":\"tender\",\"datePublished\":\"2018-10-08T15:13:06.456131+03:00\",\"documentType\":\"contractSigned\",\"dateModified\":\"2018-10-08T15:13:06.456152+03:00\",\"id\":\"c973e26efa78408c8cf7adbb3c2b11e5\"},{\"hash\":\"md5:ba8ca1580920293ebb33a1dfdb4b74fe\",\"format\":\"application/vnd.openxmlformats-officedocument.wordprocessingml.document\",\"url\":\"https://public-docs-sandbox.prozorro.gov.ua/get/766cc889cc2343fbb7ce802022cabd9b?KeyID\\u003d1331dc52\\u0026Signature\\u003dUuYK9aRGFVDCJdIXNkZnbYPvrnlmSVkLZZmJ2l%252BII7Uc1btir26W0wbT4qFe4CpajDb81%252BI5kYZ5cOQ92uJlDw%253D%253D\",\"title\":\"Перелік змін.docx\",\"documentOf\":\"change\",\"datePublished\":\"2018-10-17T11:53:01.587843+03:00\",\"documentType\":\"contractAnnexe\",\"dateModified\":\"2018-10-17T11:53:01.587874+03:00\",\"relatedItem\":\"028162fdf8634010ac1296b11e685602\",\"id\":\"3b6a91e9c7154f6ebf5e8a8d5c11a357\"},{\"hash\":\"md5:fc4a6b43f2162a74d3de4905f6939d11\",\"format\":\"application/pkcs7-signature\",\"url\":\"https://public-docs-sandbox.prozorro.gov.ua/get/77dab55ea98f401688397fa6faa449ce?KeyID\\u003d1331dc52\\u0026Signature\\u003dyTE1DjbaU2dmrWrFgKwRiuj%2FF8SNosqRRoPZnaNNXmBRHOAp%2FyqITRzlCSEV3bpipWBZns%252BzBso%252BMoZBIC1ZAw%253D%253D\",\"title\":\"sign.p7s\",\"documentOf\":\"contract\",\"datePublished\":\"2018-10-17T11:54:16.657833+03:00\",\"dateModified\":\"2018-10-17T11:54:16.657854+03:00\",\"id\":\"f99bb2ce17c144f3a28f665a9206ab92\"},{\"hash\":\"md5:ba8ca1580920293ebb33a1dfdb4b74fe\",\"format\":\"application/vnd.openxmlformats-officedocument.wordprocessingml.document\",\"url\":\"https://public-docs-sandbox.prozorro.gov.ua/get/d89e4e84fee241ebbbed07a6728dd9c7?KeyID\\u003d1331dc52\\u0026Signature\\u003dqDPX1LbM41tEWl3%2FDgpm6u%2F806x2qb6jddF68KRwbFNbz1S0I62vsiD8Q%252B5dfTEkqY%252BgYZJM%2FrpDsQNI90qWDg%253D%253D\",\"title\":\"Перелік змін.docx\",\"documentOf\":\"change\",\"datePublished\":\"2018-10-17T15:56:22.886361+03:00\",\"documentType\":\"contractAnnexe\",\"dateModified\":\"2018-10-17T15:56:22.886383+03:00\",\"relatedItem\":\"eec9a01f0c3f4884a3edb5bcf9c66b8f\",\"id\":\"e7bf347964704ae98efba0d04b5232bb\"}]}";

        this.mockMvc.perform(get("/").param("data", url))
                .andDo(print())
                .andExpect(status().isOk());

        ArrayList<DataDomain> all = (ArrayList<DataDomain>) dataDomainRepos.findAll();

        DataDomain dataDomain = all.get(all.size()-1);

        final String actualValue = new Gson().toJson(dataDomain.getDataModel(), DataModel.class);

        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void addDataPostTest() throws Exception {
        String expectedValue = "{\"data\":[{\"hash\":\"md5:787caaf33e54d10e6cd302bce098564c\",\"description\":\"\",\"format\":\"application/vnd.openxmlformats-officedocument.spreadsheetml.sheet\",\"url\":\"https://public-docs-sandbox.prozorro.gov.ua/get/69966a5cbdf94ea9a7420ade7d97ca56?KeyID\\u003d1331dc52\\u0026Signature\\u003d7feOocmK9uCwci0%2FrHMXl4jScyfOTK7XQjnRsJLIZFN21Z9hRDjeZJrrVn4XXiqGjgOSQ6XKtTggvJHe6G8cDQ%253D%253D\",\"title\":\"Додаткова угода.xlsx\",\"documentOf\":\"tender\",\"datePublished\":\"2018-10-08T15:13:06.456131+03:00\",\"documentType\":\"contractSigned\",\"dateModified\":\"2018-10-08T15:13:06.456152+03:00\",\"id\":\"c973e26efa78408c8cf7adbb3c2b11e5\"},{\"hash\":\"md5:ba8ca1580920293ebb33a1dfdb4b74fe\",\"format\":\"application/vnd.openxmlformats-officedocument.wordprocessingml.document\",\"url\":\"https://public-docs-sandbox.prozorro.gov.ua/get/766cc889cc2343fbb7ce802022cabd9b?KeyID\\u003d1331dc52\\u0026Signature\\u003dUuYK9aRGFVDCJdIXNkZnbYPvrnlmSVkLZZmJ2l%252BII7Uc1btir26W0wbT4qFe4CpajDb81%252BI5kYZ5cOQ92uJlDw%253D%253D\",\"title\":\"Перелік змін.docx\",\"documentOf\":\"change\",\"datePublished\":\"2018-10-17T11:53:01.587843+03:00\",\"documentType\":\"contractAnnexe\",\"dateModified\":\"2018-10-17T11:53:01.587874+03:00\",\"relatedItem\":\"028162fdf8634010ac1296b11e685602\",\"id\":\"3b6a91e9c7154f6ebf5e8a8d5c11a357\"},{\"hash\":\"md5:fc4a6b43f2162a74d3de4905f6939d11\",\"format\":\"application/pkcs7-signature\",\"url\":\"https://public-docs-sandbox.prozorro.gov.ua/get/77dab55ea98f401688397fa6faa449ce?KeyID\\u003d1331dc52\\u0026Signature\\u003dyTE1DjbaU2dmrWrFgKwRiuj%2FF8SNosqRRoPZnaNNXmBRHOAp%2FyqITRzlCSEV3bpipWBZns%252BzBso%252BMoZBIC1ZAw%253D%253D\",\"title\":\"sign.p7s\",\"documentOf\":\"contract\",\"datePublished\":\"2018-10-17T11:54:16.657833+03:00\",\"dateModified\":\"2018-10-17T11:54:16.657854+03:00\",\"id\":\"f99bb2ce17c144f3a28f665a9206ab92\"},{\"hash\":\"md5:ba8ca1580920293ebb33a1dfdb4b74fe\",\"format\":\"application/vnd.openxmlformats-officedocument.wordprocessingml.document\",\"url\":\"https://public-docs-sandbox.prozorro.gov.ua/get/d89e4e84fee241ebbbed07a6728dd9c7?KeyID\\u003d1331dc52\\u0026Signature\\u003dqDPX1LbM41tEWl3%2FDgpm6u%2F806x2qb6jddF68KRwbFNbz1S0I62vsiD8Q%252B5dfTEkqY%252BgYZJM%2FrpDsQNI90qWDg%253D%253D\",\"title\":\"Перелік змін.docx\",\"documentOf\":\"change\",\"datePublished\":\"2018-10-17T15:56:22.886361+03:00\",\"documentType\":\"contractAnnexe\",\"dateModified\":\"2018-10-17T15:56:22.886383+03:00\",\"relatedItem\":\"eec9a01f0c3f4884a3edb5bcf9c66b8f\",\"id\":\"e7bf347964704ae98efba0d04b5232bb\"}]}";

        this.mockMvc.perform(post("/").param("data", url))
                .andDo(print())
                .andExpect(status().isOk());

        ArrayList<DataDomain> all = (ArrayList<DataDomain>) dataDomainRepos.findAll();

        DataDomain dataDomain = all.get(all.size()-1);

        final String actualValue = new Gson().toJson(dataDomain.getDataModel(), DataModel.class);

        assertEquals(expectedValue, actualValue);
    }

}