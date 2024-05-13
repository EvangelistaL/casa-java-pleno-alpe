package com.casealpe.webhookreceiver.internal.usecase;


import com.casealpe.webhookreceiver.api.model.Nfe;
import com.casealpe.webhookreceiver.api.model.NotasFiscais;
import com.casealpe.webhookreceiver.api.producer.NfeProducer;
import com.casealpe.webhookreceiver.api.usecase.ReceiveNfe;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.ByteArrayInputStream;
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
            JAXBContext jaxbContext = JAXBContext.newInstance(NotasFiscais.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            ByteArrayInputStream inputStream = new ByteArrayInputStream(bytes);
            NotasFiscais notasFiscais = (NotasFiscais) unmarshaller.unmarshal(inputStream);

            notasFiscais.nfes().forEach(nfeProducer::produce);
            nfes = notasFiscais.nfes();
        } catch (JAXBException e) {
            log.error(e.getMessage());
        }
        return nfes;
    }
}
