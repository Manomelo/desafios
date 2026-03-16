package desafio.backend.itau.controller;

import desafio.backend.itau.dto.TransacaoRequest;
import desafio.backend.itau.model.Transacao;
import desafio.backend.itau.service.TransacaoService;
import jakarta.validation.Valid;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.OffsetDateTime;

@RestController
@RequestMapping("/transacao")
public class TransacaoController {

    private final TransacaoService transacaoService;

    public TransacaoController(TransacaoService transacaoService){
        this.transacaoService = transacaoService;
    }

    @PostMapping
    public ResponseEntity<Void> createTransacao(@Valid @RequestBody TransacaoRequest request){
        if(request.getDataHora().isAfter(OffsetDateTime.now()) || request.getValor() < 0){
            return ResponseEntity.unprocessableEntity().build();
        }

        transacaoService.addTransacao(new Transacao(request.getValor(), request.getDataHora()));
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping
    public ResponseEntity<Void> clearTransacao(){
        transacaoService.clearTransacoes();
        return ResponseEntity.status(HttpStatus.OK).build();
    }


}
