package exercicio_8;

import java.math.BigDecimal;

public class RetiradaNaloja implements CalculadoraFrete {
    @Override
    public BigDecimal calcular(Pedido pedido) {
        // Frete gratuito
        return BigDecimal.ZERO;
    }
}
