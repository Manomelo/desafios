package desafio.backend.magalu.model;

import desafio.backend.magalu.enums.StatusAgendamento;
import desafio.backend.magalu.enums.TipoComunicacao;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Agendamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;

    @Column(nullable = false)
    private String destinatario;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String mensagem;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TipoComunicacao tipoComunicacao;

    @Column(nullable = false)
    private LocalDateTime dataHoraEnvio;

    @Enumerated(EnumType.STRING)
    private StatusAgendamento statusAgendamento;

    @Column(nullable = false)
    private LocalDateTime criadoEm;
}
