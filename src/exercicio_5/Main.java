package exercicio_5;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        CartaoCredito cartao = new CartaoCredito("1234123412341234");
        try {
            cartao.processarPagamento(new BigDecimal(100));
        } catch (PagamentoInvalidoException e) {
            System.out.println("Erro ao processar  com cartão: " + e.getMessage());
        }

        Pix pix = new Pix("11111111111");
        try {
            pix.processarPagamento(new BigDecimal(200));
        } catch (PagamentoInvalidoException e) {
            System.out.println("Erro ao processar pagamento com pix: " + e.getMessage());
        }

        Boleto boleto = new Boleto("1111111111111111111111111111");
        try {
            boleto.processarPagamento(new BigDecimal(150));
        } catch (PagamentoInvalidoException e) {
            System.out.println("Erro ao processar pagamento com boleto: " + e.getMessage());
        }
    }
}
