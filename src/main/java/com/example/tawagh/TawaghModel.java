package com.example.tawagh;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;
import lombok.Value;

@JsonSerialize
@Data
public class TawaghModel {
    @JsonProperty("id")
    private Integer id;
    @JsonProperty("Nazwa")
    private String name;
    @JsonProperty("ECTS")
    private Integer ects_points;
    @JsonProperty("Sala")
    private Integer class_room;
    @JsonProperty("Egzamin")
    private String exams;
}
