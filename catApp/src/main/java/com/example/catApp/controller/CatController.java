package com.example.catApp.controller;


import com.example.catApp.domain.CatInformation;
import com.example.catApp.service.ICat;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/cat")
@Slf4j
@AllArgsConstructor
public class CatController {

    private final ICat catService;

    @GetMapping("/breeds")
    public List<CatInformation> getBreeds() {
        return catService.getBreeds();
    }

    @GetMapping(path = "breeds/{idBreed}")
    public CatInformation getBreedById(@PathVariable String idBreed) {
        return catService.getBreedById(idBreed);
    }

    @GetMapping("/breeds/search")
    public List<CatInformation> searchBreeds(@RequestParam(name = "q") String search,
                                             @RequestParam("attach_image") String attachImage) {

        return catService.searchBreeds(search, attachImage);
    }


}

