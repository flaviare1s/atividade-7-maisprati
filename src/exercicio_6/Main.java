package exercicio_6;

import java.math.BigDecimal;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Produto arroz = new Produto("Arroz", new Dinheiro(new BigDecimal("10.50"), Moeda.BRL));
        Produto feijao = new Produto("Feijão", new Dinheiro(new BigDecimal("8.25"), Moeda.BRL));
        Produto leite = new Produto("Leite", new Dinheiro(new BigDecimal("5.00"), Moeda.BRL));
        Carrinho carrinho = new Carrinho(new ArrayList<>());

        carrinho = carrinho.adicionarItem(arroz, 2);
        carrinho = carrinho.adicionarItem(feijao, 3);
        carrinho = carrinho.adicionarItem(leite, 1);

        System.out.println("Carrinho após adicionar itens:");
        System.out.println(carrinho);
        System.out.println();

        carrinho = carrinho.removerItem(feijao);
        System.out.println("Carrinho após remover feijão:");
        System.out.println(carrinho);
        System.out.println();

        carrinho = carrinho.aplicarCupom(20);
        System.out.println("Carrinho após aplicar cupom de 20%:");
        System.out.println(carrinho);
        System.out.println();

        try {
            carrinho = carrinho.aplicarCupom(50);
        } catch (IllegalArgumentException e) {
            System.out.println("Erro ao aplicar cupom: " + e.getMessage());
        }
    }
}
