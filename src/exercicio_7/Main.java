package exercicio_7;

public class Main {
    public static void main(String[] args) {
        IRepository<Produto, String> produtoRepo = new InMemoryRepository<>();

        produtoRepo.salvar(new Produto("1", "Notebook", 5000));
        produtoRepo.salvar(new Produto("2", "Tablet", 3000));
        produtoRepo.salvar(new Produto("3", "Celular", 2000));

        System.out.println("Produtos:");
        produtoRepo.listarTodos().forEach(System.out::println);

        System.out.println("Buscar produto 1: " + produtoRepo.buscarPorId("1").orElse(null));

        try {
            produtoRepo.remover("4");
        } catch (EntidadeNaoEncontradaException e) {
            System.out.println("Erro: " + e.getMessage());
        }

        IRepository<Funcionario, Integer> funcionarioRepo = new InMemoryRepository<>();

        funcionarioRepo.salvar(new Funcionario(1, "Maria", "Gerente"));
        funcionarioRepo.salvar(new Funcionario(2, "João", "Analista"));

        System.out.println("\nFuncionários:");
        funcionarioRepo.listarTodos().forEach(System.out::println);

        System.out.println("Buscar id=2: " + funcionarioRepo.buscarPorId(2).orElse(null));
    }
}
