package com.casealpe.nfeapi.api.model;

import java.math.BigDecimal;

public record Boleto(String barCode, BigDecimal value, BoletoStatus status) {
}
