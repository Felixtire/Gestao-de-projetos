package com.gestao.api.api.domain.dto;

import java.util.Date;

public record DadosParaCriarProjeto(String name, String description, Date startDate, Date endDate) {
}
