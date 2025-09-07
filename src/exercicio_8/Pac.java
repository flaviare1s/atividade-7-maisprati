package exercicio_8;

import java.math.BigDecimal;

public class Pac implements CalculadoraFrete {
    @Override
    public BigDecimal calcular(Pedido pedido) {
        // Exemplo de frete baseado no peso * 1.5
        return pedido.getPeso().multiply(new BigDecimal("1.5"));
    }
}
