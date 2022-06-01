package com.switch_and_trade.switch_and_trade_artifact.entidad;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import net.bytebuddy.dynamic.loading.InjectionClassLoader;
import org.hibernate.annotations.SQLDelete;
import org.springframework.boot.autoconfigure.web.ConditionalOnEnabledResourceChain;

import javax.persistence.*;

import static javax.persistence.FetchType.EAGER;
import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Setter
@Getter
@NoArgsConstructor
@Table(name = "usuario", indexes = {@Index(name = "idx_email_usuario", columnList = "email_usuario")})
@SQLDelete(sql = "UPDATE usuario SET deleted = true WHERE id = ?")
public class Usuario {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id_usuario")
    private Long id;

    @Column(name = "email_usuario", length = 60, unique = true, nullable = false)
    private String email;

    @Column(name = "clave_usuario", nullable = false)
    private String clave;

    @ManyToOne(fetch = EAGER)
    @JoinColumn(name = "rol_usuario", referencedColumnName = "id_rol")
    private Rol rol;

    @OneToOne(fetch = EAGER)
    @JoinColumn(name = "perfil_usuario", referencedColumnName = "id_perfil")
    private Perfil perfil;

    @Column(name = "eliminado_usuario", nullable = false)
    private Boolean eliminado;

}
