package desafio.backend.postogasolina.dao;

import desafio.backend.postogasolina.model.Combustivel;
import jakarta.persistence.EntityManager;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Optional;

@NoArgsConstructor
@AllArgsConstructor
public class CombustivelDAO {

    private EntityManager em;

    public void salvar(Combustivel combustivel) {
        em.getTransaction().begin();
        em.persist(combustivel);
        em.getTransaction().commit();
    }

    public Optional<Combustivel> buscarPorId(Long id) {
        return Optional.ofNullable(em.find(Combustivel.class, id));
    }

    public List<Combustivel> listarTodos() {
        return em.createQuery(
                "select t from Combustivel t order by t.nome",
                Combustivel.class
        ).getResultList();
    }

    public Optional<Combustivel> buscarPorNome(String nome) {
        return em.createQuery(
                        "select t from Combustivel t where lower(t.nome) = lower(:nome)",
                        Combustivel.class
                )
                .setParameter("nome", nome)
                .getResultStream()
                .findFirst();
    }

    public void atualizar(Combustivel combustivel){
        em.getTransaction().begin();
        em.merge(combustivel);
        em.getTransaction().commit();
    }

    public void deletar(Long id){
        buscarPorId(id).ifPresent(tipo ->{
            em.getTransaction().begin();
            em.remove(id);
            em.getTransaction().commit();
        });
    }
}
