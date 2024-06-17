
package com.example.catApp.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class CatInformation {

    @JsonProperty("weight")
    private Weight weight;
    @JsonProperty("id")
    private String id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("vetstreet_url")
    private String vetstreetUrl;
    @JsonProperty("temperament")
    private String temperament;
    @JsonProperty("origin")
    private String origin;
    @JsonProperty("country_codes")
    private String countryCodes;
    @JsonProperty("country_code")
    private String countryCode;
    @JsonProperty("description")
    private String description;
    @JsonProperty("life_span")
    private String lifeSpan;
    @JsonProperty("indoor")
    private Integer indoor;
    @JsonProperty("alt_names")
    private String altNames;
    @JsonProperty("adaptability")
    private Integer adaptability;
    @JsonProperty("affection_level")
    private Integer affectionLevel;
    @JsonProperty("child_friendly")
    private Integer childFriendly;
    @JsonProperty("dog_friendly")
    private Integer dogFriendly;
    @JsonProperty("energy_level")
    private Integer energyLevel;
    @JsonProperty("grooming")
    private Integer grooming;
    @JsonProperty("health_issues")
    private Integer healthIssues;
    @JsonProperty("intelligence")
    private Integer intelligence;
    @JsonProperty("shedding_level")
    private Integer sheddingLevel;
    @JsonProperty("social_needs")
    private Integer socialNeeds;
    @JsonProperty("stranger_friendly")
    private Integer strangerFriendly;
    @JsonProperty("vocalisation")
    private Integer vocalisation;
    @JsonProperty("experimental")
    private Integer experimental;
    @JsonProperty("hairless")
    private Integer hairless;
    @JsonProperty("natural")
    private Integer natural;
    @JsonProperty("rare")
    private Integer rare;
    @JsonProperty("rex")
    private Integer rex;
    @JsonProperty("suppressed_tail")
    private Integer suppressedTail;
    @JsonProperty("short_legs")
    private Integer shortLegs;
    @JsonProperty("wikipedia_url")
    private String wikipediaUrl;
    @JsonProperty("hypoallergenic")
    private Integer hypoallergenic;
    @JsonProperty("reference_image_id")
    private String referenceImageId;



}
