package desafio.backend.magalu.dto;

import desafio.backend.magalu.enums.TipoComunicacao;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record AgendamentoRequestDTO(
        @NotBlank(message = "Destinatario nao pode ser vazio")
        String destinatario,

        @NotBlank(message = "Mensagem nao pode ser vazio")
        String mensagem,

        @NotBlank(message = "Tipo de comunicacao nao pode ser vazio")
        TipoComunicacao tipoComunicacao,

        @NotNull(message = "A data e hora de envio nao pode ser vazio")
        @Future(message = "A data e hora de envio deve ser futura!")
        LocalDateTime dataHoraEnvio
) {}
