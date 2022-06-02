package com.switch_and_trade.switch_and_trade_artifact.repositorio;

import com.switch_and_trade.switch_and_trade_artifact.entidad.Propiedad;
import com.switch_and_trade.switch_and_trade_artifact.entidad.Vehiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface VehiculoRepositorio extends JpaRepository<Vehiculo, Long> {

    List<Vehiculo> findAllByAnioOrderByAnioAsc(Integer anio);

    List<Vehiculo> findAllByMarcaOrModeloOrderByMarcaAsc(String marca,String modelo);

    List<Vehiculo> findAllByMarcaAndModeloOrderByMarcaAsc(String marca,String modelo);

    List<Vehiculo> findAllByTipoOrderByTipoAsc(String tipo);

    List<Vehiculo> findAllByDeseado(Boolean deseado);

   /* @Modifying
    @Query("UPDATE Vehiculo v SET v.eliminado = false WHERE p.id = ?1")
    void enableById(Long id);*/


}
