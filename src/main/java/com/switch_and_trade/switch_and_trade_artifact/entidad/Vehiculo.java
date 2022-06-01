package com.switch_and_trade.switch_and_trade_artifact.entidad;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

import static javax.persistence.FetchType.EAGER;
import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "vehiculo", indexes = {@Index(name = "idx_tipo_vehiculo", columnList = "tipo_vehiculo")})
public class Vehiculo {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id_vehivulo")
    private Long id;

    @Column(name = "anio_vehiculo", nullable = false)
    private short anio;

    @Column(name = "marca_vehiculo", length = 60, nullable = false)
    private String marca;

    @Column(name = "modelo_vehiculo", length = 60, nullable = false)
    private String modelo;

    @Column(name = "descripcion_vehiculo", columnDefinition = "TEXT", nullable = true)
    private String descripcion;

    @Column(name = "tipo_vehiculo", nullable = false)
    private String tipo;

    @Column(name = "deseado_vehiculo", nullable = false)
    private Boolean deseado;

    @Column(name = "eliminado_vehiculo", nullable = false)
    private Boolean eliminado;

    @ManyToOne(fetch = EAGER)
    @JoinColumn(name = "perfil_vehiculo", referencedColumnName = "id_perfil", nullable = false)
    private Perfil perfil;

}
