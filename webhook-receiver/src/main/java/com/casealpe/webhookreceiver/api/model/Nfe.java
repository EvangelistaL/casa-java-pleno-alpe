package com.casealpe.webhookreceiver.api.model;

import java.util.List;

public record Nfe(String numeroNfe, String cnpj, List<Boleto> boletos) {
}
