package exercicio_8;

import java.math.BigDecimal;

public class Sedex implements CalculadoraFrete {
    @Override
    public BigDecimal calcular(Pedido pedido) {
        // Exemplo de frete baseado no peso * 2
        return pedido.getPeso().multiply(new BigDecimal("2.0"));
    }
}
