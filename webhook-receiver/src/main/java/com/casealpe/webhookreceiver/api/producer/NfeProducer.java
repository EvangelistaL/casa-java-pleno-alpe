package com.casealpe.webhookreceiver.api.producer;

import com.casealpe.webhookreceiver.api.model.Nfe;

public interface NfeProducer {

    void produce(Nfe nfe);
}
