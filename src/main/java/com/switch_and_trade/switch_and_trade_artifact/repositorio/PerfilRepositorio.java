package com.switch_and_trade.switch_and_trade_artifact.repositorio;

import com.switch_and_trade.switch_and_trade_artifact.entidad.Perfil;
import com.switch_and_trade.switch_and_trade_artifact.entidad.Propiedad;
import com.switch_and_trade.switch_and_trade_artifact.entidad.Vehiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import java.util.List;

import static javax.persistence.FetchType.EAGER;

@Repository
public interface PerfilRepositorio extends JpaRepository<Perfil, Long> {

    List<Perfil> findAllByNombreOrApellidoIgnoreCaseOrderByNombreAsc(String nombre, String apellido);

    List<Perfil> findAllByNombreAndApellidoIgnoreCaseOrderByNombreAsc(String nombre, String apellido);

    List<Perfil> findAllByNombreIgnoreCaseOrderByNombreAsc(String nombre);

    List<Perfil> findAllByApellidoIgnoreCaseOrderByApellidoAsc(String apellido);

    List<Perfil> findAllByLocalidadOrderByLocalidadAsc(String localidad);

    List<Perfil> findAllByProvinciaOrderByProvinciaAsc(String localidad);

   /* @Modifying
    @Query("UPDATE Perfil p SET p.eliminado = false WHERE p.id = ?1")
    void enableById(Long id);*/

    //el repositorio esta en ingles por las palabras reservadas que usa
}
