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
public class Segments {
    @JsonSetter("thread")
    private ThreadMy thread;
    private From from;
    private To to;
    private String days;
    private String departure;
    private String arrival;
    private String start_date;
    @JsonSetter("tickets_info")
    private TicketsInfo tickets_info;
    private int duration;
}
