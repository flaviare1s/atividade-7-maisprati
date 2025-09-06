package exercicios_1_e_2;

public class Main {
    public static void main(String[] args) {
        Produto produto1 = new Produto("Celular", 1500, 3);
        Produto produto2 = new Produto("Tablet", 2500, 10);
        Produto produto3 = new Produto("Notebook", 5000, 2);

        produto1.setPreco(1750);
        produto2.setQuantidadeEmEstoque(1);

        System.out.println(produto1.getNome() + " - " + produto1.getPreco() + " - " + produto1.getQuantidadeEmEstoque());
        System.out.println(produto2.getNome() + " - " + produto2.getPreco() + " - " + produto2.getQuantidadeEmEstoque());
        System.out.println(produto3.getNome() + " - " + produto3.getPreco() + " - " + produto3.getQuantidadeEmEstoque());

        produto1.aplicarDesconto(10);
        System.out.println("Celular com desconto: " + produto1.getPreco());

        produto2.aplicarDesconto(60);

        produto2.setQuantidadeEmEstoque(-1);
        System.out.println(produto2.getQuantidadeEmEstoque());
    }
}
