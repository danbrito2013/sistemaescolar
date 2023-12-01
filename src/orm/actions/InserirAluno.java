package orm.actions;

import javax.persistence.*;
import orm.modelo.Aluno;

import java.util.List;
import java.util.Scanner;

public class InserirAluno {
    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("sistemaescolar");

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Obtenha dados do usuário
        System.out.println("Informe o nome do aluno: ");
        String nome = scanner.nextLine();

        // Continue para os outros atributos

        // Crie uma instância de Aluno com os dados do usuário
        Aluno aluno = new Aluno();
        aluno.setNome(nome);

        System.out.println("Informe o e-mail do aluno: ");
        String email = scanner.nextLine();
        aluno.setEmail(email);

        System.out.println("Informe o CPF do aluno: ");
        String cpf = scanner.nextLine();
        aluno.setCpf(cpf);

        System.out.println("Informe a naturalidade do aluno: ");
        String naturalidade = scanner.nextLine();
        aluno.setNaturalidade(naturalidade);

        System.out.println("Informe o endereço do aluno: ");
        String endereco = scanner.nextLine();
        aluno.setEndereco(endereco);

        // Inserir aluno no banco de dados
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(aluno);
        em.getTransaction().commit();
        em.close();

        // Listar alunos do banco de dados
        EntityManager emListar = emf.createEntityManager();
        List<Aluno> alunos = emListar.createQuery("SELECT a FROM Aluno a", Aluno.class).getResultList();
        emListar.close();

        System.out.println("Lista de Alunos:");
        for (Aluno a : alunos) {
            System.out.println("Nome: " + a.getNome());
            System.out.println("E-mail: " + a.getEmail());
            System.out.println("CPF: " + a.getCpf());
            System.out.println("Naturalidade: " + a.getNaturalidade());
            System.out.println("Endereço: " + a.getEndereco());
        }

        emf.close();
    }
}
