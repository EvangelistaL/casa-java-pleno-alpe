package com.casealpe.webhookreceiver.api.model;

import java.math.BigDecimal;

public record Boleto(String codBarras, BigDecimal valorBoleto) {
}
