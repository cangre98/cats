package com.example.catApp.util;

import com.example.catApp.domain.exception.ApiException;
import lombok.AllArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Component
@AllArgsConstructor
public class ApiClient {
    private final RestTemplate restTemplate;

    public <T> ResponseEntity<T> get(String url, Map<String, String> headers, ParameterizedTypeReference<T> responseType) {
        try {
            HttpEntity<String> entity = new HttpEntity<>(createHeaders(headers));
            return restTemplate.exchange(url, HttpMethod.GET, entity, responseType);
        } catch (Exception e) {
            throw new ApiException(MessagesUtils.MSN_ERROR_API);
        }
    }

    public <T> ResponseEntity<T> get(String url, Map<String, String> headers, Class<T> responseType) {
        try {
            HttpEntity<String> entity = new HttpEntity<>(createHeaders(headers));
            return restTemplate.exchange(url, HttpMethod.GET, entity, responseType);
        } catch (Exception e) {
            throw new ApiException(MessagesUtils.MSN_ERROR_API);
        }
    }

    private HttpHeaders createHeaders(Map<String, String> headersMap) {
        HttpHeaders headers = new HttpHeaders();
        if (headersMap != null) {
            headersMap.forEach(headers::set);
        }
        return headers;
    }
}
