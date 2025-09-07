package exercicio_6;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

public final class Carrinho {

    private final List<ItemCarrinho> itens;
    private final double desconto;

    public Carrinho(List<ItemCarrinho> itens, double desconto) {
        this.itens = List.copyOf(itens); // imutável
        if (desconto < 0 || desconto > 30) {
            throw new IllegalArgumentException("Desconto deve ser entre 0 e 30%");
        }
        this.desconto = desconto;
    }

    public Carrinho(List<ItemCarrinho> itens) {
        this(itens, 0);
    }

    public List<ItemCarrinho> getItens() {
        return itens;
    }

    public double getDesconto() {
        return desconto;
    }

    public Carrinho adicionarItem(Produto produto, int quantidade) {
        if (quantidade <= 0) {
            throw new IllegalArgumentException("Quantidade deve ser maior que zero");
        }

        List<ItemCarrinho> novaLista = new ArrayList<>(itens);
        boolean encontrado = false;

        for (int i = 0; i < novaLista.size(); i++) {
            ItemCarrinho item = novaLista.get(i);
            if (item.getProduto().equals(produto)) {
                ItemCarrinho novoItem = new ItemCarrinho(produto, item.getQuantidade() + quantidade);
                novaLista.set(i, novoItem);
                encontrado = true;
                break;
            }
        }

        if (!encontrado) {
            novaLista.add(new ItemCarrinho(produto, quantidade));
        }

        return new Carrinho(novaLista, desconto);
    }

    public Carrinho removerItem(Produto produto) {
        List<ItemCarrinho> novaLista = new ArrayList<>();
        for (ItemCarrinho item : itens) {
            if (!item.getProduto().equals(produto)) {
                novaLista.add(item);
            }
        }
        return new Carrinho(novaLista, desconto);
    }

    public Carrinho aplicarCupom(double porcentagem) {
        if (porcentagem < 0 || porcentagem > 30) {
            throw new IllegalArgumentException("Desconto deve ser entre 0 e 30%");
        }
        return new Carrinho(itens, porcentagem);
    }

    public Dinheiro getTotal() {
        BigDecimal soma = BigDecimal.ZERO;
        Moeda moeda = null;

        for (ItemCarrinho item : itens) {
            soma = soma.add(item.getSubtotal().getValor());
            if (moeda == null) {
                moeda = item.getSubtotal().getMoeda();
            }
        }

        BigDecimal fator = BigDecimal.valueOf(1 - (desconto / 100));
        soma = soma.multiply(fator).setScale(2, RoundingMode.HALF_UP);

        return new Dinheiro(soma, moeda);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Carrinho:\n");
        for (ItemCarrinho item : itens) {
            sb.append(item).append("\n");
        }
        sb.append("Desconto: ").append(desconto).append("%\n");
        sb.append("Total: ").append(getTotal());
        return sb.toString();
    }
}
