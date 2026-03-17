package desafio.backend.magalu.controller;


import desafio.backend.magalu.dto.AgendamentoRequestDTO;
import desafio.backend.magalu.dto.AgendamentoResponseDTO;
import desafio.backend.magalu.service.AgendamentoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/agendamento")
@RequiredArgsConstructor
public class AgendamentoController {

    private final AgendamentoService agendamentoService;

    @PostMapping
    public ResponseEntity<AgendamentoResponseDTO> agendar(AgendamentoRequestDTO requestDTO){
        AgendamentoResponseDTO responseDTO = agendamentoService.agendar(requestDTO);

        return ResponseEntity.ok(responseDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AgendamentoResponseDTO> findById(@PathVariable Long id){
        AgendamentoResponseDTO responseDTO = agendamentoService.findById(id);

        return ResponseEntity.ok(responseDTO);

    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> remover(@PathVariable Long id){
        agendamentoService.remover(id);

        return ResponseEntity.noContent().build();
    }
}
