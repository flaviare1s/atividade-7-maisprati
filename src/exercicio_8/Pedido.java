package exercicio_8;

import java.math.BigDecimal;

public class Pedido {
    private BigDecimal valorTotal;
    private BigDecimal peso;
    private String CEP;
    private CalculadoraFrete calculadoraFrete;

    public Pedido(BigDecimal valorTotal, BigDecimal peso, String CEP, CalculadoraFrete calculadoraFrete) {
        this.valorTotal = valorTotal;
        this.peso = peso;
        this.CEP = CEP;
        this.calculadoraFrete = calculadoraFrete;
    }

    public void validarCep() throws CepInvalidoException {
        if (CEP == null || !CEP.matches("\\d{5}-\\d{3}")) {
            throw new CepInvalidoException("CEP inválido: " + CEP);
        }
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }

    public BigDecimal getPeso() {
        return peso;
    }

    public void setPeso(BigDecimal peso) {
        this.peso = peso;
    }

    public String getCEP() {
        return CEP;
    }

    public void setCEP(String CEP) {
        this.CEP = CEP;
    }

    public CalculadoraFrete getCalculadoraFrete() {
        return calculadoraFrete;
    }

    public void setCalculadoraFrete(CalculadoraFrete calculadoraFrete) {
        this.calculadoraFrete = calculadoraFrete;
    }

    public BigDecimal calcularFrete() throws CepInvalidoException {
        validarCep();
        if (calculadoraFrete == null) {
            throw new IllegalStateException("Nenhuma estratégia de frete definida!");
        }
        return calculadoraFrete.calcular(this);
    }
}
