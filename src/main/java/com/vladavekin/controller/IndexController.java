package com.vladavekin.controller;

import com.vladavekin.domain.DataJson;
import com.vladavekin.repos.DataJsonRepos;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
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
    private DataJsonRepos dataRepos;

    private OkHttpClient client = new OkHttpClient();

    @GetMapping()
    public String index(@RequestParam(required = false) String data,
                        @Valid DataJson dataJson,
                        Model model) throws IOException {

        if (!StringUtils.isEmpty(data)){
            addDB(data, dataJson);
        }

        getDataJsons(model);

        return "index";
    }

    private void getDataJsons(Model model) {
        Iterable<DataJson> dataJsons = dataRepos.findAll();
        model.addAttribute("dataJsons", dataJsons);
    }

    @PostMapping()
    public String addData(@RequestParam("data") String data,
                          @Valid DataJson dataJson,
                          Model model) throws IOException {

        addDB(data, dataJson);

        getDataJsons(model);

        return "index";
    }

    private void addDB(@RequestParam("data") String data,
                       @Valid DataJson dataJson) throws IOException {
        String res = post(data);

        dataJson.setData(res);

        dataRepos.save(dataJson);
    }

    private String post(String url) throws IOException {
        Request request = new Request.Builder()
                .url(url)
                .build();
        try (Response response = client.newCall(request).execute()) {
            return response.body().string();
        }
    }

}