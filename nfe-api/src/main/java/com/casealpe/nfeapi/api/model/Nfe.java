package com.casealpe.nfeapi.api.model;

import java.math.BigDecimal;
import java.util.List;

public record Nfe(String nfeNumber, NfeStatus status, List<Involved> involveds, BigDecimal value, List<Boleto> boletos) {
}
