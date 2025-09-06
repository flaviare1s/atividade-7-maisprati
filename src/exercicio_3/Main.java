package exercicio_3;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Funcionario> funcionarios = new ArrayList<>();

        funcionarios.add(new Gerente("Júlia", new BigDecimal("15000")));
        funcionarios.add(new Desenvolvedor("Paulo", new BigDecimal("7000")));
        funcionarios.add(new Desenvolvedor("Lúcia", new BigDecimal("7000")));

        for (Funcionario funcionario : funcionarios) {
            System.out.println(funcionario.getNome() + " - Bônus: " + funcionario.calcularBonus());
        }
    }
}
