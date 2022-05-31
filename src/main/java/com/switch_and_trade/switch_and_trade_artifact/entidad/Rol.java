package com.switch_and_trade.switch_and_trade_artifact.entidad;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name="rol")
@Getter
@Setter
@NoArgsConstructor
public class Rol {
    @Id
    @GeneratedValue(strategy =IDENTITY)
    @Column(name="id_rol")
    private Long id;
    @Column(name="nombre_rol", length = 30, nullable = false)
    private String nombre;
}
