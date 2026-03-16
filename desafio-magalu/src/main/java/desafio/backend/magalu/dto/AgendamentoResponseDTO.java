package desafio.backend.magalu.dto;

import desafio.backend.magalu.enums.StatusAgendamento;
import desafio.backend.magalu.enums.TipoComunicacao;

import java.time.LocalDateTime;

public record AgendamentoResponseDTO(
        Long id,
        String destinatario,
        String mensagem,
        TipoComunicacao tipoComunicacao,
        LocalDateTime dataHoraEnvio,
        StatusAgendamento statusAgendamento,
        LocalDateTime criadoEm
) {
}
