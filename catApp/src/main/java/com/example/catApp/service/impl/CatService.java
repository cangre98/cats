package com.example.catApp.service.impl;


import com.example.catApp.domain.CatInformation;
import com.example.catApp.service.ICat;
import com.example.catApp.util.ApiClient;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class CatService implements ICat {

    private final ApiClient apiClient;
    @Value("${api.thecatapi.key}")
    private String apiKey;

    @Value("${api.thecatapi.host}")
    private String hostApi;

    @Value("${api.thecatapi.endpoint.breeds}")
    private String endpointBreeds;


    @Override
    public List<CatInformation> getBreeds() {

        ResponseEntity<List<CatInformation>> response = apiClient.get(getEndpointBreeds(),
                getHeaders(),
                new ParameterizedTypeReference<List<CatInformation>>() {
                });

        return response.getBody();
    }


    @Override
    public CatInformation getBreedById(String idBreed) {

        ResponseEntity<CatInformation> response = apiClient.get(getEndpointBreedById(idBreed),
                getHeaders(),
                CatInformation.class);
        return response.getBody();
    }

    @Override
    public List<CatInformation> searchBreeds(String search, String attachImage) {
        ResponseEntity<List<CatInformation>> response = apiClient.get(getEndpointSearchBreeds(search, attachImage),
                getHeaders(),
                new ParameterizedTypeReference<List<CatInformation>>() {
                });

        return response.getBody();
    }

    private Map<String, String> getHeaders() {

        Map<String, String> headers = new HashMap<>();
        headers.put("x-api-key", apiKey);
        headers.put("Content-Type", "application/json");
        return headers;
    }

    private String getEndpointBreeds() {
        return String.format("%s%s", hostApi, endpointBreeds);
    }

    private String getEndpointBreedById(String idBreed) {
        return String.format("%s%s/%s", hostApi, endpointBreeds, idBreed);
    }

    private String getEndpointSearchBreeds(String search, String attachImage) {
        return String.format("%s%s/search?q=%s&attach_image=%S", hostApi, endpointBreeds, search, attachImage);
    }
}
