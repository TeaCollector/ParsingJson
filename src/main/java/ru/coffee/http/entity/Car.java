package ru.coffee.http.entity;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonSetter;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Data
public class Car {
    @JsonSetter("carBrand")
    private String brand;

    private Map<String, String> undetectedField = new HashMap<>();

    @JsonAnySetter
    public void allSetter(String fieldName, String fieldValue) {
        undetectedField.put(fieldName, fieldValue);
    }
}
