package com.switch_and_trade.switch_and_trade_artifact.servicio;

import com.switch_and_trade.switch_and_trade_artifact.entidad.Vehiculo;
import com.switch_and_trade.switch_and_trade_artifact.repositorio.VehiculoRepositorio;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VehiculoServicio {
    private final VehiculoRepositorio vehiculoRepositorio;

    @Transactional
    public void crear(Vehiculo dto) {

        Vehiculo vehiculo = new Vehiculo();
        vehiculo.setAnio(dto.getAnio());
        vehiculo.setMarca(dto.getMarca());
        vehiculo.setModelo(dto.getModelo());
        vehiculo.setDescripcion(dto.getDescripcion());
        vehiculo.setTipo(dto.getTipo());
        vehiculo.setDeseado(dto.getDeseado());
        vehiculo.setEliminado(dto.getEliminado());
        vehiculo.setPerfil(dto.getPerfil());
        vehiculoRepositorio.save(vehiculo);
    }

    @Transactional
    public void editar(Vehiculo dto) {
        Vehiculo vehiculo = vehiculoRepositorio.findById(dto.getId()).get();
        vehiculo.setAnio(dto.getAnio());
        vehiculo.setMarca(dto.getMarca());
        vehiculo.setModelo(dto.getModelo());
        vehiculo.setDescripcion(dto.getDescripcion());
        vehiculo.setTipo(dto.getTipo());
        vehiculo.setDeseado(dto.getDeseado());
        vehiculo.setEliminado(dto.getEliminado());
        vehiculo.setPerfil(dto.getPerfil());
        vehiculoRepositorio.save(vehiculo);
    }

    @Transactional(readOnly = true)
    public Vehiculo traerPorId(Long id) {
        return vehiculoRepositorio.findById(id).get();
    }

    @Transactional(readOnly = true)
    public List<Vehiculo> traerTodo() {
        return vehiculoRepositorio.findAll();
    }

    @Transactional
    public void eliminarPorId(Long id) {
        vehiculoRepositorio.deleteById(id);
    }

    @Transactional(readOnly = true)
    public List<Vehiculo> traerTodoPorAnio(Integer anio){
        return vehiculoRepositorio.findAllByAnioOrderByAnioAsc(anio);
    }

    @Transactional(readOnly = true)
    public List<Vehiculo> traerTodoPorMarcaOModelo(String marca,String modelo){
        return vehiculoRepositorio.findAllByMarcaOrModeloOrderByMarcaAsc(marca,modelo);
    }

    @Transactional(readOnly = true)
    public List<Vehiculo> traerTodoPorMarcaYModelo(String marca,String modelo){
        return vehiculoRepositorio.findAllByMarcaAndModeloOrderByMarcaAsc(marca,modelo);
    }

    @Transactional(readOnly = true)
    public List<Vehiculo> traerTodoPorTipo(String tipo){
        return vehiculoRepositorio.findAllByTipoOrderByTipoAsc(tipo);
    }

    @Transactional(readOnly = true)
    public List<Vehiculo> traerTodoPorDeseado(Boolean deseado){
        return vehiculoRepositorio.findAllByDeseado(deseado);
    }

}
