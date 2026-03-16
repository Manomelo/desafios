package desafio.backend.itau.service;

import desafio.backend.itau.model.Transacao;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.DoubleSummaryStatistics;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

@Service
public class TransacaoService {

    private final Queue<Transacao> transacoes = new ConcurrentLinkedQueue();

    public void addTransacao(Transacao transacao){
        transacoes.add(transacao);
    }

    public void clearTransacoes(){
        transacoes.clear();
    }

    public DoubleSummaryStatistics getStats(){
        OffsetDateTime minusOneMinute = OffsetDateTime.now().minusMinutes(1);

        return transacoes.stream()
                .filter(t -> t.getDataHora().isAfter(minusOneMinute))
                .mapToDouble(Transacao::getValor)
                .summaryStatistics();
    }
}
