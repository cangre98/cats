package com.example.catApp;

import com.example.catApp.domain.CatInformation;
import com.example.catApp.service.impl.CatService;
import com.example.catApp.util.ApiClient;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.anyMap;
import static org.mockito.ArgumentMatchers.*;


class CatAppApplicationTests {

    @Mock
    private ApiClient apiClient;


    @InjectMocks
    private CatService catService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }


    @Test
    public void testGetBreedsOK() {

        ResponseEntity<List<CatInformation>> responseEntity = new ResponseEntity<>(createListCatInformation(), HttpStatus.OK);

        when(apiClient.get(any(String.class), anyMap(), any(ParameterizedTypeReference.class)))
                .thenReturn(responseEntity);

        List<CatInformation> respuesta = catService.getBreeds();

        assertEquals(2, respuesta.size());

    }

    @Test
    public void testGetBreedByIdOK() {

        ResponseEntity<CatInformation> responseEntity = new ResponseEntity<>(createCatInformation(), HttpStatus.OK);

        when(apiClient.get(any(String.class), anyMap(), eq(CatInformation.class)))
                .thenReturn(responseEntity);

        CatInformation respuesta = catService.getBreedById("sava");

        assertEquals("sava", respuesta.getId());

    }

    @Test
    public void testGearchBreedsOK() {

        ResponseEntity<List<CatInformation>> responseEntity = new ResponseEntity<>(createListCatInformation(), HttpStatus.OK);

        when(apiClient.get(any(String.class), anyMap(), any(ParameterizedTypeReference.class)))
                .thenReturn(responseEntity);

        List<CatInformation> respuesta = catService.searchBreeds("American", "2");

        assertEquals(2, respuesta.size());

    }


    private CatInformation createCatInformation() {

        return CatInformation.builder().id("sava").name("Savannah")
                .vetstreetUrl("http:/wwwvetstreetcom/cats/savannah")
                .temperament("Curious")
                .origin("United States")
                .countryCodes("US")
                .countryCode("US")
                .description("Savannah is the feline version of a dog Actively seeking social interaction")
                .lifeSpan("17 - 20")
                .indoor(0)
                .altNames("dsadasd")
                .adaptability(5)
                .affectionLevel(5)
                .childFriendly(4)
                .dogFriendly(5)
                .energyLevel(5)
                .grooming(1)
                .healthIssues(1)
                .intelligence(5)
                .sheddingLevel(3)
                .socialNeeds(5)
                .strangerFriendly(5)
                .vocalisation(1)
                .experimental(1)
                .hairless(0)
                .natural(0)
                .rare(0)
                .rex(0)
                .suppressedTail(0)
                .shortLegs(0)
                .wikipediaUrl("https//enwikipediaorg/wiki/Savannah_cat")
                .hypoallergenic(0)
                .referenceImageId("a8nIYvs6Sbuild").build();
    }

    private List<CatInformation> createListCatInformation(){
        return List.of(createCatInformation(),createCatInformation());
    }

}
