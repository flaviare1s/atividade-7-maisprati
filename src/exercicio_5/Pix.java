package exercicio_5;

import java.math.BigDecimal;

public class Pix extends FormaPagamento {
    private String chavePix;

    public Pix(String chavePix) {
        this.chavePix = chavePix;
    }

    @Override
    public void validarPagamento() throws PagamentoInvalidoException {
        if (chavePix == null || chavePix.isEmpty()) {
            throw new PagamentoInvalidoException("Chave Pix não pode ser vazia.");
        }

        if (!(chavePix.matches("\\d{11}") || // Regex para validar CPF
                chavePix.matches("\\d{14}") || // CNPJ
                chavePix.matches(".+@.+\\..+") || // Email
                chavePix.matches("\\+\\d{12,14}") || // Telefone
                chavePix.matches("[0-9a-fA-F\\-]{36}"))) { // UUID
            throw new PagamentoInvalidoException("Chave Pix inválida.");
        }
    }

    @Override
    public void processarPagamento(BigDecimal valor) throws PagamentoInvalidoException {
        validarPagamento();
        System.out.println("Pagamento via Pix de R$ " + valor + " realizado com sucesso para chave: " + chavePix);
    }
}
