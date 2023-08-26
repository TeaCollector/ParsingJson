package ru.coffee.http.entity;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.Map;

@NoArgsConstructor
@AllArgsConstructor
public class Cat {

    private String name;
    @JsonAnyGetter
    private Map<String, String> map = Map.of("name", "Kitty"
            , "secondName", "Pussy");

    public Cat(String name) {
        this.name = name;
    }

    @JsonGetter("catName")
    public String getName() {
        return name;
    }
}
