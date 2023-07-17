import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;

public class GeradorArquivo {
    public void saveJson(Endereco adress) throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        FileWriter escrita = new FileWriter(adress.cep()+".json");
        escrita.write(gson.toJson(adress));
        escrita.close();
    }
}
