package com.switch_and_trade.switch_and_trade_artifact.servicio;

import com.switch_and_trade.switch_and_trade_artifact.entidad.Propiedad;
import com.switch_and_trade.switch_and_trade_artifact.repositorio.PropiedadRepositorio;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Service
@RequiredArgsConstructor
public class PropiedadServicio {

    private final PropiedadRepositorio propiedadRepositorio;

    @Transactional
    public void crear(Propiedad dto) {
        Propiedad propiedad = new Propiedad();

        propiedad.setProvincia(dto.getProvincia());
        propiedad.setLocalidad(dto.getLocalidad());
        propiedad.setSuperficie(dto.getSuperficie());
        propiedad.setDescripcion(dto.getDescripcion());
        propiedad.setTipo(dto.getTipo());
        propiedad.setDeseado(dto.getDeseado());
        propiedad.setEliminado(dto.getEliminado());
        propiedad.setPerfil(dto.getPerfil());

        propiedadRepositorio.save(propiedad);
    }

    @Transactional
    public void editar(Propiedad dto) {
        Propiedad propiedad = propiedadRepositorio.findById(dto.getId()).get();

        propiedad.setProvincia(dto.getProvincia());
        propiedad.setLocalidad(dto.getLocalidad());
        propiedad.setSuperficie(dto.getSuperficie());
        propiedad.setDescripcion(dto.getDescripcion());
        propiedad.setTipo(dto.getTipo());
        propiedad.setDeseado(dto.getDeseado());
        propiedad.setEliminado(dto.getEliminado());
        propiedad.setPerfil(dto.getPerfil());

        propiedadRepositorio.save(propiedad);
    }

    @Transactional(readOnly = true)
    public Propiedad traerPorId(Long id) {
        return propiedadRepositorio.findById(id).get();
    }

    @Transactional(readOnly = true)
    public List<Propiedad> traerTodo() {
        return propiedadRepositorio.findAll();
    }

    @Transactional(readOnly = true)
    public List<Propiedad> traerTodoPorLocalidad(String localidad) {
        return propiedadRepositorio.findAllByLocalidadIgnoreCaseOrderByLocalidadAsc(localidad);
    }

    @Transactional(readOnly = true)
    public List<Propiedad> traerTodoPorProvincia(String provincia) {
        return propiedadRepositorio.findAllByProvinciaIgnoreCaseOrderByProvinciaAsc(provincia);
    }

    @Transactional(readOnly = true)
    public List<Propiedad> traerTodoPorSuperficie(Integer superficie) {
        return propiedadRepositorio.findAllBySuperficieOrderBySuperficieAsc(superficie);
    }

    @Transactional(readOnly = true)
    public List<Propiedad> traerTodoPorTipo(String tipo) {
        return propiedadRepositorio.findAllByTipoOrderByTipoAsc(tipo);
    }

    @Transactional(readOnly = true)
    public List<Propiedad> traerTodoPorDesdeado(Boolean deseado) {
        return propiedadRepositorio.findAllByDeseado(deseado);
    }

}
