package br.com.dianome.entregadores.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.math.BigInteger;

@Entity
@Table(name = "entregadores")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Entregador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(unique = true)
    @Size(min = 11, max = 11, message = "O CPF deve possuir 11 dígitos.")
    private String cpf;

    @NotBlank
    @Size(max = 100)
    private String nome;

    @NotNull
    @Enumerated(EnumType.STRING)
    private Tipo veiculo;
}
