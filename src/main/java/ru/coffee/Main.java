package ru.coffee;

import ru.coffee.parsing.ParseJsonTrain;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

public class Main {

    private String yandexKey = "f4d143ce-ff0a-4ff9-be80-75c403d04352";

    public static void main(String[] args) throws IOException {

        String url = "https://api.rasp.yandex.net/v3.0/search/?apikey=f4d143ce-ff0a-4ff9-be80-75c403d04352" +
                "&from=s9607774&to=s9607404&date=2023-08-26";
        File file = new File("scheduleTrain.json");

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
        ParseJsonTrain parseTrain = new ParseJsonTrain();
        parseTrain.parse();
    }
}

// https://t.rasp.yandex.ru/station/9607493/ - Пермь 1
// https://t.rasp.yandex.ru/station/9607418/ - Пальники

//9607774 - пермь - 2
//9607404 - екатеринбург