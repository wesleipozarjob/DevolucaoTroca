package br.com.dev.model;

import java.util.List;

public record ImpressaoDTO(Cliente cliente, Nota nota, List<Produto> produtos) {

}
