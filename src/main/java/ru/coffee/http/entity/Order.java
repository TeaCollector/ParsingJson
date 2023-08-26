package ru.coffee.http.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@ToString
public class Order {
    private int id;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate date;
}
