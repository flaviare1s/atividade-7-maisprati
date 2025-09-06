package exercicio_4;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<IMeioTransporte> meiosTransporte = new ArrayList<>();

        meiosTransporte.add(new Bicicleta());
        meiosTransporte.add(new Carro());
        meiosTransporte.add(new Trem());
        meiosTransporte.add(new Carro());

        for (IMeioTransporte meioTransporte : meiosTransporte) {
            meioTransporte.acelerar();
            System.out.println(meioTransporte.getClass().getSimpleName() + " - Velocidade: " + meioTransporte.getVelocidadeAtual() + "km/h");
            meioTransporte.frear();
        }
    }
}
