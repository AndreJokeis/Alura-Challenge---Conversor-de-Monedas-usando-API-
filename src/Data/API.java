package Data;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class API {
    String uri;
    float base_amount;
    String base_code, target_code;
    Gson gson = new GsonBuilder()
            .setPrettyPrinting()
            .create();

    public API(String base_code, String target_code, float base_amount) {
        this.uri = "https://v6.exchangerate-api.com/v6/851f603d4c2ca9120cfa26c2/pair/" + base_code + "/" + target_code;
        this.base_amount = base_amount;
        this.base_code = base_code;
        this.target_code = target_code;
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

    @Override
    public String toString() {
        try {
            Json jsonEX = gson.fromJson(getQuery(), Json.class);
            float target_amount = Float.parseFloat(jsonEX.conversion_rate());
            return """
                    
                    -----------------------------------------------------
                    El valor de\s""" + base_amount + """
                    (""" + base_code + """
                    ) al valor final en (""" + target_code + """
                    ) es de: $""" + ( target_amount * base_amount ) + """
                    
                    -----------------------------------------------------
                    """;
        } catch (IOException e) {
            return "Error de conexión: Verifica tu internet o la URL.";
        } catch (InterruptedException e) {
            return "La solicitud fue interrumpida inesperadamente.";
        } catch (Exception e) {
            return "Ocurrió un error inesperado: " + e.getMessage();
        }
    }
}
