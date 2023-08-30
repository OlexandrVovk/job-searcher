package com.webapp.view.services;

import com.webapp.store.dto.RequestDto;
import lombok.SneakyThrows;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;

@Service
public class MainService {


    @SneakyThrows
    public List<RequestDto> getData(String lan, String lvl, String emp)  {
        StringBuilder url = new StringBuilder();
        url.append("http://job-searcher-api:3000");
        url.append("?language=" + URLEncoder.encode(lan, "UTF-8"));
        url.append("&level=" + lvl);
        url.append("&employment=" + emp);
        WebClient.Builder builder = WebClient.builder();
        List<RequestDto> list = builder.build()
                .get()
                .uri(url.toString())
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToFlux(RequestDto.class)
                .collectList()
                .block();
        return list;
    }
}
