import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner leitura = new Scanner(System.in);
        ConsultaCep consultaCep = new ConsultaCep();
        System.out.println("Digite CEP");
        var cep = leitura.nextLine();
        try {
            Endereco newAdress = consultaCep.findAdress(cep);
            GeradorArquivo gerador = new GeradorArquivo();
            gerador.saveJson(newAdress);
        }catch (RuntimeException | IOException e)
        {
            System.out.println(e.getMessage());
            System.out.println("fim.");
        }
    }
}