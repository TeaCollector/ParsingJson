package ru.coffee;

import ru.coffee.parsing.ParseJsonTrain;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

public class Main {

    private static String url = "https://api.rasp.yandex.net/v3.0/search/?apikey={keyFromYandex}" +
            "&from=s9607774&to=s9607404&date=2023-08-26";

    public static void main(String[] args) throws IOException {

        getJsonFile();
        ParseJsonTrain parseTrain = new ParseJsonTrain();
        parseTrain.parse();
    }

    private static void getJsonFile() throws IOException {
        File file = new File("jsonexample/scheduleTrain.json");
        URL obj = new URL(url);
        HttpURLConnection connection = (HttpURLConnection) obj.openConnection();
        connection.setRequestMethod("GET");
        try (BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
             BufferedWriter out = new BufferedWriter(new FileWriter(file))) {
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                out.write(inputLine);
            }
        }
    }

}