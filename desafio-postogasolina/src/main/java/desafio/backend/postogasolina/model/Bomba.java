package desafio.backend.postogasolina.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "bomba")
public class Bomba {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome")
    private String nome;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "combustivel_id", nullable = false)
    private Combustivel combustivel;

    @OneToMany(mappedBy = "bomba", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Abastecimento> abastecimentos;
}
