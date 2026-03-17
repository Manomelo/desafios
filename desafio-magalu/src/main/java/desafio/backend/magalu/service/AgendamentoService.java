package desafio.backend.magalu.service;

import desafio.backend.magalu.dto.AgendamentoRequestDTO;
import desafio.backend.magalu.dto.AgendamentoResponseDTO;
import desafio.backend.magalu.enums.StatusAgendamento;
import desafio.backend.magalu.model.Agendamento;
import desafio.backend.magalu.repository.AgendamentoRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class AgendamentoService {
    private final AgendamentoRepository repository;


    public AgendamentoResponseDTO agendar(AgendamentoRequestDTO request){
        Agendamento agendamento = new Agendamento();
        agendamento.setDestinatario(request.destinatario());
        agendamento.setMensagem(request.mensagem());
        agendamento.setTipoComunicacao(request.tipoComunicacao());
        agendamento.setStatusAgendamento(StatusAgendamento.AGENDADO);
        agendamento.setDataHoraEnvio(request.dataHoraEnvio());
        agendamento.setCriadoEm(LocalDateTime.now());

        return toResponse(repository.save(agendamento));
    }

    public AgendamentoResponseDTO findById(Long id){
        Agendamento agendamento = repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Agendamento nao encontrado"));
        return toResponse(agendamento);
    }

    public void remover(Long id){
        if(!repository.existsById(id)){
            throw new EntityNotFoundException("Agendamento nao encontrado");
        }

        repository.deleteById(id);
    }

    public AgendamentoResponseDTO toResponse(Agendamento agendamento){
        return new AgendamentoResponseDTO(
                agendamento.getId(),
                agendamento.getDestinatario(),
                agendamento.getMensagem(),
                agendamento.getTipoComunicacao(),
                agendamento.getDataHoraEnvio(),
                agendamento.getStatusAgendamento(),
                agendamento.getCriadoEm()
        );
    }


}
