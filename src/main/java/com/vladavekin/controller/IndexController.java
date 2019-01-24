package com.vladavekin.controller;

import com.google.gson.Gson;
import com.vladavekin.domain.DataDomain;
import com.vladavekin.modell.DataModel;
import com.vladavekin.repos.DataDomainRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.validation.Valid;
import java.io.IOException;

@Controller
@RequestMapping("/")
public class IndexController implements WebMvcConfigurer {

    @Autowired
    private DataDomainRepos dataDomainRepos;

    private OkHttpController okhc = new OkHttpController();

    @GetMapping()
    public String index(@RequestParam(required = false) String data,
                        @Valid DataDomain dataDomain,
                        Model model) throws IOException {

        addDB(data, dataDomain);

        getDataJsons(model);

        return "index";
    }

    @PostMapping()
    public String addData(@RequestParam("data") String data,
                          @Valid DataDomain dataDomain,
                          Model model) throws IOException {

        addDB(data, dataDomain);

        getDataJsons(model);

        return "index";
    }

    private void addDB(@RequestParam("data") String data, @Valid DataDomain dataDomain) throws IOException {
        if (!StringUtils.isEmpty(data)){
            String json = okhc.post(data);
            DataModel dataModel = new Gson().fromJson(json, DataModel.class);

            dataDomain.setDataModel(dataModel);
            dataDomainRepos.save(dataDomain);
        }
    }

    private void getDataJsons(Model model) {
        Iterable<DataDomain> dataJsons = dataDomainRepos.findAll();
        model.addAttribute("dataJsons", dataJsons);
    }

}