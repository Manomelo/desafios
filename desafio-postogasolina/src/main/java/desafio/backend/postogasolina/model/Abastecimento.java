package desafio.backend.postogasolina.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(name = "abastecimento")
@NoArgsConstructor
@AllArgsConstructor
public class Abastecimento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bomba_id", nullable = false)
    private Bomba bomba;

    @Column(name = "data_abastecimento", nullable = false)
    LocalDateTime dataAbastecimento;

    @Column(name = "valor_quantidade", nullable = false)
    private double quantidadeValor;

    @Column(name = "litragem", nullable = false)
    private double litragem;
}
