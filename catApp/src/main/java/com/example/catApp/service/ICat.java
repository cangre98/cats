package com.example.catApp.service;

import com.example.catApp.domain.CatInformation;

import java.util.List;

public interface ICat {

    List<CatInformation> getBreeds();
    CatInformation getBreedById(String idBreed);
    List<CatInformation> searchBreeds(String search, String attachImage);
}
