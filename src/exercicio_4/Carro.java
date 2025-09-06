package exercicio_4;

public class Carro implements IMeioTransporte {
    private int velocidadeAtual = 0;
    private int VELOCIDADE_MAXIMA = 60;

    @Override
    public int getVelocidadeAtual() {
        return velocidadeAtual;
    }

    @Override
    public void acelerar() {
        if (velocidadeAtual >= VELOCIDADE_MAXIMA) {
            throw new IllegalStateException("Velocidade máxima atingida!");
        }
        velocidadeAtual += 10;
        System.out.println("Carro acelerou para: " + velocidadeAtual + " km/h");
    }

    @Override
    public void frear() {
        System.out.println("Freando o carro...");
    }
}
