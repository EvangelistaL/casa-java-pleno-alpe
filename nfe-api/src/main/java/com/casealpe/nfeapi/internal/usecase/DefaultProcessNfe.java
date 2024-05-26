package com.casealpe.nfeapi.internal.usecase;

import com.casealpe.nfeapi.api.entity.Nfe;
import com.casealpe.nfeapi.api.exception.InvalidNfeException;
import com.casealpe.nfeapi.api.model.Involved;
import com.casealpe.nfeapi.api.producer.BoletoProducer;
import com.casealpe.nfeapi.api.repository.InvolvedRepository;
import com.casealpe.nfeapi.api.specification.InvolvedSpecification;
import com.casealpe.nfeapi.api.usecase.CreateNfe;
import com.casealpe.nfeapi.api.usecase.NfeValidatorApi;
import com.casealpe.nfeapi.api.usecase.ProcessNfe;
import com.casealpe.nfeapi.api.usecase.RetrieveCostumerApi;
import com.casealpe.nfeapi.internal.utils.ConvertNfeDtoToEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DefaultProcessNfe implements ProcessNfe {

    private final NfeValidatorApi nfeValidator;

    private final RetrieveCostumerApi retrieveCostumerApi;

    private final InvolvedRepository involvedRepository;

    private final BoletoProducer boletoProducer;

    private final CreateNfe createNfe;

    @Override
    public Nfe execute(com.casealpe.nfeapi.api.model.Nfe nfe) {
        isAValidNfe(nfe);
        List<com.casealpe.nfeapi.api.entity.Involved> involveds = nfe.involveds().stream()
                .map(this::retrieveCostumer)
                .toList();
        Nfe nfeTransformed = ConvertNfeDtoToEntity.convert(nfe);
        setInvolveds(involveds, nfeTransformed);
        sendBoletoEvent(nfeTransformed);
        return createNfe.execute(nfeTransformed);
    }

    private void isAValidNfe(com.casealpe.nfeapi.api.model.Nfe nfe){
         if (!nfeValidator.execute(nfe)){
             throw new InvalidNfeException();
         }
    }

    private com.casealpe.nfeapi.api.entity.Involved retrieveCostumer(Involved involved){
        return retrieveCostumerApi.execute(involved);
    }

    private void setInvolveds(List<com.casealpe.nfeapi.api.entity.Involved> involveds,
                                            Nfe nfe){
        List<com.casealpe.nfeapi.api.entity.Involved> involvedsToSet = new ArrayList<>();
        for(com.casealpe.nfeapi.api.entity.Involved involved : involveds){
            Optional<com.casealpe.nfeapi.api.entity.Involved> involvedReturned =
                    this.involvedRepository.findOne(InvolvedSpecification.findByIdentificationValue(involved.getIdentificationValue()));
            if (involvedReturned.isEmpty()){
                involvedsToSet.add(involved);
            } else {
                involvedsToSet.add(involvedReturned.get());
            }
        }
        nfe.setInvolveds(involvedsToSet);
    }

    private void sendBoletoEvent(Nfe nfe){
        if (!nfe.getBoletos().isEmpty()){
            nfe.getBoletos().forEach(boletoProducer::sendBoletoEvent);
        }
    }
}
