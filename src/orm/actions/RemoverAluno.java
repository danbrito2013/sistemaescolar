package orm.actions;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import orm.modelo.Aluno;

import java.util.Scanner;

public class RemoverAluno {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("sistemaescolar");
        EntityManager manager = factory.createEntityManager();

        Scanner scanner = new Scanner(System.in);

        System.out.println("Informe o ID do aluno a ser removido: ");
        long alunoId = scanner.nextLong();

        Aluno aluno = manager.find(Aluno.class, alunoId);

        if (aluno != null) {
            manager.getTransaction().begin();

            manager.remove(aluno);

            manager.getTransaction().commit();

            System.out.println("Aluno removido com sucesso.");
        } else {
            System.out.println("Aluno não encontrado para o ID informado.");
        }

        manager.close();
        factory.close();
        scanner.close();
    }
}
