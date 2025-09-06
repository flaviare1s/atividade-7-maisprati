package exercicio_3;

import java.math.BigDecimal;

public abstract class Funcionario {
    protected String nome;
    protected BigDecimal salario;

    public Funcionario(String nome, BigDecimal salario) {
        this.nome = nome;
        if (salario.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Salário não pode ser menor do que zero");
        } else {
            this.salario = salario;
        }
    }

    public String getNome() {
        return nome;
    }

    public BigDecimal getSalario() {
        return salario;
    }

    public abstract BigDecimal calcularBonus();
}
