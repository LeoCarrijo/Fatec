package lista5.ex2;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static List<CartaoWeb> cartoes = new ArrayList<CartaoWeb>(); // Dentro desse array, os elementos também são polimórficos, pois basta serem descendesntes do "CartaoWeb" que podem ser incluidos aqui

    public static void ExibirDados(CartaoWeb cartaoWeb){ // Nesta função a variável "cartaoWeb" é polimórfica, pois ela assume a posição do ebjeto Naral, Dia dos Namorados e Aniversário, pois ela na verdade é um objeto Abstrato (CartaoWeb)
        System.out.println(cartaoWeb.toString());
        cartaoWeb.showMessage();
    }

    public static void main(String[] args) {
        cartoes.add(new DiaDosNamorados("Carlos"));
        cartoes.add(new Natal("Carlos"));
        cartoes.add(new Aniversario("Carlos"));

        for(CartaoWeb obj:cartoes){ // Neste looping também ocorre o polimorfismo
            ExibirDados(obj);
        }
    }
}
