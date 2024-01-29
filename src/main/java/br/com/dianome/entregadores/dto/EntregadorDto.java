package br.com.dianome.entregadores.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigInteger;
import br.com.dianome.entregadores.model.Tipo;

@Getter
@Setter
public class EntregadorDto {

    private Long id;

    private BigInteger cpf;

    private String nome;

    private Tipo veiculo;
}
