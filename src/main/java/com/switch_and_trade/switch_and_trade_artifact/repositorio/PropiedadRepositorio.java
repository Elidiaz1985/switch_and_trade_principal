package com.switch_and_trade.switch_and_trade_artifact.repositorio;

import com.switch_and_trade.switch_and_trade_artifact.entidad.Perfil;
import com.switch_and_trade.switch_and_trade_artifact.entidad.Propiedad;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PropiedadRepositorio {

    List<Propiedad> findAllByLocalidadIgnoreCaseOrderByLocalidadAsc(String localidad);

    List<Propiedad> findAllByProvinciaIgnoreCaseOrderByProvinciaAsc(String provincia);

    List<Propiedad> findAllBySuperficieOrderBySuperficieAsc(Integer superficie);

    List<Propiedad> findAllByTipoOrderByTipoAsc(String tipo);

    List<Propiedad> findAllByDeseado(Boolean deseado);

    @Modifying
    @Query("UPDATE Propiedad p SET p.eliminado = false WHERE p.id = ?1")
    void enableById(Long id);

}
