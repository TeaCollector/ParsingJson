package ru.coffee.http.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class Carrier {
    private int code;
    private String title;
    private Codes codes;
    private String address;
    private String url;

    @Override
    public String toString() {
        return "Carrier{" +
                "code=" + code +
                ", title='" + title + '\'' +
                ", \n codes=" + codes +
                ", address='" + address + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
