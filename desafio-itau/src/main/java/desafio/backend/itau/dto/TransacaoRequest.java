package desafio.backend.itau.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.OffsetDateTime;

@Getter
@Setter
public class TransacaoRequest {

    @NotNull(message = "valor nao pode ser nulo")
    private double valor;

    @NotNull(message = "dataHora na pode ser nulo")
    private OffsetDateTime dataHora;
}
