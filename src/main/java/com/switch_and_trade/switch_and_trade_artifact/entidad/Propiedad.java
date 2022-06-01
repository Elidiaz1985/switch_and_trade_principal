package com.switch_and_trade.switch_and_trade_artifact.entidad;


import lombok.Generated;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;

import javax.persistence.*;

import static javax.persistence.FetchType.EAGER;
import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Setter
@Getter
@NoArgsConstructor
@Table(name = "propiedad", indexes = {@Index(name = "idx_tipo_propiedad", columnList = "tipo_propiedad")})
@SQLDelete(sql = "UPDATE propiedad SET deleted = true WHERE id = ?")
public class Propiedad {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id_propiedad")
    private Long id;
    
    @Column(name="provincia_propiedad", length = 25, nullable = false)
    private String provincia;

    @Column(name="localidad_propiedad", length = 100, nullable = false)
    private String localidad;

    @Column(name="superficie_propiedad", nullable = false)
    private Integer superficie;

    @Column(name="descripcion_propiedad", columnDefinition = "TEXT", nullable = true)
    private String descripcion;

    @Column(name="tipo_propiedad", nullable = false)
    private String tipo;

    @Column(name = "deseado_propiedad", nullable = false)
    private Boolean deseado;

    @Column(name = "eliminado_propiedad", nullable = false)
    private Boolean eliminado;

    @ManyToOne(fetch = EAGER)
    @JoinColumn(name = "propiedad_perfil", referencedColumnName = "id_perfil", nullable = false)
    private Perfil perfil;

}
