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
    @JsonProperty("name")
    private String name;
    @JsonProperty("ects")
    private Integer ects_points;
    @JsonProperty("class")
    private Integer class_room;
    @JsonProperty("exam")
    private boolean exam;
}
