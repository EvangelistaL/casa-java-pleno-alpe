package com.casealpe.webhookreceiver.api.usecase;

import com.casealpe.webhookreceiver.api.model.Nfe;

import java.util.List;

public interface ReceiveNfe {

    List<Nfe> execute(byte[] bytes);
}
