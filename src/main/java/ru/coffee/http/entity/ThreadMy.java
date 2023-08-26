package ru.coffee.http.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSetter;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class ThreadMy {
    private String title;
    private String transport_type;
    @JsonSetter("carrier")
    private Carrier carrier;
    @JsonSetter("transport_subtype")
    private TransportSubtype transportSubtype;
    private String number;

}
