package com.casealpe.webhookreceiver.api.model;

import java.math.BigDecimal;
import java.util.List;

public record Nfe(String nfeNumber, List<Involved> involveds, BigDecimal value, List<Boleto> boletos) {
}
