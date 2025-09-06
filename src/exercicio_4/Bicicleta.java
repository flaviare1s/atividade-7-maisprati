package exercicio_4;

public class Bicicleta implements  IMeioTransporte{
    private int velocidadeAtual = 0;
    private int VELOCIDADE_MAXIMA = 30;

    @Override
    public int getVelocidadeAtual() {
        return velocidadeAtual;
    }

    @Override
    public void acelerar() {
        if (velocidadeAtual >= VELOCIDADE_MAXIMA) {
            throw new IllegalStateException("Velocidade máxima atingida!");
        }
        velocidadeAtual += 1;
        System.out.println("Bicicleta acelerou para: " + velocidadeAtual + " km/h");
    }

    @Override
    public void frear() {
        System.out.println("Freando a biblicleta...");
    }
}
