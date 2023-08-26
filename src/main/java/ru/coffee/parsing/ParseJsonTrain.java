package ru.coffee.parsing;

import com.fasterxml.jackson.databind.ObjectMapper;
import ru.coffee.http.entity.*;

import java.io.File;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParseJsonTrain {

    File file = new File("jsonexample/scheduleTrain.json");
    ObjectMapper objectMapper = new ObjectMapper().findAndRegisterModules();

    public void parse() {

        Train train = null;
        String json = "";

        Pattern pattern = Pattern.compile("(.*)T(.*)\\+.*");
        Matcher matcher;
        try {
            train = objectMapper.readValue(file, Train.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        String departure;
        String arrival;
        for (Segments segments : train.getSegments()) {

            matcher = pattern.matcher(segments.getDeparture());
            matcher.find();
            departure = matcher.group(2);
            matcher = pattern.matcher(segments.getArrival());
            matcher.find();
            arrival = matcher.group(2);
            System.out.print("Начальная и конечная станция: " + segments.getThread().getTitle() + "\n" +
                    "Тип поезда: " + segments.getThread().getTransportSubtype().getTitle() +
                    "\nНомер поезда:" + segments.getThread().getNumber() +
                    "\nОтправляется со станции: " +
                    "" + segments.getFrom().getTitle() + " в " + departure +
                    "\nПрибывает на станцию: " + segments.getTo().getTitle() + " в " + arrival +
                    "\nСтоимость поездки: " + segments.getTickets_info().getPlaces().isEmpty() +
                    "\nЕсть ли возможность купить билет: " + segments.getTickets_info().isEt_marker() +
                    "\nПродолжительность поездки: " + segments.getDuration() / 60 + " минут.\n\n");
        }
    }
}
