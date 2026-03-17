package desafio.backend.postogasolina.dao;

import desafio.backend.postogasolina.model.Bomba;
import jakarta.persistence.EntityManager;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
public class BombaDAO {
    private EntityManager em;

    public void salvar(Bomba bomba) {
        em.getTransaction().begin();
        em.persist(bomba);
        em.getTransaction().commit();
    }

    public Optional<Bomba> buscarPorId(Long id) {
        return Optional.ofNullable(em.find(Bomba.class, id));
    }

    public List<Bomba> listarTodas() {
        return em.createQuery(
                "select b from Bomba b JOIN fetch b.combustivel order by b.nome",
                Bomba.class
        ).getResultList();
    }

    public List<Bomba> listarPorCombustivel(Long combustivelId) {
        return em.createQuery(
                        "SELECT b FROM Bomba b join fetch b.combustivel c where c.id = :combustivelId order by c.nome",
                        Bomba.class
                )
                .setParameter("combustivelId", combustivelId)
                .getResultList();
    }

    public Optional<Bomba> buscarPorNome(String nome) {
        return em.createQuery(
                        "select b from Bomba b where lower(b.nome) = lower(:nome)",
                        Bomba.class
                )
                .setParameter("nome", nome)
                .getResultStream()
                .findFirst();
    }

    public void atualizar(Bomba bomba){
        em.getTransaction().begin();
        em.merge(bomba);
        em.getTransaction().commit();
    }
}
