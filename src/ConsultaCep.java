import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import com.google.gson.Gson;

public class ConsultaCep {
    public Endereco findAdress(String cep){
        URI adress = URI.create("https://viacep.com.br/ws/"+cep+"/json");
        HttpRequest request = HttpRequest.newBuilder()
                .uri(adress)
                .build();
        try {
            HttpResponse<String> response = HttpClient.
                    newHttpClient()
                    .send(request,
                            HttpResponse
                                    .BodyHandlers
                                    .ofString()
                    );
            return new Gson()
                    .fromJson(
                            response.body(),
                            Endereco.class
                    );
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
