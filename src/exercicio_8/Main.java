package exercicio_8;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) throws CepInvalidoException {
        CalculadoraFrete fretePromocionalPac = (pedido) -> {
            if (pedido.getValorTotal().compareTo(new BigDecimal("1000")) >= 0) {
                return BigDecimal.ZERO;
            } else {
                return pedido.getPeso().multiply(new BigDecimal("1.5"));
            }
        };

        Pedido pedidoSedex = new Pedido(new BigDecimal("800"), new BigDecimal("10"), "60000-000", new Sedex());
        Pedido pedidoPac = new Pedido(new BigDecimal("1300"), new BigDecimal("5"), "60000-000", new Pac());
        Pedido pedidoRetirada = new Pedido(new BigDecimal("80"), new BigDecimal("3"), "60000-00", new RetiradaNaloja());


        pedidoSedex.validarCep();
        System.out.println("Frete Sedex: " + pedidoSedex.calcularFrete());

        pedidoPac.validarCep();
        System.out.println("Frete inicial Pac: " + pedidoPac.calcularFrete());
        pedidoPac.setCalculadoraFrete(fretePromocionalPac);
        System.out.println("Frete promocional Pac: " + pedidoPac.calcularFrete());

        pedidoRetirada.validarCep();
        System.out.println("Frete Retirada: " + pedidoRetirada.calcularFrete());
    }
}
