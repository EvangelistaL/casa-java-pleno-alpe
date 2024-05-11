package com.casealpe.webhookreceiver.internal.usecase;

import com.casealpe.kafkaclient.api.usecase.KafkaClient;
import com.casealpe.webhookreceiver.api.model.Boleto;
import com.casealpe.webhookreceiver.api.model.Nfe;
import com.casealpe.webhookreceiver.api.producer.NfeProducer;
import com.casealpe.webhookreceiver.api.usecase.ReceiveNfe;
import com.opencsv.bean.CsvToBeanBuilder;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class DefaultReceiveNfe implements ReceiveNfe {

    private final NfeProducer nfeProducer;

    @Override
    public List<Nfe> execute(byte[] bytes) {
        List<Nfe> nfes = new ArrayList<>();
        try {
            ByteArrayInputStream inputStream = new ByteArrayInputStream(bytes);
            List<Nfe> csvDataList = new CsvToBeanBuilder<Nfe>(new InputStreamReader(inputStream))
                    .withType(Nfe.class)
                    .build()
                    .parse();

            for (Nfe nfe : csvDataList) {
                for (Boleto boletoData : nfe.boletos()) {
                    Boleto boleto = new Boleto(boletoData.barCode(), boletoData.value());
                    Nfe nfeBuild = new Nfe(nfe.nfeNumber(), nfe.involveds(), nfe.value(), nfe.installments(), List.of(boleto));
                    nfeProducer.produce(nfeBuild);
                    nfes.add(nfeBuild);
                }
            }
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return nfes;
    }
}
