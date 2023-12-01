package orm.actions;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import orm.modelo.Aluno;

public class RemoverAluno {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("sistemaescolar");
        EntityManager manager = factory.createEntityManager();

        Aluno aluno = manager.find(Aluno.class, 2L);

        if (aluno != null) {
            manager.getTransaction().begin();

            manager.remove(aluno);

            manager.getTransaction().commit();

            System.out.println("Aluno removido com sucesso.");
        } else {
            System.out.println("Aluno não encontrado.");
        }

        manager.close();
        factory.close();
    }
}
