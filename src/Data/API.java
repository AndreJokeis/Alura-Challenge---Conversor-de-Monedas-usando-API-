package Data;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class API {
    private final String uri;
    private ConversionEX jsonEX;

    public API(String base_code, String target_code) {
        // API KEY USADA PARA EL PROYECTO (PUEDES CAMBIARLA SI GUSTAS)
        String api_key = "851f603d4c2ca9120cfa26c2";
        this.uri = "https://v6.exchangerate-api.com/v6/" + api_key + "/pair/" + base_code + "/" + target_code;
    }

    private String getQuery() throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(uri))
                .build();
        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());

        return response.body();
    }

    public ConversionEX createConversion(){
        try{
            Gson gson = new GsonBuilder()
                    .setPrettyPrinting()
                    .create();

            jsonEX = gson.fromJson(getQuery(), ConversionEX.class);
        } catch (IOException e) {
            System.out.println("Error de conexión: Verifica tu internet o la URL.");
        } catch (InterruptedException e) {
            System.out.println("La solicitud fue interrumpida inesperadamente.");
        } catch (Exception e) {
            System.out.println("Ocurrió un error inesperado: " + e.getMessage());
        }

        return jsonEX;
    }
}
