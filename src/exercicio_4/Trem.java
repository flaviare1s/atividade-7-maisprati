package exercicio_4;

public class Trem implements IMeioTransporte {
    private int velocidadeAtual = 0;
    private int VELOCIDADE_MAXIMA = 300;

    @Override
    public int getVelocidadeAtual() {
        return velocidadeAtual;
    }

    @Override
    public void acelerar() {
        if (velocidadeAtual >= VELOCIDADE_MAXIMA) {
            throw new IllegalStateException("Velocidade máxima atingida!");
        }
        velocidadeAtual += 20;
        System.out.println("Trem acelerou para: " + velocidadeAtual + " km/h");
    }

    @Override
    public void frear() {
        System.out.println("Freando o trem...");
    }
}
