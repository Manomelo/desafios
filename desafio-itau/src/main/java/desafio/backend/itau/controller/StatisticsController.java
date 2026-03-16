package desafio.backend.itau.controller;

import desafio.backend.itau.dto.StatisticsResponse;
import desafio.backend.itau.service.TransacaoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.DoubleSummaryStatistics;

@RestController
@RequestMapping("/estatistica")
public class StatisticsController {

    private final TransacaoService transacaoService;

    public StatisticsController(TransacaoService transacaoService){
        this.transacaoService = transacaoService;
    }

    @GetMapping
    public ResponseEntity<StatisticsResponse> getStatistics(){
        DoubleSummaryStatistics stats = transacaoService.getStats() ;

        return ResponseEntity.ok(new StatisticsResponse(stats));
    }
}
